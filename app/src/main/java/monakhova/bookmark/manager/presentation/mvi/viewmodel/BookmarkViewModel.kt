package monakhova.bookmark.manager.presentation.mvi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monakhova.bookmark.manager.domain.repository.IBookmarkRepository
import monakhova.bookmark.manager.presentation.mvi.state.AddBookmarkIntent
import monakhova.bookmark.manager.presentation.mvi.state.AddBookmarkState
import javax.inject.Inject

class BookmarkViewModel @Inject constructor(
    private val bookmarkRepository: IBookmarkRepository
) : ViewModel() {

    private val _state = MutableLiveData<AddBookmarkState>()
    val state: LiveData<AddBookmarkState> = _state

    fun onIntent(intent: AddBookmarkIntent) {
        when (intent) {
            is AddBookmarkIntent.AddBookmark -> addBookmark(intent)
        }
    }

    private fun addBookmark(intent: AddBookmarkIntent.AddBookmark) {
        _state.value = AddBookmarkState.Loading
        viewModelScope.launch {
            try {
                bookmarkRepository.addBookmark(intent.categoryId, intent.header, intent.description, intent.url)
            } catch (exception: Exception) {
                Log.e(getLogTag(), "${exception.stackTrace}")
                _state.value = AddBookmarkState.Error
            } finally {
                _state.value = AddBookmarkState.Success
            }
        }
    }

    private fun getLogTag() = javaClass.simpleName
}