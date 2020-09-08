package monakhova.bookmark.manager.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerDialogFragment
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.presentation.mvi.viewmodel.SettingsViewModel
import javax.inject.Inject

/**
 * Created by monakhova on 27.04.2020.
 *
 * App settings fragment. Edit links viewing preferences, import and export bookmarks, rate app.
 */
class SettingsFragment : DaggerDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val settingsViewModel: SettingsViewModel by viewModels { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}
