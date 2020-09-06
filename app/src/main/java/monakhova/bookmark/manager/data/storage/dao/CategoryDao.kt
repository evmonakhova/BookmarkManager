package monakhova.bookmark.manager.data.storage.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import monakhova.bookmark.manager.data.storage.TABLE_CATEGORY
import monakhova.bookmark.manager.data.storage.entities.CategoryEntity
import monakhova.bookmark.manager.data.storage.entities.CategoryWithBookmarksAndSubcategories

/**
 * Created by monakhova on 06.09.2020.
 */
@Dao
interface CategoryDao {
    @Transaction
    @Query( "SELECT * FROM $TABLE_CATEGORY WHERE categoryId = :id")
    fun fetchCategory(id: Int): CategoryWithBookmarksAndSubcategories

    @Query( "SELECT * FROM $TABLE_CATEGORY")
    fun fetchCategories(): List<CategoryEntity>
}