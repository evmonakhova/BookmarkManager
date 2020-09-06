package monakhova.bookmark.manager.data.storage.entities

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by monakhova on 06.09.2020.
 */
data class CategoryWithBookmarksAndSubcategories(
    @Embedded val category: CategoryEntity,
    @Relation(parentColumn = "categoryId", entityColumn = "bookmarkCategoryId")
    val bookmarks: List<BookmarkEntity>,
    @Relation(parentColumn = "categoryId", entityColumn = "parentCategoryId")
    val subcategories: List<CategoryEntity>
)