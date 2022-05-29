package com.app.practical.ui.store_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.practical.base.BaseViewHolder
import com.app.practical.databinding.ItemStoreDetailBinding
import com.app.practical.ktx.gone
import com.app.practical.ktx.visible
import com.app.practical.model.Model
import com.app.practical.model.StoreDetailModel

class StoreDetailListAdapter(
    private val newsList: MutableList<StoreDetailModel.Data>,
    private val context: Context,
) :
    RecyclerView.Adapter<StoreDetailListAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemStoreDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.onBind(position)

    override fun getItemCount() = newsList.size


    inner class UserViewHolder(binding: ItemStoreDetailBinding) : BaseViewHolder(binding.root) {

        private val mBinding: ItemStoreDetailBinding = binding
        lateinit var adapter: SubListAdapter
        override fun onBind(position: Int) {
            var user = newsList[position]

            mBinding.viewModel = user

            mBinding.apply {
                rvSub.visible()
                arrow.rotation=180F
                arrow.tag = "1"

                adapter =
                    SubListAdapter( Model.getData(),context)
                rvSub.adapter = adapter

                title.setOnClickListener {
                    if (arrow.tag.equals("0")) {
                        rvSub.visible()
                        arrow.rotation=180F
                        arrow.tag = "1"
                    } else {
                        rvSub.gone()
                        arrow.rotation=0F
                        arrow.tag = "0"
                    }
                }

            }
        }
    }
}
