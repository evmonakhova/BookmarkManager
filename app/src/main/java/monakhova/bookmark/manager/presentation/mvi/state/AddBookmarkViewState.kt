package monakhova.bookmark.manager.presentation.mvi.state

/**
 * Created by monakhova on 18.05.2020.
 */
sealed class AddBookmarkState {
    object Loading: AddBookmarkState()
    object Success: AddBookmarkState()
    object Error : AddBookmarkState()
}

sealed class AddBookmarkIntent {
    data class AddBookmark(
        val categoryId: Int,
        val header: String,
        val description: String,
        val url: String
    ) : AddBookmarkIntent()
}