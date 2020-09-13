package monakhova.bookmark.manager.presentation.ui.category.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bookmark.view.*
import monakhova.bookmark.manager.domain.models.Bookmark

/**
 * Created by monakhova on 12.09.2020.
 */
class BookmarkViewHolder(
    private val containerView: View,
    private val clickListener: (Bookmark) -> Unit
): RecyclerView.ViewHolder(containerView) {

    fun bind(bookmark: Bookmark) {
        containerView.apply {
            setOnClickListener { clickListener.invoke(bookmark) }
            header_text.text = bookmark.header
            if (bookmark.description.isEmpty()) {
                description_text.visibility = View.GONE
            } else {
                description_text.visibility = View.VISIBLE
                description_text.text = bookmark.description
            }
            link_text.text = bookmark.url
        }
    }

}