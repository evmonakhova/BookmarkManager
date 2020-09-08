package monakhova.bookmark.manager.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.*
import monakhova.bookmark.manager.R


/**
 * Created by monakhova on 11.05.2020.
 *
 * Bottom sheet menu to add bookmarks or categories.
 */
class BottomSheetFragment: BottomSheetDialogFragment() {

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentCategoryId = navArgs<BottomSheetFragmentArgs>().value.parentCategoryId
        add_category.setOnClickListener {
            val addCategoryAction = BottomSheetFragmentDirections.actionCategoryToAddCategory(parentCategoryId)
            findNavController().navigate(addCategoryAction)
        }
        add_bookmark.setOnClickListener {
            val addBookmarkAction = BottomSheetFragmentDirections.actionCategoryToAddBookmark(parentCategoryId)
            findNavController().navigate(addBookmarkAction)
        }
    }
}