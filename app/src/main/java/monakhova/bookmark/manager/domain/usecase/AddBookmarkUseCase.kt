package monakhova.bookmark.manager.domain.usecase

import monakhova.bookmark.manager.domain.repository.IBookmarkRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by monakhova on 08.09.2020.
 */
@Singleton
class AddBookmarkUseCase @Inject constructor(
    private val bookmarkRepository: IBookmarkRepository
) {

}