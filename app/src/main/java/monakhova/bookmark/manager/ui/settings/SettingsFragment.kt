package monakhova.bookmark.manager.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.mvi.SettingsViewModel

/**
 * Created by monakhova on 27.04.2020.
 *
 * App settings fragment. Edit links viewing preferences, import and export bookmarks, rate app.
 */
class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}
