package monakhova.bookmark.manager.data.source

import monakhova.bookmark.manager.data.storage.dao.BookmarkDao
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
}