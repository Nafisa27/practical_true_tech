package com.app.practical.ui.store_list.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.practical.base.BaseViewHolder
import com.app.practical.databinding.ItemStoreBinding
import com.app.practical.model.StoreModel

class StoreListAdapter(
    private val newsList: MutableList<StoreModel.Franquicia>,
    private val context: Context,
    private val callBack: onItemClickListener
) :
    RecyclerView.Adapter<StoreListAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.onBind(position)

    override fun getItemCount() = newsList.size



    inner class UserViewHolder(binding: ItemStoreBinding) : BaseViewHolder(binding.root) {

        private val mBinding: ItemStoreBinding = binding

        override fun onBind(position: Int) {
            var user = newsList[position]
            Log.e("tag","user${user.aPIKEY}")
            mBinding.viewModel = user
            mBinding.apply {

                cvDetail.setOnClickListener {
                    callBack.onClick(user)
                }


            }
        }
    }
}

interface onItemClickListener {
    fun onClick(data: StoreModel.Franquicia)

}
