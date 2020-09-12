package monakhova.bookmark.manager.data.storage.entities

import androidx.room.*
import monakhova.bookmark.manager.domain.models.DEFAULT_CATEGORY_ID

/**
 * Created by monakhova on 06.09.2020.
 */
const val TABLE_BOOKMARK = "TableBookmark"

const val BOOKMARK_ID = "bookmark_id"
const val BOOKMARK_CATEGORY_ID = "bookmark_category_id"
const val BOOKMARK_HEADER = "bookmark_header"
const val BOOKMARK_DESCRIPTION = "bookmark_description"
const val BOOKMARK_URL = "bookmark_url"

@Entity(
    tableName = TABLE_BOOKMARK,
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = [CATEGORY_ID],
            childColumns = [BOOKMARK_CATEGORY_ID],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index(value = [BOOKMARK_CATEGORY_ID])
    ]
)
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BOOKMARK_ID) val bookmarkId: Int = 0,
    @ColumnInfo(name = BOOKMARK_CATEGORY_ID) val bookmarkCategoryId: Int = DEFAULT_CATEGORY_ID,
    @ColumnInfo(name = BOOKMARK_HEADER) val header: String,
    @ColumnInfo(name = BOOKMARK_DESCRIPTION) val description: String,
    @ColumnInfo(name = BOOKMARK_URL) val url: String
)