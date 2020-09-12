package monakhova.bookmark.manager.domain.models

/**
 * Created by monakhova on 13.09.2020.
 */
const val DEFAULT_CATEGORY_ID = 1

sealed class CategoryItem

data class Bookmark(
    val id: Int = 1,
    val categoryId: Int,
    val header: String,
    val description: String,
    val url: String
): CategoryItem()

data class Category(
    val id: Int,
    val parentCategoryId: Int?,
    val title: String,
    val bookmarks: List<Bookmark>?,
    val subcategories: List<Category>?
): CategoryItem()