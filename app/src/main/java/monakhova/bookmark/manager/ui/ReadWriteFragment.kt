package monakhova.bookmark.manager.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import monakhova.bookmark.manager.R

/**
 * Created by monakhova on 12.05.2020.
 */
abstract class ReadWriteFragment: Fragment() {

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