package com.selen.mynotes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.recyclerview.widget.LinearLayoutManager
import com.selen.mynotes.R
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
        mainRecycler.layoutManager = LinearLayoutManager(this)

        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        ContextCompat.getDrawable(this, R.drawable.separator)?.let {
            decorator.setDrawable(it)
        }
        mainRecycler.addItemDecoration(decorator)

        adapter = MARecyclerAdapter()
        mainRecycler.adapter = adapter
        viewModel.getReloadNotesLiveData().observe(this, { notes ->
            notes?.let {
                adapter.notes = it
            }
        })
    }
}