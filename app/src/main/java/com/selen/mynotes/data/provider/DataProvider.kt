package com.selen.mynotes.data.provider

import androidx.lifecycle.LiveData
import com.selen.mynotes.data.entity.Note
import com.selen.mynotes.data.model.NoteResult


interface DataProvider {
    fun subscribeToAllNotes() : LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
    fun getNoteById(id: String) : LiveData<NoteResult>
}