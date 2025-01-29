import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

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
