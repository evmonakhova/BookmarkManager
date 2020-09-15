package monakhova.bookmark.manager.data.source

import monakhova.bookmark.manager.data.storage.dao.CategoryDao
import monakhova.bookmark.manager.data.storage.entities.CategoryEntity
import monakhova.bookmark.manager.domain.converters.toEntity
import monakhova.bookmark.manager.domain.converters.toModel
import monakhova.bookmark.manager.domain.models.Category
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
    override suspend fun getCategory(id: Int)=
        categoryDao.fetchCategory(id).toModel()

    override suspend fun getCategoryDetails(categoryId: Int) =
        categoryDao.fetchCategoryDetails(categoryId).toModel()

    override suspend fun getSubcategories(categoryId: Int) =
        categoryDao.fetchSubcategories(categoryId).map { it.toModel() }

    override suspend fun addCategory(parentCategoryId: Int, title: String) =
        categoryDao.insertCategory(CategoryEntity(parentCategoryId = parentCategoryId, title = title))

    override suspend fun deleteCategory(category: Category) =
        categoryDao.deleteCategory(category.toEntity())
}