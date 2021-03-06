package monakhova.bookmark.manager.presentation.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_bookmark.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.presentation.mvi.viewmodel.BookmarkViewModel

/**
 * Created by monakhova on 13.09.2020.
 */
class EditBookmarkFragment: BookmarkFragment() {

    private val bookmarkViewModel: BookmarkViewModel by viewModels { viewModelFactory }

    private val bookmarkId by lazy { navArgs<EditBookmarkFragmentArgs>().value.bookmarkId }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindViewModel()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_chip.setOnClickListener {
            findNavController().navigate(R.id.action_edit_bookmark_to_choose_category)
        }
    }

    override fun onDoneActionSelected() {
    }

    private fun bindViewModel() {
    }
}