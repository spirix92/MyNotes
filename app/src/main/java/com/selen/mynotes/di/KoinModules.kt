package com.selen.mynotes.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import com.selen.mynotes.data.NotesRepository
import com.selen.mynotes.data.provider.DataProvider
import com.selen.mynotes.data.provider.FirestoreProvider
import com.selen.mynotes.ui.main.MainViewModel
import com.selen.mynotes.ui.note.NoteViewModel
import com.selen.mynotes.ui.splash.SplashViewModel

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single<DataProvider> { FirestoreProvider(get(), get()) }
    single { NotesRepository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}