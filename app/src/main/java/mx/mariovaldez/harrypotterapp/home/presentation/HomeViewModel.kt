package mx.mariovaldez.harrypotterapp.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mx.mariovaldez.harrypotterapp.home.domain.usecases.GetCharacters
import mx.mariovaldez.harrypotterapp.home.presentation.models.CharacterUI

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getCharacters: GetCharacters
) : ViewModel() {
    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val state: StateFlow<State> get() = _state

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event: SharedFlow<Event> get() = _event

    fun findCharacters(){
        viewModelScope.launch {
            kotlin.runCatching {
                getCharacters()
            }
                .onSuccess { characters ->
                    _state.value = State.Success(characters)
                }
                .onFailure {
                    _state.value = State.Error
                }
        }
    }

    sealed class State {

        object Loading : State()

        object DefaultState : State()

        object Retry : State()

        object Error : State()

        data class Success(val characters: List<CharacterUI>) : State()
    }

    sealed class Event {

        data class ShowCharacterDetail(val id: String) : Event()
    }
}