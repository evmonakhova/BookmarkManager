package monakhova.bookmark.manager.ui.bookmark

import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_bookmark.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.mvi.BookmarkViewModel
import monakhova.bookmark.manager.ui.ReadWriteFragment

/**
 * Created by monakhova on 27.04.2020.
 *
 * Edit bookmark fragment.
 */
class EditBookmarkFragment: ReadWriteFragment() {

    private lateinit var bookmarkViewModel: BookmarkViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bookmarkViewModel = ViewModelProviders.of(this).get(BookmarkViewModel::class.java)
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
        findNavController().navigate(R.id.action_edit_bookmark_to_category)
    }
}
