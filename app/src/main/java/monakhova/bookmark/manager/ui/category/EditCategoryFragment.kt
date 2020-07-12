package monakhova.bookmark.manager.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_edit_category.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.mvi.viewmodel.ChangeCategoryViewModel
import monakhova.bookmark.manager.ui.ReadWriteFragment

/**
 * Created by monakhova on 09.05.2020.
 *
 * Edit existing category.
 */
class EditCategoryFragment: ReadWriteFragment() {

    private val changeCategoryViewModel: ChangeCategoryViewModel by viewModels { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_chip.setOnClickListener {
            val categoryId = navArgs<EditCategoryFragmentArgs>().value.categoryId
            val chooseCategoryAction = EditCategoryFragmentDirections.actionEditCategoryToChooseCategory(categoryId)
            findNavController().navigate(chooseCategoryAction)
        }
    }

    override fun onDoneActionSelected() {
        findNavController().popBackStack()
    }
}