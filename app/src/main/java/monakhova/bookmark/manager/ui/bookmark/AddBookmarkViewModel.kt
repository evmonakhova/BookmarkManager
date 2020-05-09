package monakhova.bookmark.manager.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddBookmarkViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is add bookmark Fragment"
    }
    val text: LiveData<String> = _text
}