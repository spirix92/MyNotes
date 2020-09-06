package com.selen.mynotes.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selen.mynotes.R
import com.selen.mynotes.data.model.Note
import kotlinx.android.synthetic.main.item_recycler_notes.view.*

class MARecyclerAdapter : RecyclerView.Adapter<MARecyclerAdapter.MARecyclerViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MARecyclerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_notes, parent, false)
        )

    override fun onBindViewHolder(holder: MARecyclerViewHolder, position: Int) =
        holder.bind(notes[position])


    override fun getItemCount() = notes.size

    class MARecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(note: Note) =
            with(itemView) {
                title.text = note.title
                body.text = note.note
                contaiter.setBackgroundColor(note.color)
            }

    }
}