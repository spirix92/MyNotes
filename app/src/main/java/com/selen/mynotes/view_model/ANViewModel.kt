package com.selen.mynotes.view_model

import androidx.lifecycle.ViewModel
import com.selen.mynotes.data.model.Note
import com.selen.mynotes.data.model.Repository

class ANViewModel(private val repository: Repository = Repository) : ViewModel() {

    private var pendingNote: Note? = null

    fun saveNote(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            repository.saveNote(it)
        }
    }
}