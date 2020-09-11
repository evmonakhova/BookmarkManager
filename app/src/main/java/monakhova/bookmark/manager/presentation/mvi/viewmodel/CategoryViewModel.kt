package monakhova.bookmark.manager.presentation.mvi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import monakhova.bookmark.manager.domain.models.DEFAULT_CATEGORY_ID
import monakhova.bookmark.manager.domain.models.ICategory
import monakhova.bookmark.manager.domain.repository.ICategoryRepository
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val categoryRepository: ICategoryRepository
) : ViewModel() {

    private val _categoryData = MutableLiveData<ICategory>()
    val categoryData: LiveData<ICategory> = _categoryData

    fun getCategory() {
        viewModelScope.launch {
            _categoryData.value = categoryRepository.getCategoryDetails(DEFAULT_CATEGORY_ID)
        }
    }
}