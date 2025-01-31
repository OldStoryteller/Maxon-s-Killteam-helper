import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CharacterListScreen(navController: NavController, teamId: Int, viewModel: CharacterViewModel) {
    val characters by viewModel.getCharacters(teamId).observeAsState(emptyList())

    Column {
        LazyColumn {
            items(characters) { character ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("character/${character.id}") }
                        .padding(16.dp)
                ) {
                    character.imageUri?.let { uri ->
                        Image(
                            painter = rememberAsyncImagePainter(uri),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(character.name, fontWeight = FontWeight.Bold)
                        Text("APL: ${character.apl}, M: ${character.m}, S: ${character.s}, W: ${character.w}")
                    }
                }
            }
        }

        Button(onClick = { navController.navigate("add_character/$teamId") }) {
            Text("Добавить персонажа")
        }
    }
}
