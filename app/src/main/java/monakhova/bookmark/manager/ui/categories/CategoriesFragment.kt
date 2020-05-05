package monakhova.bookmark.manager.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import monakhova.bookmark.manager.R

class CategoriesFragment : Fragment() {

    private lateinit var categoriesViewModel: CategoriesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        categoriesViewModel = ViewModelProviders.of(this).get(CategoriesViewModel::class.java)
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }
}
