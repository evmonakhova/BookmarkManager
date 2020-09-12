package monakhova.bookmark.manager.presentation.ui.category.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.domain.models.Bookmark
import monakhova.bookmark.manager.domain.models.Category
import monakhova.bookmark.manager.domain.models.CategoryItem

/**
 * Created by monakhova on 12.09.2020.
 */

private const val VIEW_TYPE_CATEGORY = 1
private const val VIEW_TYPE_BOOKMARK = 2

class CategoryAdapter(
    private val categoryClickListener: (Category) -> Unit,
    private val bookmarkClickListener: (Bookmark) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val subcategories = mutableListOf<Category>()
    private val bookmarks = mutableListOf<Bookmark>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_CATEGORY -> {
                val view = inflater.inflate(R.layout.item_category, parent, false)
                CategoryViewHolder(view, categoryClickListener)
            }
            VIEW_TYPE_BOOKMARK -> {
                val view = inflater.inflate(R.layout.item_bookmark, parent, false)
                BookmarkViewHolder(view, bookmarkClickListener)
            }
            else -> object: RecyclerView.ViewHolder(View(parent.context)) {}
        }
    }

    override fun getItemCount() = subcategories.size + bookmarks.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItemByPosition(position)
        when (holder) {
            is CategoryViewHolder -> holder.bind(item as Category)
            is BookmarkViewHolder -> holder.bind(item as Bookmark)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < subcategories.size) {
            VIEW_TYPE_CATEGORY
        } else {
            VIEW_TYPE_BOOKMARK
        }
    }

    fun updateData(category: Category) {
        category.subcategories?.let {
            subcategories.clear()
            subcategories.addAll(it)
        }
        category.bookmarks?.let {
            bookmarks.clear()
            bookmarks.addAll(it)
        }
        notifyDataSetChanged()
    }

    fun addBookmark(bookmark: Bookmark) {
        bookmarks.add(bookmark)
        notifyItemInserted(itemCount - 1)
    }

    private fun getItemByPosition(position: Int): CategoryItem {
        return if (getItemViewType(position) == VIEW_TYPE_CATEGORY) {
            subcategories[position]
        } else {
            bookmarks[position - subcategories.size]
        }
    }
}