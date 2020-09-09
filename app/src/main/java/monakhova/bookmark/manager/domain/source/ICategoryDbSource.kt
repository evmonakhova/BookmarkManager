package monakhova.bookmark.manager.domain.source

import monakhova.bookmark.manager.domain.models.ICategory

/**
 * Created by monakhova on 08.09.2020.
 */
interface ICategoryDbSource {
    suspend fun getCategory(id: Int): ICategory
    suspend fun getCategoryDetails(id: Int): ICategory
    suspend fun getSubcategories(categoryId: Int): List<ICategory>
    suspend fun addCategory(category: ICategory)
    suspend fun deleteCategory(category: ICategory)
}