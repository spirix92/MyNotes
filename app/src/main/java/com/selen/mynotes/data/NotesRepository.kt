package com.selen.mynotes.data

import com.selen.mynotes.data.entity.Note
import com.selen.mynotes.data.provider.DataProvider
import com.selen.mynotes.data.provider.FirestoreProvider


object NotesRepository {

    private val dataProvider: DataProvider = FirestoreProvider()

    fun getNotes() = dataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = dataProvider.saveNote(note)
    fun getNoteById(id: String) = dataProvider.getNoteById(id)

}

