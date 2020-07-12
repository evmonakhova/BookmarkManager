package monakhova.bookmark.manager.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import monakhova.bookmark.manager.injection.FragmentScope
import monakhova.bookmark.manager.ui.bookmark.EditBookmarkFragment
import monakhova.bookmark.manager.ui.category.CategoryFragment
import monakhova.bookmark.manager.ui.category.ChooseCategoryFragment
import monakhova.bookmark.manager.ui.category.EditCategoryFragment
import monakhova.bookmark.manager.ui.settings.SettingsFragment

/**
 * Created by monakhova on 25.05.2020.
 */
@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun editBookmarkFragment(): EditBookmarkFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun categoryFragment(): CategoryFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun chooseCategoryFragment(): ChooseCategoryFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun editCategoryFragment(): EditCategoryFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun settingsFragment(): SettingsFragment
}