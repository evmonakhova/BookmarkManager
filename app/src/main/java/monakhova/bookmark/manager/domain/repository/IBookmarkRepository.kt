package monakhova.bookmark.manager.domain.repository

import monakhova.bookmark.manager.domain.models.Bookmark

/**
 * Created by monakhova on 18.05.2020.
 *
 * Interface that represents a Repository for getting [Bookmark] related data.
 */
interface IBookmarkRepository {
    suspend fun getBookmark(id: Int): Bookmark
    suspend fun addBookmark(categoryId: Int, header: String, description: String, url: String)
    suspend fun updateBookmark(bookmark: Bookmark)
    suspend fun deleteBookmark(bookmark: Bookmark)
}