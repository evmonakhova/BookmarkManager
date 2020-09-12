package monakhova.bookmark.manager.presentation.ui.category.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_category.view.*
import monakhova.bookmark.manager.domain.models.Category

/**
 * Created by monakhova on 12.09.2020.
 */
class CategoryViewHolder(
    private val containerView: View,
    private val clickListener: (Category) -> Unit
): RecyclerView.ViewHolder(containerView) {

    fun bind(category: Category) {
        containerView.apply {
            setOnClickListener{ clickListener.invoke(category) }
            category_item.text = category.title
        }
    }

}