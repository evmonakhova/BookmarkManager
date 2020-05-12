package monakhova.bookmark.manager.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_category.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.ui.ReadWriteFragment

/**
 * Created by monakhova on 09.05.2020.
 *
 * Add new category.
 */
class AddCategoryFragment: ReadWriteFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_chip.setOnClickListener {
            findNavController().navigate(R.id.action_add_category_to_choose_category)
        }
    }


    override fun onDoneActionSelected() {
        findNavController().popBackStack()
    }
}