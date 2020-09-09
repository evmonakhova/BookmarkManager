package monakhova.bookmark.manager.domain.repository

import monakhova.bookmark.manager.domain.models.IBookmark

/**
 * Created by monakhova on 18.05.2020.
 *
 * Interface that represents a Repository for getting [IBookmark] related data.
 */
interface IBookmarkRepository {
    suspend fun addBookmark(bookmark: IBookmark)
    suspend fun getBookmark(id: Int): IBookmark
    suspend fun updateBookmark(bookmark: IBookmark)
    suspend fun deleteBookmark(bookmark: IBookmark)
}