package monakhova.bookmark.manager.presentation

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import monakhova.bookmark.manager.R
import monakhova.bookmark.manager.injection.ActivityScope

@ActivityScope
class MainActivity: DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_category,
                R.id.navigation_edit_bookmark,
                R.id.navigation_settings
            )
        )
        toolbar?.setupWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
    }

}
