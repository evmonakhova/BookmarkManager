package monakhova.bookmark.manager.domain.repository

import monakhova.bookmark.manager.domain.models.ICategory

/**
 * Created by monakhova on 18.05.2020.
 */
interface ICategoryRepository {
    suspend fun getCategory(id: Int): ICategory
    suspend fun getCategoryDetails(id: Int): ICategory
    suspend fun getSubcategories(categoryId: Int): List<ICategory>
    suspend fun addCategory(category: ICategory)
    suspend fun deleteCategory(category: ICategory)
}