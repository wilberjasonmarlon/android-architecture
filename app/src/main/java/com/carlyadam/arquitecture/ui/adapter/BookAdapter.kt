package com.carlyadam.arquitecture.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.carlyadam.arquitecture.data.model.Book
import com.carlyadam.arquitecture.databinding.ItemBookBinding

class BookAdapter(var bookList: List<Book>, var mContext: Context) :
    ListAdapter<Book, BookAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            holder.bind(bookList[position])
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }


    class ViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.textViewName.text = book.name
            binding.textViewLastName.text = book.lastname
        }
    }

    interface AdapterListener {
        fun onItemTap(position: Int)
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Book>() {

    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}