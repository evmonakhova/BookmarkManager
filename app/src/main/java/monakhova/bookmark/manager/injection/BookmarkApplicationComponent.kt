package monakhova.bookmark.manager.injection

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import monakhova.bookmark.manager.injection.module.*
import monakhova.bookmark.manager.presentation.BookmarkApplication
import javax.inject.Singleton

/**
 * Created by monakhova on 17.05.2020.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    BookmarkApplicationModule::class,
    MainActivityModule::class,
    ViewModelModule::class,
    RepositoryModule::class,
    RoomDbModule::class
])
interface BookmarkApplicationComponent: AndroidInjector<BookmarkApplication> {

    @Component.Factory
    interface Factory: AndroidInjector.Factory<BookmarkApplication>

}