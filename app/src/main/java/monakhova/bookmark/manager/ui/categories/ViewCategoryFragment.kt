package monakhova.bookmark.manager.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import monakhova.bookmark.manager.R

/**
 * Created by monakhova on 09.05.2020.
 *
 * View category content: subcategories and bookmarks.
 */
class ViewCategoryFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }
}