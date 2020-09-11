package monakhova.bookmark.manager.data.storage.dao

import androidx.room.*
import monakhova.bookmark.manager.data.storage.entities.CATEGORY_ID
import monakhova.bookmark.manager.data.storage.entities.PARENT_CATEGORY_ID
import monakhova.bookmark.manager.data.storage.entities.TABLE_CATEGORY
import monakhova.bookmark.manager.data.storage.entities.CategoryEntity
import monakhova.bookmark.manager.data.storage.entities.CategoryDetails

/**
 * Created by monakhova on 06.09.2020.
 */
@Dao
interface CategoryDao {
    @Query( "SELECT * FROM $TABLE_CATEGORY WHERE $CATEGORY_ID = :id")
    suspend fun fetchCategory(id: Int): CategoryEntity

    @Transaction
    @Query( "SELECT * FROM $TABLE_CATEGORY WHERE $CATEGORY_ID = :id")
    suspend fun fetchCategoryDetails(id: Int): CategoryDetails

    @Query( "SELECT * FROM $TABLE_CATEGORY WHERE $PARENT_CATEGORY_ID = :categoryId")
    suspend fun fetchSubcategories(categoryId: Int): List<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryEntity: CategoryEntity)

    @Delete
    suspend fun deleteCategory(categoryEntity: CategoryEntity)
}