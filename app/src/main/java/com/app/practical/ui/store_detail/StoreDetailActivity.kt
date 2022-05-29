package com.app.practical.ui.store_detail

import android.os.Bundle
import android.util.Log
import com.app.practical.BR
import com.app.practical.R
import com.app.practical.base.BaseActivity
import com.app.practical.databinding.ActivityStoreDetailBinding
import com.app.practical.ktx.gone
import com.app.practical.ktx.isNetworkConnected
import com.app.practical.ktx.visible

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreDetailActivity : BaseActivity<ActivityStoreDetailBinding, StoreDetailViewModel>() {

    override val layoutId = R.layout.activity_store_detail

    override val bindingVariable = BR.viewModel

    private var data : String? = ""
    lateinit var adapter: StoreDetailListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setUpObserver() {
        mViewModel.newsResponseObservable.observe(this) {
            binding.progressCircular.gone()
            adapter =
                StoreDetailListAdapter(it.data?.toMutableList()?: mutableListOf(), this@StoreDetailActivity)
            binding.rvStoreDetail.adapter = adapter



        }
    }

    override fun init() {

        val bundle = intent.extras
        if (bundle != null) {

            data = bundle.getString("apikey")
            binding.apply {
                adapter =
                    StoreDetailListAdapter(mutableListOf(), this@StoreDetailActivity)
                rvStoreDetail.adapter = adapter
                callStoreDetailApi();
            }
        }
    }
    private fun callStoreDetailApi() {
        if (isNetworkConnected()) {
            binding.progressCircular.visible()
            mViewModel.getStoreDetailList(data)
        } else {
            showSnackbar("Internet is not connected...")
        }
    }


}