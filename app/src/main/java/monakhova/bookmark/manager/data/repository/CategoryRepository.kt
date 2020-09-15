package monakhova.bookmark.manager.data.repository

import monakhova.bookmark.manager.domain.models.Category
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
    override suspend fun getCategory(id: Int) = categoryDbSource.getCategory(id)
    override suspend fun getCategoryDetails(id: Int) = categoryDbSource.getCategoryDetails(id)
    override suspend fun getSubcategories(categoryId: Int) =
        categoryDbSource.getSubcategories(categoryId)
    override suspend fun addCategory(parentCategoryId: Int, title: String) =
        categoryDbSource.addCategory(parentCategoryId, title)
    override suspend fun deleteCategory(category: Category) = categoryDbSource.deleteCategory(category)
}