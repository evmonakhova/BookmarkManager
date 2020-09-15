package monakhova.bookmark.manager.domain.converters

import monakhova.bookmark.manager.data.storage.entities.CategoryDetails
import monakhova.bookmark.manager.data.storage.entities.CategoryEntity
import monakhova.bookmark.manager.domain.models.Category

/**
 * Created by monakhova on 09.09.2020.
 */

fun Category.toEntity() = CategoryEntity(
    categoryId = id,
    parentCategoryId = parentCategoryId,
    title = title
)

fun CategoryEntity.toModel() = Category(
    id = categoryId,
    parentCategoryId = parentCategoryId,
    title = title,
    bookmarks = listOf(),
    subcategories = listOf()
)

fun CategoryDetails.toModel() = Category(
    id = categoryWithBookmarks.category.categoryId,
    parentCategoryId = categoryWithBookmarks.category.parentCategoryId,
    title = categoryWithBookmarks.category.title,
    bookmarks = categoryWithBookmarks.bookmarks?.map { it.toModel() },
    subcategories = subcategories?.map { it.toModel() }
)