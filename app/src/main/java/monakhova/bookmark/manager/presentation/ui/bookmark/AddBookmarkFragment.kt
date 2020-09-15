package monakhova.bookmark.manager.presentation.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_bookmark.*
import kotlinx.android.synthetic.main.view_error.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.presentation.mvi.state.BookmarkIntent
import monakhova.bookmark.manager.presentation.mvi.state.LoadingState
import monakhova.bookmark.manager.presentation.mvi.viewmodel.BookmarkViewModel
import monakhova.bookmark.manager.presentation.ui.hide
import monakhova.bookmark.manager.presentation.ui.show

/**
 * Created by monakhova on 13.09.2020.
 */
class AddBookmarkFragment: BookmarkFragment() {

    private val bookmarkViewModel: BookmarkViewModel by viewModels { viewModelFactory }

    private val categoryId by lazy { navArgs<AddBookmarkFragmentArgs>().value.categoryId }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindViewModel()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_chip.setOnClickListener {
            findNavController().navigate(R.id.action_add_bookmark_to_choose_category)
        }
        button_retry.setOnClickListener { onAddBookmarkIntent() }
    }

    override fun onDoneActionSelected() = onAddBookmarkIntent()

    private fun bindViewModel() {
        bookmarkViewModel.state.observe(this, Observer { render(it) })
    }

    private fun onAddBookmarkIntent() {
        if (link_edit.text.isNullOrBlank()) {
            Toast.makeText(context, R.string.empty_url_message, Toast.LENGTH_SHORT).show()
            return
        }
        val addBookmark = BookmarkIntent.AddBookmark(
            categoryId,
            edit_category_title.text.toString(),
            description_edit.text.toString(),
            link_edit.text.toString()
        )
        bookmarkViewModel.onIntent(addBookmark)
    }

    private fun render(state: LoadingState) {
        when (state) {
            is LoadingState.Loading -> {
                progress_bar.show()
                view_error.hide()
                container.hide()
            }
            is LoadingState.Success<*> -> {
                findNavController().apply {
                    previousBackStackEntry?.let {
                        popBackStack()
                    } ?: navigate(R.id.action_add_bookmark_to_category)
                }
            }
            is LoadingState.Error -> {
                progress_bar.hide()
                view_error.show()
                container.hide()
            }
        }
    }
}