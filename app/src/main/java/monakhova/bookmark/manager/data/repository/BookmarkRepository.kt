package monakhova.bookmark.manager.data.repository

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
}