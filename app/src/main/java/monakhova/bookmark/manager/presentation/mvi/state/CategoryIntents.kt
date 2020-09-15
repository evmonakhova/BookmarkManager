package monakhova.bookmark.manager.presentation.mvi.state

/**
 * Created by monakhova on 18.05.2020.
 */
sealed class CategoryIntent {
    data class LoadCategory(val categoryId: Int): CategoryIntent()
    data class AddCategory(val parentCategoryId: Int, val title: String): CategoryIntent()
    data class ChangeTitle(val title: String): CategoryIntent()
    data class ChangeParentCategory(val parentCategoryId: Int): CategoryIntent()
}

sealed class ChooseCategoryIntent {
    data class ChooseCategory(val categoryId: Int): ChooseCategoryIntent()
}