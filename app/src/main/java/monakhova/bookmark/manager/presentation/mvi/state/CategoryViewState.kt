package monakhova.bookmark.manager.presentation.mvi.state

import monakhova.bookmark.manager.presentation.mvi.model.Bookmark
import monakhova.bookmark.manager.presentation.mvi.model.Category

/**
 * Created by monakhova on 18.05.2020.
 */
class CategoryViewState {
    val toolbarTitle: String = ""
    val subcategories: List<Category> = listOf()
    val bookmarks: List<Bookmark> = listOf()
}

sealed class CategoryEvent {
    object LoadingEvent: CategoryEvent()
    data class DeleteCategoryEvent(val category: Category): CategoryEvent()
    data class MoveCategoryEvent(val category: Category): CategoryEvent()
}


sealed class CategoryResult {
    object LoadingResult: CategoryResult()
    object DeleteCategoryResult: CategoryResult()
    data class MoveCategoryResult(val parentCategory: Category): CategoryResult()
}