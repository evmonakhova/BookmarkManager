package monakhova.bookmark.manager.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import monakhova.bookmark.manager.data.storage.TABLE_BOOKMARK
import monakhova.bookmark.manager.presentation.mvi.model.DEFAULT_CATEGORY_ID

/**
 * Created by monakhova on 06.09.2020.
 */
@Entity(tableName = TABLE_BOOKMARK)
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val bookmarkId: Int = 0,
    val bookmarkCategoryId: Int = DEFAULT_CATEGORY_ID,
    val header: String,
    val description: String,
    val url: String
)