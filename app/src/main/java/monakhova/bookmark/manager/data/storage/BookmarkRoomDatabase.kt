package monakhova.bookmark.manager.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import monakhova.bookmark.manager.data.storage.dao.BookmarkDao
import monakhova.bookmark.manager.data.storage.dao.CategoryDao
import monakhova.bookmark.manager.data.storage.entities.BookmarkEntity
import monakhova.bookmark.manager.data.storage.entities.CategoryEntity

/**
 * Created by monakhova on 06.09.2020.
 */
const val BOOKMARK_DATABASE = "Bookmarks.db"

@Database(
    entities = [BookmarkEntity::class, CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BookmarkRoomDatabase: RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun categoryDao(): CategoryDao
}