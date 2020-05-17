package monakhova.bookmark.manager.mvi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookmarkViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is add bookmark Fragment"
    }
    val text: LiveData<String> = _text
}