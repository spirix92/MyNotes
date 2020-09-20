package com.selen.mynotes.ui.note

import com.selen.mynotes.data.entity.Note
import com.selen.mynotes.ui.base.BaseViewState

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)