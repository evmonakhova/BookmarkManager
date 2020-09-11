package monakhova.bookmark.manager.presentation.ui.bookmark

import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_bookmark.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.domain.models.DEFAULT_CATEGORY_ID
import monakhova.bookmark.manager.presentation.mvi.viewmodel.BookmarkViewModel
import monakhova.bookmark.manager.presentation.ui.ReadWriteFragment

/**
 * Created by monakhova on 27.04.2020.
 *
 * Edit bookmark fragment.
 */
class EditBookmarkFragment: ReadWriteFragment() {

    private val bookmarkViewModel: BookmarkViewModel by viewModels { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindViewModel()
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        link_edit.requestFocus()
        category_chip.setOnClickListener {
            findNavController().navigate(R.id.action_edit_bookmark_to_choose_category)
        }
        link_edit.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                Linkify.addLinks((s as Spannable), Linkify.WEB_URLS)
            }

            override fun afterTextChanged(s: Editable) {
                Linkify.addLinks(s, Linkify.WEB_URLS)
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        })
    }

    override fun onDoneActionSelected() {
        bookmarkViewModel.addBookmark(
            header_edit.text.toString(),
            description_edit.text.toString(),
            link_edit.text.toString(),
            DEFAULT_CATEGORY_ID
        )
    }

    private fun bindViewModel() {
        bookmarkViewModel.bookmarkAdded.observe(this@EditBookmarkFragment, Observer {
            findNavController().navigate(R.id.action_edit_bookmark_to_category)
        })
    }
}