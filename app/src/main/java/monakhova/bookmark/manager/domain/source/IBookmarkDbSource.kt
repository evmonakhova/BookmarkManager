package monakhova.bookmark.manager.domain.source

import monakhova.bookmark.manager.domain.models.IBookmark

/**
 * Created by monakhova on 08.09.2020.
 */
interface IBookmarkDbSource {
    suspend fun addBookmark(bookmark: IBookmark)
    suspend fun getBookmark(id: Int): IBookmark
    suspend fun updateBookmark(bookmark: IBookmark)
    suspend fun deleteBookmark(bookmark: IBookmark)
}