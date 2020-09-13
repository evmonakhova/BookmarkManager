package monakhova.bookmark.manager.presentation.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_bookmark.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.presentation.mvi.viewmodel.BookmarkViewModel

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
    }

    override fun onDoneActionSelected() {
        bookmarkViewModel.addBookmark(
            header_edit.text.toString(),
            description_edit.text.toString(),
            link_edit.text.toString(),
            categoryId
        )
    }

    private fun bindViewModel() {
        bookmarkViewModel.bookmarkAdded.observe(this, Observer {
            findNavController().navigate(R.id.action_add_bookmark_to_category)
        })
    }
}