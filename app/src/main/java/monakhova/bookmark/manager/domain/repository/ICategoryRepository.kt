package monakhova.bookmark.manager.domain.repository

import monakhova.bookmark.manager.domain.models.Category

/**
 * Created by monakhova on 18.05.2020.
 */
interface ICategoryRepository {
    suspend fun getCategory(id: Int): Category
    suspend fun getCategoryDetails(id: Int): Category
    suspend fun getSubcategories(categoryId: Int): List<Category>
    suspend fun addCategory(parentCategoryId: Int, title: String)
    suspend fun deleteCategory(category: Category)
}