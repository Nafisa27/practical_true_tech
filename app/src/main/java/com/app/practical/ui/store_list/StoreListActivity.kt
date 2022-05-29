package com.app.practical.ui.store_list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.practical.BR
import com.app.practical.R
import com.app.practical.base.BaseActivity
import com.app.practical.databinding.ActivityStoreListBinding
import com.app.practical.ktx.gone
import com.app.practical.ktx.isNetworkConnected
import com.app.practical.ktx.visible
import com.app.practical.model.StoreModel
import com.app.practical.ui.store_detail.StoreDetailActivity
import com.app.practical.ui.store_list.adapter.StoreListAdapter
import com.app.practical.ui.store_list.adapter.onItemClickListener
import com.app.practical.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreListActivity : BaseActivity<ActivityStoreListBinding, StoreListViewModel>(),
    onItemClickListener {

    override val layoutId = R.layout.activity_store_list

    override val bindingVariable = BR.viewModel

    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var offset = 0

    lateinit var adapter: StoreListAdapter

    override fun setUpObserver() {
        mViewModel.newsResponseObservable.observe(this) {
                binding.progressCircular.gone()
                adapter =
                    StoreListAdapter(it.franquicias?.toMutableList()?: mutableListOf(), this@StoreListActivity, this)
                binding.rvUsers.adapter = adapter
        }
    }

    override fun init() {
        binding.apply {
            adapter =
                StoreListAdapter(mutableListOf(), this@StoreListActivity, this@StoreListActivity)
            rvUsers.adapter = adapter

            val layoutManager = rvUsers.layoutManager as LinearLayoutManager
            rvUsers.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
                override fun isLastPage(): Boolean {
                    return isLastPage
                }

                override fun isLoading(): Boolean {
                    return isLoading
                }

                override fun loadMoreItems() {
                    isLoading = true
                    offset++

                    callUserListApi(offset * 10)
                }
            })
        }
        callUserListApi(offset)
    }

    private fun callUserListApi(offset: Int) {
        if (isNetworkConnected()) {
            binding.progressCircular.visible()
            mViewModel.getMainList(offset = offset)
        } else {
            showSnackbar("Internet is not connected...")
        }
    }

    override fun onClick(data: StoreModel.Franquicia) {
        val intent = Intent(this, StoreDetailActivity::class.java)
        intent.putExtra("apikey", data.aPIKEY)
        startActivity(intent)
    }

}