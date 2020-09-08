package monakhova.bookmark.manager.domain.models

/**
 * Created by monakhova on 18.05.2020.
 */
data class Bookmark(
    val id: Int,
    val header: String,
    val description: String,
    val url: String,
    val category: Category
)