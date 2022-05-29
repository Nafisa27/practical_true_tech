package com.app.practical.ui.store_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.practical.base.BaseViewModel
import com.app.practical.model.StoreDetailModel
import com.app.practical.network.APIConstant
import com.app.practical.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class StoreDetailViewModel @Inject constructor(private val repository: UserRepository)  : BaseViewModel() {
     val newsResponseObservable: MutableLiveData<StoreDetailModel> = MutableLiveData()

    fun getStoreDetailList(apikey:String?) {
        var response: Response<StoreDetailModel>? = null
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                response = repository.getStoreDetailList(apikey)
            }
            withContext(Dispatchers.Main) {
                response?.run {
                    if (isSuccessful && code() == APIConstant.STATUS_SUCCESS)
                        newsResponseObservable.postValue(this.body())
                }
            }
        }
    }
}