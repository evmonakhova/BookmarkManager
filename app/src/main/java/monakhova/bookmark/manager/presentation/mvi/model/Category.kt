package monakhova.bookmark.manager.presentation.mvi.model

import monakhova.bookmark.manager.domain.models.IBookmark
import monakhova.bookmark.manager.domain.models.ICategory

/**
 * Created by monakhova on 18.05.2020.
 */
const val DEFAULT_CATEGORY_ID = 0

data class Category(
    override val id: Int,
    override val title: String,
    override val parentCategoryId: Int = DEFAULT_CATEGORY_ID,
    override val subcategories: List<ICategory> = listOf(),
    override val bookmarks: List<IBookmark> = listOf()
): ICategory