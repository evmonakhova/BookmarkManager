package monakhova.bookmark.manager.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import monakhova.bookmark.manager.injection.ViewModelFactory
import monakhova.bookmark.manager.injection.ViewModelKey
import monakhova.bookmark.manager.mvi.viewmodel.BookmarkViewModel
import monakhova.bookmark.manager.mvi.viewmodel.CategoryViewModel
import monakhova.bookmark.manager.mvi.viewmodel.SettingsViewModel

/**
 * Created by monakhova on 17.05.2020.
 */
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BookmarkViewModel::class)
    abstract fun bindBookmarkViewModel(viewModel: BookmarkViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun categoryViewModel(viewModel: CategoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun settingsViewModel(viewModel: SettingsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}