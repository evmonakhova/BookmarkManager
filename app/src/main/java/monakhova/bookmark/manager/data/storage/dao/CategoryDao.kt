package monakhova.bookmark.manager.data.storage.dao

import androidx.room.*
import monakhova.bookmark.manager.data.storage.entities.*

/**
 * Created by monakhova on 06.09.2020.
 */
@Dao
abstract class CategoryDao {
    @Query( "SELECT * FROM $TABLE_CATEGORY WHERE $CATEGORY_ID = :categoryId")
    abstract suspend fun fetchCategory(categoryId: Int): CategoryEntity

    @Transaction
    @Query( "SELECT * FROM $TABLE_CATEGORY WHERE $CATEGORY_ID = :categoryId")
    abstract suspend fun fetchCategoryWithBookmarks(categoryId: Int): CategoryWithBookmarks

    @Query( "SELECT * FROM $TABLE_CATEGORY WHERE $PARENT_CATEGORY_ID = :categoryId")
    abstract suspend fun fetchSubcategories(categoryId: Int): List<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertCategory(categoryEntity: CategoryEntity)

    @Delete
    abstract suspend fun deleteCategory(categoryEntity: CategoryEntity)

    @Transaction
    open suspend fun fetchCategoryDetails(categoryId: Int): CategoryDetails {
        val categoryWithBookmarks = fetchCategoryWithBookmarks(categoryId)
        val subcategories = fetchSubcategories(categoryId)
        return CategoryDetails(categoryWithBookmarks, subcategories)
    }
}