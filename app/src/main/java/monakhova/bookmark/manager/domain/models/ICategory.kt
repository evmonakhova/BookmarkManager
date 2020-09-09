package monakhova.bookmark.manager.domain.models

/**
 * Created by monakhova on 08.09.2020.
 */
interface ICategory {
    val id: Int
    val parentCategoryId: Int
    val title: String
    val subcategories: List<ICategory>
    val bookmarks: List<IBookmark>
}