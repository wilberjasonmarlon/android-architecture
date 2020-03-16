package com.carlyadam.arquitecture.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlyadam.arquitecture.R
import com.carlyadam.arquitecture.data.model.Book

class BookAdapter(var bookList: List<Book>, var mContext: Context) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (holder) {

            is ViewHolder -> {
                holder.bind(bookList[position])
            }

        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewLastName: TextView = itemView.findViewById(R.id.textViewLastName)
        fun bind(book: Book) {
            textViewName.text = book.name
            textViewLastName.text = book.lastname
        }
    }

    interface AdapterListener {
        fun onItemTap(position: Int)
    }

}