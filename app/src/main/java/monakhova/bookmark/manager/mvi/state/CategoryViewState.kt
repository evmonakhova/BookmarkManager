package monakhova.bookmark.manager.mvi.state

import monakhova.bookmark.manager.mvi.model.IBookmark
import monakhova.bookmark.manager.mvi.model.ICategory

/**
 * Created by monakhova on 18.05.2020.
 */
class CategoryViewState {
    val toolbarTitle: String = ""
    val subcategories: List<ICategory> = listOf()
    val bookmarks: List<IBookmark> = listOf()
}

sealed class CategoryEvent {
    object LoadingEvent: CategoryEvent()
    data class DeleteCategoryEvent(val category: ICategory): CategoryEvent()
    data class MoveCategoryEvent(val category: ICategory): CategoryEvent()
}


sealed class CategoryResult {
    object LoadingResult: CategoryResult()
    object DeleteCategoryResult: CategoryResult()
    data class MoveCategoryResult(val parentCategory: ICategory): CategoryResult()
}