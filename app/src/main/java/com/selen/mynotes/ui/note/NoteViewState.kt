package com.selen.mynotes.ui.note

import com.selen.mynotes.data.entity.Note
import com.selen.mynotes.ui.base.BaseViewState

class NoteViewState(data: Data = Data(), error: Throwable? = null) : BaseViewState<NoteViewState.Data>(data, error) {
    data class Data(val isDeleted: Boolean = false, val note: Note? = null)
}