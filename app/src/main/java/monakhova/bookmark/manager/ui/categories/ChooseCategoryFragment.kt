package monakhova.bookmark.manager.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_categories.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.ui.ReadWriteFragment

/**
 * Created by monakhova on 09.05.2020.
 *
 * Choose category from list.
 */
class ChooseCategoryFragment: ReadWriteFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_add.setOnClickListener {
            findNavController().navigate(R.id.action_choose_category_to_add_category)
        }
    }

    override fun onDoneActionSelected() {
        findNavController().popBackStack()
    }
}