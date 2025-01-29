class CharacterViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)

    val teams = db.teamDao().getTeams().asLiveData()

    fun getCharacters(teamId: Int) = db.characterDao().getCharactersByTeam(teamId).asLiveData()

    fun addCharacter(character: CharacterEntity) = viewModelScope.launch {
        db.characterDao().insertCharacter(character)
    }

    fun addTeam(name: String) = viewModelScope.launch {
        db.teamDao().insertTeam(TeamEntity(name = name))
    }
}
