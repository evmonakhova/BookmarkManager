package monakhova.bookmark.manager.data.storage.dao

import androidx.room.*
import monakhova.bookmark.manager.data.storage.TABLE_BOOKMARK
import monakhova.bookmark.manager.data.storage.entities.BookmarkEntity

/**
 * Created by monakhova on 06.09.2020.
 */
@Dao
interface BookmarkDao {
    @Query( "SELECT * FROM $TABLE_BOOKMARK WHERE bookmarkId = :id")
    suspend fun fetchBookmark(id: Int): BookmarkEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBookmark(bookmarkEntity: BookmarkEntity)

    @Delete
    suspend fun deleteBookmark(bookmarkEntity: BookmarkEntity)
}