package monakhova.bookmark.manager.presentation.mvi.model

import monakhova.bookmark.manager.domain.models.IBookmark

/**
 * Created by monakhova on 18.05.2020.
 */
data class Bookmark(
    override val id: Long = 1,
    override val header: String,
    override val description: String,
    override val url: String,
    override val categoryId: Int
): IBookmark