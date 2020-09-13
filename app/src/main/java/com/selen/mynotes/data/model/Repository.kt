package com.selen.mynotes.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object Repository {

    private val notesLiveData = MutableLiveData<List<Note>>()

    private var notesList: MutableList<Note> = mutableListOf(
        Note(UUID.randomUUID().toString(), "титул1", "заметка 1", Color.YELLOW),
        Note(UUID.randomUUID().toString(), "титул2", "заметка 2", Color.GREEN),
        Note(UUID.randomUUID().toString(), "титул3", "заметка 3", Color.BLUE),
        Note(UUID.randomUUID().toString(), "титул4", "заметка 4", Color.RED),
        Note(UUID.randomUUID().toString(), "титул5", "заметка 5", Color.VIOLET),
    )

    init {
        notesLiveData.value = notesList
    }

    fun getNotes(): LiveData<List<Note>> {
        return notesLiveData
    }

    fun saveNote(note: Note) {
        addOrReplace(note)
        notesLiveData.value = notesList
    }

    private fun addOrReplace(note: Note) {

        for (i in 0 until notesList.size) {
            if (notesList[i] == note) {
                notesList[i] = note
                return
            }
        }

        notesList.add(note)
    }

}