package mx.mariovaldez.harrypotterapp.home.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.mariovaldez.harrypotterapp.R
import mx.mariovaldez.harrypotterapp.databinding.ItemCharacterBinding
import mx.mariovaldez.harrypotterapp.home.presentation.models.CharacterUI

internal class CharactersAdapter(
    private val listener: (Int) -> Unit,
) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private val characters: MutableList<CharacterUI> = mutableListOf()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        context = parent.context
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit =
        holder.bind(characters[position], position)


    override fun getItemCount(): Int = characters.size

    @SuppressLint("NotifyDataSetChanged")
    fun addCharacters(characters: List<CharacterUI>) {
        this.characters.clear()
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemCharacterBinding,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterUI, position: Int) = with(binding) {
            Glide.with(context)
                .load(character.image)
                .placeholder(R.drawable.icv_harry_potter)
                .circleCrop()
                .error(R.drawable.icv_harry_potter)
                .into(characterImageView)

            characterNameTextView.text = character.name
            characterHouseTextView.text = character.house
            root.setOnClickListener { listener(position) }
        }
    }

}