package monakhova.bookmark.manager.domain.models

/**
 * Created by monakhova on 08.09.2020.
 */
const val DEFAULT_CATEGORY_ID = 1

interface ICategory {
    val id: Long
    val parentCategoryId: Int?
    val title: String
    val subcategories: List<ICategory>?
    val bookmarks: List<IBookmark>?
}