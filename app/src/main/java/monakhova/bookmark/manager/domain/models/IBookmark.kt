package monakhova.bookmark.manager.domain.models

/**
 * Created by monakhova on 08.09.2020.
 */
interface IBookmark {
    val id: Long
    val header: String
    val description: String
    val url: String
    val categoryId: Int
}