package com.tokioschool.travellingkotlinmvvm.core.base.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tokioschool.travellingkotlinmvvm.BR
import com.tokioschool.travellingkotlinmvvm.core.base.BaseViewModel

class BaseViewHolderBinding(val viewmodel: BaseViewModel?, val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item:Any?){
        binding.setVariable(BR.viewModel,viewmodel)
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}