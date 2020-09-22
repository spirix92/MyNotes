package com.selen.mynotes.ui.splash

import com.selen.mynotes.data.NotesRepository
import com.selen.mynotes.data.errors.NoAuthException
import com.selen.mynotes.ui.base.BaseViewModel

class SplashViewModel() : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser(){
        NotesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = if(it != null){
                SplashViewState(authenticated = true)
            } else {
                SplashViewState(error = NoAuthException())
            }
        }
    }

}