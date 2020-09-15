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

/**
 * Created by monakhova on 24.05.2020.
 */
class ChangeCategoryViewModel @Inject constructor(
    private val categoryRepository: ICategoryRepository
): ViewModel() {

    private val _state = MutableLiveData<LoadingState>()
    val state: LiveData<LoadingState> = _state

    fun onIntent(intent: CategoryIntent) {
        when (intent) {
            is CategoryIntent.AddCategory -> onAddCategory(intent)
        }
    }

    private fun onAddCategory(intent: CategoryIntent.AddCategory) {
        _state.value = LoadingState.Loading
        viewModelScope.launch {
            try {
                categoryRepository.addCategory(intent.parentCategoryId, intent.title)
                Log.d(getLogTag(), "Subcategory of category ${intent.parentCategoryId} added.")
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