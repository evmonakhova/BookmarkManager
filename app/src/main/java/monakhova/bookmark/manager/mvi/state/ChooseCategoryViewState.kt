package monakhova.bookmark.manager.mvi.state

import monakhova.bookmark.manager.mvi.model.ICategory

/**
 * Created by monakhova on 18.05.2020.
 */
class ChooseCategoryViewState {
    val categories: List<ICategory> = listOf()
}

sealed class ChooseEvent {
    object LoadingEvent: ChooseEvent()
    data class ChooseCategoryEvent(val category: ICategory): ChooseEvent()
}


sealed class ChooseResult {
    object LoadingResult: ChooseResult()
    data class ChooseCategoryResult(val chosenCategory: ICategory): ChooseResult()
}