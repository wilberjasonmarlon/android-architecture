package com.carlyadam.arquitecture.utilities

import android.content.ClipData
import androidx.recyclerview.widget.DiffUtil
import com.carlyadam.arquitecture.data.model.Book
import java.util.*


class DiffCallback(
    var newItems: ArrayList<Book>,
    var oldItems: ArrayList<Book>
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return newItems[newItemPosition].name === oldItems.get(oldItemPosition).name
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return newItems[newItemPosition] == oldItems[oldItemPosition]
    }

}