package monakhova.bookmark.manager.data.repository

import monakhova.bookmark.manager.domain.repository.ICategoryRepository
import monakhova.bookmark.manager.domain.source.ICategoryDbSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by monakhova on 18.05.2020.
 */
@Singleton
class CategoryRepository @Inject constructor(
    private val categoryDbSource: ICategoryDbSource
): ICategoryRepository {
}