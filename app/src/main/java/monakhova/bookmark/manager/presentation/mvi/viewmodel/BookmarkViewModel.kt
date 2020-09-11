package monakhova.bookmark.manager.presentation.mvi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monakhova.bookmark.manager.domain.repository.IBookmarkRepository
import javax.inject.Inject

class BookmarkViewModel @Inject constructor(
    private val bookmarkRepository: IBookmarkRepository
) : ViewModel() {

    private val _bookmarkAdded = MutableLiveData<Boolean>()
    val bookmarkAdded: LiveData<Boolean> = _bookmarkAdded

    fun addBookmark(header: String, description: String, url: String, categoryId: Int) {
        viewModelScope.launch {
            try {
                bookmarkRepository.addBookmark(header, description, url, categoryId)
            } finally {
                _bookmarkAdded.postValue(true)
            }
        }
    }
}