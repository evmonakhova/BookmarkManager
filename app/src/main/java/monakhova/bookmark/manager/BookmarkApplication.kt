package monakhova.bookmark.manager

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import monakhova.bookmark.manager.injection.DaggerBookmarkApplicationComponent

/**
 * Created by monakhova on 17.05.2020.
 */
class BookmarkApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<BookmarkApplication> {
        return DaggerBookmarkApplicationComponent.factory().create(this)
    }

}