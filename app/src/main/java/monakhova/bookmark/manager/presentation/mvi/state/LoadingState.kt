package monakhova.bookmark.manager.presentation.mvi.state

/**
 * Created by monakhova on 15.09.2020.
 */
sealed class LoadingState {
    object Loading: LoadingState()
    data class Success<out T>(val data: T): LoadingState()
    object Error: LoadingState()
}