package monakhova.bookmark.manager.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import monakhova.bookmark.manager.presentation.MainActivity
import monakhova.bookmark.manager.injection.ActivityScope

/**
 * Created by monakhova on 17.05.2020.
 */
@Module
abstract class BookmarkApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}