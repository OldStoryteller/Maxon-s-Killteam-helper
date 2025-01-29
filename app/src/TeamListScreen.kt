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
