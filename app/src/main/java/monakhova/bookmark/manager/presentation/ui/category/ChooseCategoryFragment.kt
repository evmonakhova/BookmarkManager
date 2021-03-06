package monakhova.bookmark.manager.presentation.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_category.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.presentation.mvi.viewmodel.ChooseCategoryViewModel
import monakhova.bookmark.manager.presentation.ui.ReadWriteFragment

/**
 * Created by monakhova on 09.05.2020.
 *
 * Choose category from list.
 */
class ChooseCategoryFragment: ReadWriteFragment() {

    private val categoryViewModel: ChooseCategoryViewModel by viewModels { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_add.setOnClickListener {
            val categoryId = navArgs<ChooseCategoryFragmentArgs>().value.parentCategoryId
            val addCategoryAction = ChooseCategoryFragmentDirections.actionChooseCategoryToAddCategory(categoryId)
            findNavController().navigate(addCategoryAction)
        }
    }

    override fun onDoneActionSelected() {
        findNavController().popBackStack()
    }
}