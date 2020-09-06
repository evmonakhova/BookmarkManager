package monakhova.bookmark.manager.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import monakhova.bookmark.manager.data.storage.TABLE_BOOKMARK

/**
 * Created by monakhova on 06.09.2020.
 */
@Entity(tableName = TABLE_BOOKMARK)
data class BookmarkEntity(
    @PrimaryKey val bookmarkId: Int,
    val bookmarkCategoryId: Int,
    val header: String,
    val description: String,
    val url: String
)