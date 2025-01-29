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
fun TeamListScreen(navController: NavController, viewModel: CharacterViewModel) {
    val teams by viewModel.teams.observeAsState(emptyList())

    Column {
        LazyColumn {
            items(teams) { team ->
                Text(
                    text = team.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable { navController.navigate("team/${team.id}") }
                )
            }
        }

        Button(onClick = { viewModel.addTeam("Новая команда") }) {
            Text("Добавить команду")
        }
    }
}
