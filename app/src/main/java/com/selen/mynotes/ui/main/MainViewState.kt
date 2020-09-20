package com.selen.mynotes.ui.main

import com.selen.mynotes.data.entity.Note
import com.selen.mynotes.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)