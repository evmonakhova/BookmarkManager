package monakhova.bookmark.manager.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerDialogFragment
import monakhova.bookmark.manager.R
import javax.inject.Inject

/**
 * Created by monakhova on 12.05.2020.
 */
abstract class ReadWriteFragment: DaggerDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun onDoneActionSelected()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.done_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.menu_action_done) {
            onDoneActionSelected()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}