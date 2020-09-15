package monakhova.bookmark.manager.presentation.ui.category

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerDialogFragment
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.progress_bar
import kotlinx.android.synthetic.main.view_error.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.domain.models.Category
import monakhova.bookmark.manager.domain.models.DEFAULT_CATEGORY_ID
import monakhova.bookmark.manager.injection.FragmentScope
import monakhova.bookmark.manager.presentation.mvi.state.CategoryIntent
import monakhova.bookmark.manager.presentation.mvi.state.LoadingState
import monakhova.bookmark.manager.presentation.mvi.viewmodel.CategoryViewModel
import monakhova.bookmark.manager.presentation.ui.category.adapter.CategoryAdapter
import monakhova.bookmark.manager.presentation.ui.hide
import monakhova.bookmark.manager.presentation.ui.show
import javax.inject.Inject

/**
 * Created by monakhova on 27.04.2020.
 *
 * Category fragment. Contains list of subcategories and bookmarks.
 */
@FragmentScope
class CategoryFragment : DaggerDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val categoryViewModel: CategoryViewModel by viewModels { viewModelFactory }

    private val categoryId by lazy { navArgs<CategoryFragmentArgs>().value.categoryId }

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindViewModel()
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryAdapter = CategoryAdapter({
            Log.d(getLogTag(), "Category ${it.id} clicked.")
            val openSubcategoryAction = CategoryFragmentDirections.actionCategoryToSubcategory(it.id)
            findNavController().navigate(openSubcategoryAction)
        }, {
            Log.d(getLogTag(), "Bookmark ${it.id} clicked.")
            val openBookmarkAction = CategoryFragmentDirections.actionCategoryToEditBookmark(it.id)
            findNavController().navigate(openBookmarkAction)
        })
        category_list.adapter = categoryAdapter
        fab_add.setOnClickListener {
            val openBottomSheetAction = CategoryFragmentDirections.actionOpenBottomSheetMenu(categoryId)
            findNavController().navigate(openBottomSheetAction)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(categoryId != DEFAULT_CATEGORY_ID)
        categoryViewModel.onIntent(CategoryIntent.LoadCategory(categoryId))
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

    private fun bindViewModel() {
        categoryViewModel.state.observe(this, Observer { render(it) })
    }

    private fun render(state: LoadingState) {
        when (state) {
            is LoadingState.Loading -> {
                progress_bar.show()
                view_error.hide()
                category_list.hide()
                fab_add.visibility = View.GONE
            }
            is LoadingState.Success<*> -> {
                progress_bar.hide()
                view_error.hide()
                category_list.show()
                fab_add.visibility = View.VISIBLE
                categoryAdapter.updateData(state.data as Category)
            }
            is LoadingState.Error -> {
                progress_bar.hide()
                view_error.show()
                category_list.hide()
                fab_add.visibility = View.GONE
            }
        }
    }

    private fun getLogTag() = javaClass.simpleName
}
