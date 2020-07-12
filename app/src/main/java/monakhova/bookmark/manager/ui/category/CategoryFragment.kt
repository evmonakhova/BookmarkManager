package monakhova.bookmark.manager.ui.category

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerDialogFragment
import kotlinx.android.synthetic.main.fragment_category.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.injection.FragmentScope
import monakhova.bookmark.manager.mvi.viewmodel.CategoryViewModel
import javax.inject.Inject

/**
 * Created by monakhova on 27.04.2020.
 *
 * Category fragment. Contains list of subcategories and bookmarks.
 */
@FragmentScope
class CategoryFragment : DaggerDialogFragment() {

    companion object {
        private const val DEFAULT_CATEGORY_ID = 0
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val categoryViewModel: CategoryViewModel by viewModels { viewModelFactory }

    private val categoryId by lazy {
        navArgs<CategoryFragmentArgs>().value.categoryId
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_add.setOnClickListener {
            val openBottomSheetAction = CategoryFragmentDirections.actionOpenBottomSheetMenu(categoryId)
            findNavController().navigate(openBottomSheetAction)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(categoryId != DEFAULT_CATEGORY_ID)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.menu_action_edit) {
            val editCategoryAction = CategoryFragmentDirections.actionCategoryToEditCategory(categoryId)
            findNavController().navigate(editCategoryAction)
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}
