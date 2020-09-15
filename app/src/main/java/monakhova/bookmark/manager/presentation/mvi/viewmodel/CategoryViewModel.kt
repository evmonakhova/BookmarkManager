package monakhova.bookmark.manager.presentation.mvi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monakhova.bookmark.manager.domain.repository.ICategoryRepository
import monakhova.bookmark.manager.presentation.mvi.state.CategoryIntent
import monakhova.bookmark.manager.presentation.mvi.state.LoadingState
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val categoryRepository: ICategoryRepository
) : ViewModel() {

    private val _state = MutableLiveData<LoadingState>()
    val state: LiveData<LoadingState> = _state

    fun onIntent(intent: CategoryIntent) {
        when (intent) {
            is CategoryIntent.LoadCategory -> getCategory(intent.categoryId)
        }
    }

    private fun getCategory(categoryId: Int) {
        _state.value = LoadingState.Loading
        viewModelScope.launch {
            try {
                val category = categoryRepository.getCategoryDetails(categoryId)
                Log.d(getLogTag(), "Category loaded: $category")
                _state.value = LoadingState.Success(category)
            } catch (exception: Exception) {
                Log.e(getLogTag(), exception.stackTrace.toString())
                _state.value = LoadingState.Error
            }
        }
    }

    private fun getLogTag() = javaClass.simpleName
}