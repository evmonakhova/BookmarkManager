package monakhova.bookmark.manager.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import monakhova.bookmark.manager.R

class AddBookmarkFragment : Fragment() {

    private lateinit var addBookmarkViewModel: AddBookmarkViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addBookmarkViewModel =
                ViewModelProviders.of(this).get(AddBookmarkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_bookmark, container, false)
        val textView: TextView = root.findViewById(R.id.text_add_bookmark)
        addBookmarkViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
