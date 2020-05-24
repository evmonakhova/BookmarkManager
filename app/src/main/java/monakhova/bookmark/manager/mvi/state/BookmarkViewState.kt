package monakhova.bookmark.manager.mvi.state

import monakhova.bookmark.manager.mvi.model.IBookmark

/**
 * Created by monakhova on 18.05.2020.
 */
class BookmarkViewState {
    val toolbarTitle: String = ""
    val header: String = ""
    val description: String = ""
    val url: String = ""
    val categoryId: Int = 0
    val categoryTitle: String = ""
}

sealed class BookmarkEvent {
    object LoadingEvent: BookmarkEvent()
    data class AddBookmarkEvent(val header: String, val description: String?, val url: String, val categoryId: Int): BookmarkEvent()
    data class EditBookmarkEvent(val bookmark: IBookmark): BookmarkEvent()
}

sealed class BookmarkResult {
    object LoadingResult: BookmarkResult()
    data class AddBookmarkResult(val createdBookmark: IBookmark): BookmarkResult()
    data class EditBookmarkResult(val editedBookmark: IBookmark): BookmarkResult()
}