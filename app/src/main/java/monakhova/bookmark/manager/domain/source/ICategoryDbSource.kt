package monakhova.bookmark.manager.domain.source

import monakhova.bookmark.manager.domain.models.Category

/**
 * Created by monakhova on 08.09.2020.
 */
interface ICategoryDbSource {
    suspend fun getCategory(id: Int): Category
    suspend fun getCategoryDetails(categoryId: Int): Category
    suspend fun getSubcategories(categoryId: Int): List<Category>
    suspend fun addCategory(parentCategoryId: Int, title: String)
    suspend fun deleteCategory(category: Category)
}