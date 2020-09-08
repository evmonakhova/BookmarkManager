package monakhova.bookmark.manager.presentation.mvi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class BookmarkViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is add bookmark Fragment"
    }
    val text: LiveData<String> = _text
}