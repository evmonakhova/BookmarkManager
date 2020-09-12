package monakhova.bookmark.manager.domain.source

import monakhova.bookmark.manager.domain.models.Bookmark

/**
 * Created by monakhova on 08.09.2020.
 */
interface IBookmarkDbSource {
    suspend fun getBookmark(id: Int): Bookmark
    suspend fun addBookmark(categoryId: Int, header: String, description: String, url: String)
    suspend fun updateBookmark(bookmark: Bookmark)
    suspend fun deleteBookmark(bookmark: Bookmark)
}