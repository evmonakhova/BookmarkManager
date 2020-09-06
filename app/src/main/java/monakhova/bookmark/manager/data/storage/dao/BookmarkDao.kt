package monakhova.bookmark.manager.data.storage.dao

import androidx.room.*
import monakhova.bookmark.manager.data.storage.TABLE_BOOKMARK
import monakhova.bookmark.manager.data.storage.entities.BookmarkEntity

/**
 * Created by monakhova on 06.09.2020.
 */
@Dao
interface BookmarkDao {
    @Query( "SELECT * FROM $TABLE_BOOKMARK")
    fun fetchBookmarks(): List<BookmarkEntity>

    @Query( "SELECT * FROM $TABLE_BOOKMARK WHERE bookmarkId = :id")
    fun fetchBookmark(id: Int): List<BookmarkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookmark(bookmarkEntity: BookmarkEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateBookmark(bookmarkEntity: BookmarkEntity)

    @Delete
    fun deleteBookmark(bookmarkEntity: BookmarkEntity)
}