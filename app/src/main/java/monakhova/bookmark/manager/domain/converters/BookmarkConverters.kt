package monakhova.bookmark.manager.domain.converters

import monakhova.bookmark.manager.data.storage.entities.BookmarkEntity
import monakhova.bookmark.manager.domain.models.Bookmark

/**
 * Created by monakhova on 09.09.2020.
 */

fun Bookmark.toEntity() = BookmarkEntity(
    bookmarkId = id,
    bookmarkCategoryId = categoryId,
    header = header,
    description = description,
    url = url
)

fun BookmarkEntity.toModel() = Bookmark(
    id = bookmarkId,
    categoryId = bookmarkCategoryId,
    header = header,
    description = description,
    url = url
)