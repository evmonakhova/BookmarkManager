package monakhova.bookmark.manager.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import monakhova.bookmark.manager.data.storage.TABLE_CATEGORY

/**
 * Created by monakhova on 06.09.2020.
 */
@Entity(tableName = TABLE_CATEGORY)
data class CategoryEntity(
    @PrimaryKey val categoryId: Int,
    val parentCategoryId: Int,
    val title: String
)