package com.swapnil.copypast.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swapnil.copypast.R
import com.swapnil.copypast.model.ClipBoardItem

class ClipboardItemAdapter: ListAdapter<ClipBoardItem, ClipboardItemAdapter.Companion.Holder>(ClipboardItemsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_clip_board_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindClipItem(getItem(position))
    }

    companion object {
        class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
            private val ivSelectorIndicator: ImageView
            private val tvClipboardText: TextView

            init {
                ivSelectorIndicator = itemView.findViewById(R.id.iv_selector_indicator)
                tvClipboardText = itemView.findViewById(R.id.tv_copied_txt)
            }

            fun bindClipItem(clipBoardItem: ClipBoardItem) {
                tvClipboardText.text = itemView.context.getString(R.string.formatted_clipboard_item_txt, clipBoardItem.id, clipBoardItem.text)
            }
        }
    }
}

class ClipboardItemsDiffCallback: DiffUtil.ItemCallback<ClipBoardItem>() {
    override fun areItemsTheSame(oldItem: ClipBoardItem, newItem: ClipBoardItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ClipBoardItem, newItem: ClipBoardItem): Boolean {
        return oldItem == newItem
    }

}