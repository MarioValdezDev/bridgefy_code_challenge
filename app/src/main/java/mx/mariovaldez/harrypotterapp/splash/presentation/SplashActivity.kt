package mx.mariovaldez.harrypotterapp.splash.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import mx.mariovaldez.harrypotterapp.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            delay(LAUNCH_DELAY)
            launchSignIn()
        }
    }

    private fun launchSignIn() {
        MainActivity.launch(this)
        finish()
    }

    companion object {

        private const val LAUNCH_DELAY: Long = 1700
    }
}