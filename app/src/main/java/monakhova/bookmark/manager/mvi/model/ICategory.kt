package monakhova.bookmark.manager.mvi.model

/**
 * Created by monakhova on 18.05.2020.
 */
interface ICategory {
    val id: Int
    val title: String
    val parentCategory: ICategory
    val subcategories: List<ICategory>
    val bookmarks: List<IBookmark>
}