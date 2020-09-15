package monakhova.bookmark.manager.presentation.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_edit_category.*
import kotlinx.android.synthetic.main.view_error.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.presentation.mvi.state.CategoryIntent
import monakhova.bookmark.manager.presentation.mvi.state.LoadingState
import monakhova.bookmark.manager.presentation.mvi.viewmodel.ChangeCategoryViewModel
import monakhova.bookmark.manager.presentation.ui.ReadWriteFragment
import monakhova.bookmark.manager.presentation.ui.hide
import monakhova.bookmark.manager.presentation.ui.show

/**
 * Created by monakhova on 09.05.2020.
 *
 * Add new category.
 */
class AddCategoryFragment: ReadWriteFragment() {

    private val changeCategoryViewModel: ChangeCategoryViewModel by viewModels { viewModelFactory }

    private val parentCategoryId by lazy { navArgs<AddCategoryFragmentArgs>().value.parentCategoryId }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindViewModel()
        return inflater.inflate(R.layout.fragment_edit_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_chip.setOnClickListener {
            val chooseCategoryAction = AddCategoryFragmentDirections.actionAddCategoryToChooseCategory(parentCategoryId)
            findNavController().navigate(chooseCategoryAction)
        }
    }

    override fun onDoneActionSelected() {
        if (edit_category_title.text.isNullOrBlank()) {
            Toast.makeText(context, R.string.empty_category_title_message, Toast.LENGTH_SHORT).show()
            return
        }
        val addCategory = CategoryIntent.AddCategory(parentCategoryId, edit_category_title.text.toString())
        changeCategoryViewModel.onIntent(addCategory)
    }

    private fun bindViewModel() {
        changeCategoryViewModel.state.observe(this, Observer { render(it) })
    }

    private fun render(state: LoadingState) {
        when (state) {
            is LoadingState.Loading -> renderLoading()
            is LoadingState.Success<*> -> {
                renderSuccess()
                findNavController().popBackStack()
            }
            is LoadingState.Error -> renderError()
        }
    }

    private fun renderLoading() {
        progress_bar.show()
        view_error.hide()
        edit_category_title.hide()
        category_chip.hide()
    }

    private fun renderSuccess() {
        progress_bar.hide()
        view_error.hide()
        edit_category_title.show()
        category_chip.show()
    }

    private fun renderError() {
        progress_bar.hide()
        view_error.show()
        edit_category_title.hide()
        category_chip.hide()
    }
}