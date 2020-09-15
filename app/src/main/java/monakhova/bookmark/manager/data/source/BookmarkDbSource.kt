package monakhova.bookmark.manager.data.source

import monakhova.bookmark.manager.data.storage.dao.BookmarkDao
import monakhova.bookmark.manager.data.storage.entities.BookmarkEntity
import monakhova.bookmark.manager.domain.converters.toEntity
import monakhova.bookmark.manager.domain.converters.toModel
import monakhova.bookmark.manager.domain.models.Bookmark
import monakhova.bookmark.manager.domain.source.IBookmarkDbSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by monakhova on 08.09.2020.
 */
@Singleton
class BookmarkDbSource @Inject constructor(
    private val bookmarkDao: BookmarkDao
): IBookmarkDbSource {
    override suspend fun getBookmark(id: Int) =
        bookmarkDao.fetchBookmark(id).toModel()

    override suspend fun addBookmark(
        categoryId: Int,
        header: String,
        description: String,
        url: String
    ) = bookmarkDao.insertBookmark(
        BookmarkEntity(header = header, description = description, url = url, bookmarkCategoryId = categoryId)
    )

    override suspend fun updateBookmark(bookmark: Bookmark) =
        bookmarkDao.updateBookmark(bookmark.toEntity())

    override suspend fun deleteBookmark(bookmark: Bookmark)=
        bookmarkDao.deleteBookmark(bookmark.toEntity())
}