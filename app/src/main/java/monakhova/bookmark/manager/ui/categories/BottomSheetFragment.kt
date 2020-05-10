package monakhova.bookmark.manager.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.*
import monakhova.bookmark.manager.R


/**
 * Created by monakhova on 11.05.2020.
 */
class BottomSheetFragment: BottomSheetDialogFragment() {

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_category.setOnClickListener {
            findNavController().navigate(R.id.action_categories_to_add_category)
        }
        add_bookmark.setOnClickListener {
            findNavController().navigate(R.id.action_categories_to_add_bookmark)
        }
    }
}