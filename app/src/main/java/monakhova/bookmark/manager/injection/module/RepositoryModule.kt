package monakhova.bookmark.manager.injection.module

import dagger.Binds
import dagger.Module
import monakhova.bookmark.manager.data.repository.BookmarkRepository
import monakhova.bookmark.manager.data.repository.CategoryRepository
import monakhova.bookmark.manager.domain.repository.IBookmarkRepository
import monakhova.bookmark.manager.domain.repository.ICategoryRepository
import javax.inject.Singleton

/**
 * Created by monakhova on 18.05.2020.
 */
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideBookmarkRepo(repo: BookmarkRepository): IBookmarkRepository

    @Binds
    @Singleton
    abstract fun provideCategoryRepo(repo: CategoryRepository): ICategoryRepository
}