package mx.mariovaldez.harrypotterapp.ktx

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal fun <T> Flow<T>.observe(lifecycleOwner: LifecycleOwner, collect: (T) -> Unit): Job =
    onEach { collect(it) }.launchIn(lifecycleOwner.lifecycleScope)
