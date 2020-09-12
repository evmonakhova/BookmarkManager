package monakhova.bookmark.manager.presentation.mvi.state

import monakhova.bookmark.manager.domain.models.Category

/**
 * Created by monakhova on 18.05.2020.
 */
class ChooseCategoryViewState {
    val categories: List<Category> = listOf()
}

sealed class ChooseEvent {
    object LoadingEvent: ChooseEvent()
    data class ChooseCategoryEvent(val category: Category): ChooseEvent()
}


sealed class ChooseResult {
    object LoadingResult: ChooseResult()
    data class ChooseCategoryResult(val chosenCategory: Category): ChooseResult()
}