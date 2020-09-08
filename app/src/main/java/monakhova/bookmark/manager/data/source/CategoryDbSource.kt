package monakhova.bookmark.manager.data.source

import monakhova.bookmark.manager.data.storage.dao.CategoryDao
import monakhova.bookmark.manager.domain.source.ICategoryDbSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by monakhova on 08.09.2020.
 */
@Singleton
class CategoryDbSource @Inject constructor(
    private val categoryDao: CategoryDao
): ICategoryDbSource {
}