package com.selen.mynotes.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.selen.mynotes.R
import com.selen.mynotes.data.model.Color
import com.selen.mynotes.data.model.Note
import com.selen.mynotes.view_model.ANViewModel
import kotlinx.android.synthetic.main.activity_note.*
import java.text.SimpleDateFormat
import java.util.*

class ActivityNote : AppCompatActivity() {
    private var note: Note? = null
    private lateinit var viewModel: ANViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        viewModel = ViewModelProvider(this).get(ANViewModel::class.java)

        note = intent.getParcelableExtra(EXTRA_NOTE)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = note?.let {
            SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault()).format(it.lastChanged)
        } ?: getString(R.string.new_note_title)

        initView()
    }

    private fun initView() {
        note?.let {
            titleEt.setText(it.title)
            bodyEt.setText(it.note)
            val color =
                when (it.color) {
                    Color.WHITE -> R.color.color_white
                    Color.VIOLET -> R.color.color_violet
                    Color.YELLOW -> R.color.color_yellow
                    Color.RED -> R.color.color_red
                    Color.GREEN -> R.color.color_green
                    Color.BLUE -> R.color.color_blue
                }
            toolbar.setBackgroundColor(ResourcesCompat.getColor(resources, color, null))
        }
        titleEt.addTextChangedListener(textChangeListener)
        bodyEt.addTextChangedListener(textChangeListener)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private val textChangeListener = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            saveNote()
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun afterTextChanged(p0: Editable?) {}
    }

    private fun saveNote() {

        titleEt.text?.let {
            if (it.length < 3) {
                return
            }
        } ?: return

        note = note?.copy(
            title = titleEt.text.toString(),
            note = bodyEt.text.toString(),
            lastChanged = Date()
        ) ?: Note(
            title = titleEt.text.toString(),
            note = bodyEt.text.toString(),
            lastChanged = Date()
        )

        note?.let {
            viewModel.saveNote(it)
        }
    }


    companion object {
        private val EXTRA_NOTE = ActivityNote::class.java.name + "extra.NOTE"
        const val DATE_TIME_FORMAT = "dd.MMM.yy HH:mm"

        fun getStartIntent(context: Context, note: Note?) =
            Intent(context, ActivityNote::class.java).apply {
                putExtra(EXTRA_NOTE, note)
            }
    }
}