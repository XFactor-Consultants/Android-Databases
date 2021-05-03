package com.xfactor.noted.ui.compare

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompareViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is compare list"
    }
    val text: LiveData<String> = _text
}