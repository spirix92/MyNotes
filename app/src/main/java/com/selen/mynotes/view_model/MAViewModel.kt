package com.selen.mynotes.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.selen.mynotes.data.model.Note
import com.selen.mynotes.data.model.Repository

class MAViewModel : ViewModel() {
    private val reloadNotesLiveData: MutableLiveData<List<Note>> = MutableLiveData()

    init {
        reloadNotesLiveData.value = Repository.notesList
    }

    fun getReloadNotesLiveData(): LiveData<List<Note>> = reloadNotesLiveData
}