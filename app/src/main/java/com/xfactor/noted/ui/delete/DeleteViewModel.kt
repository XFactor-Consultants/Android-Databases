package com.xfactor.noted.ui.delete

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeleteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is delete Fragment"
    }
    val text: LiveData<String> = _text
}