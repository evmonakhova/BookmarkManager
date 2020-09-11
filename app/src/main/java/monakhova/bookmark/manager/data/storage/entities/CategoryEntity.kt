package monakhova.bookmark.manager.data.storage.entities

import androidx.room.*
import monakhova.bookmark.manager.domain.models.DEFAULT_CATEGORY_ID

/**
 * Created by monakhova on 06.09.2020.
 */
const val TABLE_CATEGORY = "TableCategory"

const val CATEGORY_ID = "category_id"
const val PARENT_CATEGORY_ID = "parent_category_id"
const val CATEGORY_TITLE = "category_title"

@Entity(
    tableName = TABLE_CATEGORY,
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = [CATEGORY_ID],
            childColumns = [PARENT_CATEGORY_ID],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = [PARENT_CATEGORY_ID])
    ]
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = CATEGORY_ID) val categoryId: Long = DEFAULT_CATEGORY_ID.toLong(),
    @ColumnInfo(name = PARENT_CATEGORY_ID) val parentCategoryId: Int?,
    @ColumnInfo(name = CATEGORY_TITLE) val title: String
)