package monakhova.bookmark.manager.mvi.model

/**
 * Created by monakhova on 18.05.2020.
 */
interface IBookmark {
    val id: Int
    val header: String
    val description: String
    val url: String
    val category: ICategory
}