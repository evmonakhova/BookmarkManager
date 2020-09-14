package monakhova.bookmark.manager.presentation.mvi.state

import monakhova.bookmark.manager.domain.models.Category

/**
 * Created by monakhova on 18.05.2020.
 */
sealed class CategoryState {
    object Loading: CategoryState()
    data class Success(val category: Category): CategoryState()
    object Error : CategoryState()
}

sealed class CategoryIntent {
    data class LoadCategory(val categoryId: Int): CategoryIntent()
}