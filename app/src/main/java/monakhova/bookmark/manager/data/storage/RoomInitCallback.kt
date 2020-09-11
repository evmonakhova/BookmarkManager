package monakhova.bookmark.manager.data.storage

import android.content.ContentValues
import androidx.room.OnConflictStrategy
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import monakhova.bookmark.manager.data.storage.entities.CATEGORY_ID
import monakhova.bookmark.manager.data.storage.entities.CATEGORY_TITLE
import monakhova.bookmark.manager.data.storage.entities.TABLE_CATEGORY
import monakhova.bookmark.manager.data.storage.entities.CategoryEntity
import monakhova.bookmark.manager.domain.models.DEFAULT_CATEGORY_ID

/**
 * Callback for [BookmarkRoomDatabase].
 * It is necessary to add default [CategoryEntity] when database created for the first time.
 */
class RoomInitCallback: RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        GlobalScope.launch(Dispatchers.IO) {
            addDefaultCategory(db)
        }
    }

    private suspend fun addDefaultCategory(db: SupportSQLiteDatabase) = db.apply {
        withContext(Dispatchers.IO) {
            beginTransaction()
            try {
                val values = ContentValues().apply {
                    put(CATEGORY_ID, DEFAULT_CATEGORY_ID)
                    put(CATEGORY_TITLE, "")
                }
                insert(TABLE_CATEGORY, OnConflictStrategy.REPLACE, values)
                setTransactionSuccessful()
            } finally {
                endTransaction()
            }
        }
    }
}