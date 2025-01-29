@Composable
fun CharacterEditScreen(viewModel: CharacterViewModel, teamId: Int, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var apl by remember { mutableStateOf("0") }
    var m by remember { mutableStateOf("0") }
    var s by remember { mutableStateOf("0") }
    var w by remember { mutableStateOf("0") }
    var weapons by remember { mutableStateOf("") }
    var abilitiesNote by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<String?>(null) }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Имя") })
        TextField(value = apl, onValueChange = { apl = it }, label = { Text("APL") })
        TextField(value = m, onValueChange = { m = it }, label = { Text("M") })
        TextField(value = s, onValueChange = { s = it }, label = { Text("S") })
        TextField(value = w, onValueChange = { w = it }, label = { Text("W") })
        TextField(value = weapons, onValueChange = { weapons = it }, label = { Text("Оружие") })
        TextField(value = abilitiesNote, onValueChange = { abilitiesNote = it }, label = { Text("Сноска") })

        Button(onClick = {
            viewModel.addCharacter(CharacterEntity(name, imageUri, apl.toInt(), m.toInt(), s.toInt(), w.toInt(), weapons, abilitiesNote, teamId))
            navController.popBackStack()
        }) {
            Text("Сохранить")
        }
    }
}
