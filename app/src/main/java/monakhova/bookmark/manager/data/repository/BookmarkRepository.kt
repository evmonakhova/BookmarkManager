package monakhova.bookmark.manager.data.repository

import monakhova.bookmark.manager.domain.models.Bookmark
import monakhova.bookmark.manager.domain.repository.IBookmarkRepository
import monakhova.bookmark.manager.domain.source.IBookmarkDbSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by monakhova on 18.05.2020.
 */
@Singleton
class BookmarkRepository @Inject constructor(
    private val bookmarkDbSource: IBookmarkDbSource
): IBookmarkRepository {
    override suspend fun addBookmark(categoryId: Int, header: String, description: String, url: String) {
        bookmarkDbSource.addBookmark(categoryId, header, description, url)
    }
    override suspend fun getBookmark(id: Int) = bookmarkDbSource.getBookmark(id)
    override suspend fun updateBookmark(bookmark: Bookmark) = bookmarkDbSource.updateBookmark(bookmark)
    override suspend fun deleteBookmark(bookmark: Bookmark) = bookmarkDbSource.deleteBookmark(bookmark)
}