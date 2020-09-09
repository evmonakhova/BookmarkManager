package monakhova.bookmark.manager.data.repository

import monakhova.bookmark.manager.domain.models.IBookmark
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
    override suspend fun addBookmark(bookmark: IBookmark) = bookmarkDbSource.addBookmark(bookmark)
    override suspend fun getBookmark(id: Int) = bookmarkDbSource.getBookmark(id)
    override suspend fun updateBookmark(bookmark: IBookmark) = bookmarkDbSource.updateBookmark(bookmark)
    override suspend fun deleteBookmark(bookmark: IBookmark) = bookmarkDbSource.deleteBookmark(bookmark)
}