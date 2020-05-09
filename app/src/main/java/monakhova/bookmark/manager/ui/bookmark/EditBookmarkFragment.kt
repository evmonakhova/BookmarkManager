package monakhova.bookmark.manager.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import monakhova.bookmark.manager.R

/**
 * Created by monakhova on 27.04.2020.
 *
 * Edit bookmark fragment.
 */
class EditBookmarkFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }
}
