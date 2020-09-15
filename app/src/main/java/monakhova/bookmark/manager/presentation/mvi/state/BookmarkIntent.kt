package monakhova.bookmark.manager.presentation.mvi.state

/**
 * Created by monakhova on 18.05.2020.
 */
sealed class BookmarkIntent {
    data class AddBookmark(
        val categoryId: Int,
        val header: String,
        val description: String,
        val url: String
    ) : BookmarkIntent()

    data class ChangeBookmarkFields(
        val header: String,
        val description: String,
        val url: String
    ) : BookmarkIntent()

    data class ChangeBookmarkCategory(val categoryId: Int): BookmarkIntent()
}