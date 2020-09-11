package monakhova.bookmark.manager.presentation.mvi.model

import monakhova.bookmark.manager.domain.models.IBookmark
import monakhova.bookmark.manager.domain.models.ICategory

/**
 * Created by monakhova on 18.05.2020.
 */
data class Category(
    override val id: Long,
    override val title: String,
    override val parentCategoryId: Int?,
    override val subcategories: List<ICategory>?,
    override val bookmarks: List<IBookmark>?
): ICategory