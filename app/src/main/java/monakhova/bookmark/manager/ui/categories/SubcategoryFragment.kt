package monakhova.bookmark.manager.ui.categories

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.fragment.findNavController
import monakhova.bookmark.manager.R

/**
 * Created by monakhova on 09.05.2020.
 *
 * View category content: subcategories and bookmarks.
 */
class SubcategoryFragment: CategoriesFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.menu_action_edit) {
            findNavController().navigate(R.id.action_view_category_to_edit_category)
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}