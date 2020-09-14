package monakhova.bookmark.manager.presentation.mvi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monakhova.bookmark.manager.domain.repository.ICategoryRepository
import monakhova.bookmark.manager.presentation.mvi.state.CategoryIntent
import monakhova.bookmark.manager.presentation.mvi.state.CategoryState
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val categoryRepository: ICategoryRepository
) : ViewModel() {

    private val _state = MutableLiveData<CategoryState>()
    val state: LiveData<CategoryState> = _state

    fun onIntent(intent: CategoryIntent) {
        when (intent) {
            is CategoryIntent.LoadCategory -> getCategory(intent.categoryId)
        }
    }

    private fun getCategory(categoryId: Int) {
        _state.value = CategoryState.Loading
        viewModelScope.launch {
            try {
                val category = categoryRepository.getCategoryDetails(categoryId)
                _state.value = CategoryState.Success(category)
            } catch (exception: Exception) {
                Log.e(getLogTag(), exception.stackTrace.toString())
                _state.value = CategoryState.Error
            }
        }
    }

    private fun getLogTag() = javaClass.simpleName
}