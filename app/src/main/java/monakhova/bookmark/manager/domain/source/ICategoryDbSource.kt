package monakhova.bookmark.manager.domain.source

import monakhova.bookmark.manager.domain.models.Category

/**
 * Created by monakhova on 08.09.2020.
 */
interface ICategoryDbSource {
    suspend fun getCategory(id: Int): Category
    suspend fun getCategoryDetails(id: Int): Category
    suspend fun getSubcategories(categoryId: Int): List<Category>
    suspend fun addCategory(category: Category)
    suspend fun deleteCategory(category: Category)
}