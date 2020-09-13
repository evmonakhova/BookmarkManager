package monakhova.bookmark.manager.presentation.ui.bookmark

import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_bookmark.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.presentation.ui.ReadWriteFragment

/**
 * Created by monakhova on 27.04.2020.
 *
 * Edit bookmark fragment.
 */
abstract class BookmarkFragment: ReadWriteFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        link_edit.requestFocus()
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
}
