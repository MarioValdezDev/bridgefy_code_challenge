package mx.mariovaldez.harrypotterapp.home.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import mx.mariovaldez.harrypotterapp.databinding.ActivityHomeBinding
import mx.mariovaldez.harrypotterapp.home.presentation.adapters.CharactersAdapter
import mx.mariovaldez.harrypotterapp.ktx.exhaustive
import mx.mariovaldez.harrypotterapp.ktx.observe
import mx.mariovaldez.harrypotterapp.ktx.viewBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var charactersAdapter: CharactersAdapter

    private val viewModel: HomeViewModel by viewModels()

    private val binding: ActivityHomeBinding by viewBinding(ActivityHomeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        setupViews()
        setupObservers()
        viewModel.findCharacters()
    }

    private fun setupViews() {

        charactersAdapter = CharactersAdapter { characterPosition ->

        }
        binding.charactersRecyclerView.apply {
            adapter = charactersAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@HomeActivity,
                    DividerItemDecoration.VERTICAL,
                )
            )
            setHasFixedSize(true)
        }
    }

    private fun setupObservers() {
        viewModel.state.observe(this, ::handle)
        viewModel.event.observe(this, ::handle)
    }

    private fun handle(state: HomeViewModel.State) {
        when (state) {
            HomeViewModel.State.DefaultState -> {}
            HomeViewModel.State.Error -> {}
            HomeViewModel.State.Loading -> {}
            HomeViewModel.State.Retry -> {}
            is HomeViewModel.State.Success -> {
                charactersAdapter.addCharacters(state.characters)
            }
        }.exhaustive
    }

    private fun handle(state: HomeViewModel.Event) {
        when (state) {
            is HomeViewModel.Event.ShowCharacterDetail -> {}
        }.exhaustive
    }

    companion object {

        fun launch(from: Context) =
            from.startActivity(Intent(from, HomeActivity::class.java))
    }
}