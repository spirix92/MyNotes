package com.selen.mynotes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

import com.selen.mynotes.R
import com.selen.mynotes.data.model.Note
import com.selen.mynotes.ui.recycler.MARecyclerAdapter
import com.selen.mynotes.view_model.MAViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MAViewModel
    lateinit var adapter: MARecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MAViewModel::class.java)
        mainRecycler.layoutManager = GridLayoutManager(this, 2)

        adapter = MARecyclerAdapter {
            openNoteScreen(it)
        }
        mainRecycler.adapter = adapter

        viewModel.getReloadNotesLiveData().observe(this, { notes ->
            notes?.let {
                adapter.notes = it
            }
        })

        fab.setOnClickListener { openNoteScreen(null) }
    }

    private fun openNoteScreen(note: Note?) {
        val intent = ActivityNote.getStartIntent(this, note)
        startActivity(intent)
    }

}