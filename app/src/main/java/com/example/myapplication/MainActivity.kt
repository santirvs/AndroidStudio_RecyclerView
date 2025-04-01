package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.models.Pokemon
import com.example.myapplication.models.PokemonProvider
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Exemple_5()
            }
        }
    }
}

@Composable
fun Exemple_1(modifier:Modifier = Modifier) {
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.userimage1), contentDescription = "User image")
                Text("First User")
            }
        }
        item {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.userimage2), contentDescription = "User image")
                Text("Second User")
            }
        }
    }
}

@Composable
fun Exemple_2(modifier:Modifier = Modifier) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(10) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "User image"
                )
                Text("User name")
            }
        }
    }
}

@Composable
fun Exemple_3(modifier:Modifier = Modifier) {
    LazyColumn(Modifier.fillMaxSize()) {
        val myItems = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
            "Item 6", "Item 7", "Item 8", "Item 9", "Item 10")
        items(myItems) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "User image"
                )
                Text(it)
            }
        }
    }
}


@Composable
fun Exemple_4(modifier:Modifier = Modifier) {
    LazyColumn(Modifier.fillMaxSize()) {
        val pokemons = PokemonProvider().getPokemonList()
        items(pokemons) {
            PokemonItem(pokemon = it) { }
        }
    }
}

@Composable
fun Exemple_5(modifier:Modifier = Modifier) {
    PokemonListScreen { PokemonDetailScreen(it) { } }
}


@Composable
fun PokemonItem(pokemon: Pokemon, navigateToDetail: (String) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navigateToDetail(pokemon.name) })
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.padding(8.dp).fillMaxHeight()
            )
            Column {
                Text(pokemon.name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Text(text = "Type: ${pokemon.type}")
            }
        }
    }
}

@Composable
fun PokemonDetailScreen(pokemonName: String, navigateBack: () -> Unit) {
    val pokemon = PokemonProvider().getPokemon(pokemonName)
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(painterResource(pokemon?.image ?: R.drawable.ic_launcher_foreground),
            contentDescription = "Pokemon image"
        )
        Text(pokemon?.name ?: "Pokemon",fontSize = 28.sp,fontWeight = FontWeight.Bold)
        Text(text = "Type: ${pokemon?.type ?: "Pokemon type"}")
        Button(navigateBack) {Text("Return")}
    }
}

@Composable
fun PokemonListScreen(navigateToDetail: (String) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        val pokemons = PokemonProvider().getPokemonList()
        items(pokemons) {
            PokemonItem(pokemon = it, navigateToDetail)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecyclerView_Preview() {
    MyApplicationTheme {
        Exemple_2()
    }
}