package monakhova.bookmark.manager.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_add_bookmark.*
import monakhova.bookmark.manager.R

class AddBookmarkFragment : Fragment() {

    private lateinit var addBookmarkViewModel: AddBookmarkViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addBookmarkViewModel = ViewModelProviders.of(this).get(AddBookmarkViewModel::class.java)
        return inflater.inflate(R.layout.fragment_add_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        link_edit.requestFocus()
    }
}
