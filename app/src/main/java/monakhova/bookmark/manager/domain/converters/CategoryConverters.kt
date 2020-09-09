package monakhova.bookmark.manager.domain.converters

import monakhova.bookmark.manager.data.storage.entities.CategoryEntity
import monakhova.bookmark.manager.data.storage.entities.CategoryDetails
import monakhova.bookmark.manager.domain.models.ICategory
import monakhova.bookmark.manager.presentation.mvi.model.Category

/**
 * Created by monakhova on 09.09.2020.
 */

fun ICategory.toEntity() = CategoryEntity(
    categoryId = id,
    parentCategoryId = parentCategoryId ?: 0,
    title = title
)

fun CategoryEntity.toModel() = Category(
    id = categoryId,
    parentCategoryId = parentCategoryId,
    title = title,
    subcategories = listOf(),
    bookmarks = listOf()
)

fun CategoryDetails.toModel() = Category(
    id = category.categoryId,
    parentCategoryId = category.parentCategoryId,
    title = category.title,
    subcategories = subcategories.map { it.toModel() },
    bookmarks = bookmarks.map { it.toModel() }
)