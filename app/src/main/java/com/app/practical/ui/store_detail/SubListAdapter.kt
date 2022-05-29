package com.app.practical.ui.store_detail

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.practical.R
import com.app.practical.base.BaseViewHolder
import com.app.practical.databinding.DialogAddBinding
import com.app.practical.databinding.ItemSubBinding
import com.app.practical.model.Model

class SubListAdapter(
    private var list: List<Model>,
    private val context: Context,
) :
    RecyclerView.Adapter<SubListAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemSubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.onBind(position)

    override fun getItemCount() = list.size

    inner class UserViewHolder(binding: ItemSubBinding) : BaseViewHolder(binding.root) {

        private val mBinding: ItemSubBinding = binding
        lateinit var mbinding: DialogAddBinding
        var count=0

        override fun onBind(position: Int) {

            mBinding.viewModel = list[position]
            mBinding.apply {

                mBinding.btnAdd.setOnClickListener { showDialog(list[position].name) }

            }
        }

        private fun showDialog(name: String) {
            val builder = AlertDialog.Builder(context)
            mbinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.dialog_add,
                null,
                true
            )
            builder.setView(mbinding.root)

            val dialog = builder.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
            mbinding.tvTitle.text=name
            mbinding.btnCancel.setOnClickListener {
                dialog.hide()
            }
            mbinding.btnPlus.setOnClickListener {
                count++
                mbinding.tvCOunt.text=count.toString()
            }
            mbinding.btnMinus.setOnClickListener {
                if(count<0)
                count--
                mbinding.tvCOunt.text=count.toString()
            }
        }
    }


}


