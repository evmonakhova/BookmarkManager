package monakhova.bookmark.manager.injection.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import monakhova.bookmark.manager.data.source.BookmarkDbSource
import monakhova.bookmark.manager.data.source.CategoryDbSource
import monakhova.bookmark.manager.data.storage.BOOKMARK_DATABASE
import monakhova.bookmark.manager.data.storage.BookmarkRoomDatabase
import monakhova.bookmark.manager.data.storage.RoomInitCallback
import monakhova.bookmark.manager.domain.source.IBookmarkDbSource
import monakhova.bookmark.manager.domain.source.ICategoryDbSource
import monakhova.bookmark.manager.presentation.BookmarkApplication
import javax.inject.Singleton

/**
 * Created by monakhova on 08.09.2020.
 */
@Module
class RoomDbModule {
    @Singleton
    @Provides
    fun provideBookmarkRoomDatabase(app: BookmarkApplication): BookmarkRoomDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            BookmarkRoomDatabase::class.java,
            BOOKMARK_DATABASE
        ).addCallback(RoomInitCallback()).build()
    }

    @Singleton
    @Provides
    fun provideBookmarkDbSource(bookmarkDatabase: BookmarkRoomDatabase): IBookmarkDbSource {
        return BookmarkDbSource(bookmarkDatabase.bookmarkDao())
    }

    @Singleton
    @Provides
    fun provideCategoryDbSource(bookmarkDatabase: BookmarkRoomDatabase): ICategoryDbSource {
        return CategoryDbSource(bookmarkDatabase.categoryDao())
    }
}