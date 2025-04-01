package com.example.myapplication.models

import com.example.myapplication.R

class PokemonProvider() {
    private var pokemonList: MutableList<Pokemon> = mutableListOf(
        Pokemon("Caterpie", "Bug", R.drawable.caterpie),
        Pokemon("Charmander", "Fire", R.drawable.charmander),
        Pokemon("Squirtle", "Water", R.drawable.squirtle),
        Pokemon("Pikachu", "Electric", R.drawable.pikachu),
        Pokemon("Ditto", "Normal", R.drawable.ditto),
        Pokemon("Gengar", "Ghost", R.drawable.gengar),
        Pokemon("Lucario", "Fight", R.drawable.lucario))

    fun getPokemonList(): MutableList<Pokemon> {
        return pokemonList
    }

    fun getPokemon(pokemonName: String): Pokemon?{
        return pokemonList.find { it.name == pokemonName }
    }

}
