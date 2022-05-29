package com.app.practical.ui.store_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.practical.base.BaseViewModel
import com.app.practical.model.StoreModel
import com.app.practical.network.APIConstant
import com.app.practical.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class StoreListViewModel @Inject constructor(private val repository: UserRepository) : BaseViewModel() {

    val newsResponseObservable: MutableLiveData<StoreModel> = MutableLiveData()

    fun getMainList(offset: Int = 1, limit: Int = 10) {
        var response: Response<StoreModel>? = null
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                response = repository.getStoreList()
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