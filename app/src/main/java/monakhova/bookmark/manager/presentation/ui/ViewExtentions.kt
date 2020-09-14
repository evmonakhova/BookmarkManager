package monakhova.bookmark.manager.presentation.ui

import android.view.View

/**
 * Created by monakhova on 14.09.2020.
 */
fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}