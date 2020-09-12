package monakhova.bookmark.manager.presentation.mvi.state

import monakhova.bookmark.manager.domain.models.Category

/**
 * Created by monakhova on 18.05.2020.
 */
class ChangeCategoryViewState {
    val toolbarTitle: String = ""
    val header: String = ""
    val parentCategoryId: Int = 0
    val parentCategoryTitle: String = ""
}

sealed class ChangeCategoryEvent {
    object LoadingEvent: ChangeCategoryEvent()
    data class AddCategoryEvent(val categoryTitle: String, val parentCategoryId: Int): ChangeCategoryEvent()
    data class EditCategoryEvent(val category: Category): ChangeCategoryEvent()
}


sealed class ChangeCategoryResult {
    object LoadingResult: ChangeCategoryResult()
    data class AddCategoryResult(val createdCategory: Category): ChangeCategoryResult()
    data class EditCategoryResult(val editedCategory: Category): ChangeCategoryResult()
}