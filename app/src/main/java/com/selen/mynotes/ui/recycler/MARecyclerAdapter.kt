package com.selen.mynotes.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.selen.mynotes.R
import com.selen.mynotes.data.model.Color
import com.selen.mynotes.data.model.Note
import kotlinx.android.synthetic.main.item_recycler_notes.view.*

class MARecyclerAdapter(val onItemClick: ((Note) -> Unit)? = null) : RecyclerView.Adapter<MARecyclerAdapter.MARecyclerViewHolder>() {

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

    inner class MARecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(note: Note) =
            with(itemView as CardView) {
                title.text = note.title
                body.text = note.note
                val myColor = when (note.color) {
                Color.WHITE -> R.color.color_white
                Color.VIOLET -> R.color.color_violet
                Color.YELLOW -> R.color.color_yellow
                Color.RED -> R.color.color_red
                Color.GREEN -> R.color.color_green
                Color.BLUE -> R.color.color_blue
                }
                setCardBackgroundColor (context.getColor(myColor))

                setOnClickListener{
                    onItemClick?.invoke(note)
                }
            }

    }
}