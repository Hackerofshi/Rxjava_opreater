package com.hi.dhl.paging3.network.ui.github

import android.view.View
import androidx.paging.LoadState
import com.hi.dhl.jdatabinding.DataBindingViewHolder
import com.shixin.databinding.RecycieItemNetworkStateBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */
class NetworkStateItemViewHolder(view: View, private val retryCallback: () -> Unit) :
    DataBindingViewHolder<LoadState>(view) {
    val mBinding: RecycieItemNetworkStateBinding by viewHolderBinding(view)

    override fun bindData(data: LoadState, position: Int) {
        mBinding.apply {
            // 正在加载，显示进度条
            progressBar.isVisible = data is LoadState.Loading
            // 加载失败，显示并点击重试按钮
            retryButton.isVisible = data is LoadState.Error
            retryButton.setOnClickListener { retryCallback() }
            // 加载失败显示错误原因
            errorMsg.isVisible = !(data as? LoadState.Error)?.error?.message.isNullOrBlank()
            errorMsg.text = (data as? LoadState.Error)?.error?.message

            executePendingBindings()
        }
    }
}

inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }