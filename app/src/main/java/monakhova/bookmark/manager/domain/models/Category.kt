package monakhova.bookmark.manager.domain.models

/**
 * Created by monakhova on 18.05.2020.
 */
data class Category(
    val id: Int,
    val title: String,
    val subcategories: List<Category>,
    val bookmarks: List<Bookmark>,
    var parentCategory: Category?
)