package monakhova.bookmark.manager.data.storage.entities

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by monakhova on 06.09.2020.
 */
data class CategoryDetails(
    @Embedded val category: CategoryEntity,
    @Relation(parentColumn = CATEGORY_ID, entityColumn = PARENT_CATEGORY_ID)
    val parentCategory: CategoryEntity?,
    @Relation(parentColumn = CATEGORY_ID, entityColumn = BOOKMARK_CATEGORY_ID)
    val bookmarks: List<BookmarkEntity>?,
    @Relation(parentColumn = PARENT_CATEGORY_ID, entityColumn = CATEGORY_ID)
    val subcategories: List<CategoryEntity>?
)