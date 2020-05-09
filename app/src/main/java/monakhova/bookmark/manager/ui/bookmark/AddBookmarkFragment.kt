package monakhova.bookmark.manager.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_bookmark.*
import monakhova.bookmark.manager.R

/**
 * Created by monakhova on 27.04.2020.
 *
 * Add bookmark fragment. Insert link and edit bookmark information.
 */
class AddBookmarkFragment : Fragment() {

    private lateinit var addBookmarkViewModel: AddBookmarkViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addBookmarkViewModel = ViewModelProviders.of(this).get(AddBookmarkViewModel::class.java)
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        link_edit.requestFocus()
    }
}