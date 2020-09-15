package monakhova.bookmark.manager.presentation.mvi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monakhova.bookmark.manager.domain.repository.IBookmarkRepository
import monakhova.bookmark.manager.presentation.mvi.state.BookmarkIntent
import monakhova.bookmark.manager.presentation.mvi.state.LoadingState
import javax.inject.Inject

class BookmarkViewModel @Inject constructor(
    private val bookmarkRepository: IBookmarkRepository
) : ViewModel() {

    private val _state = MutableLiveData<LoadingState>()
    val state: LiveData<LoadingState> = _state

    fun onIntent(intent: BookmarkIntent) {
        when (intent) {
            is BookmarkIntent.AddBookmark -> addBookmark(intent)
        }
    }

    private fun addBookmark(intent: BookmarkIntent.AddBookmark) {
        _state.value = LoadingState.Loading
        viewModelScope.launch {
            try {
                bookmarkRepository.addBookmark(intent.categoryId, intent.header, intent.description, intent.url)
            } catch (exception: Exception) {
                Log.e(getLogTag(), "${exception.stackTrace}")
                _state.value = LoadingState.Error
            } finally {
                _state.value = LoadingState.Success(null)
            }
        }
    }

    private fun getLogTag() = javaClass.simpleName
}