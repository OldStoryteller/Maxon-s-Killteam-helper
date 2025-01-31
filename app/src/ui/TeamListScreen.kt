import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TeamViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    private val teamDao = db.teamDao()

    // Получаем список команд в виде StateFlow (чтобы Jetpack Compose мог отслеживать изменения)
    val teams: StateFlow<List<TeamEntity>> = teamDao.getAllTeams()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    // Функция для добавления новой команды
    fun addTeam(name: String) {
        viewModelScope.launch {
            teamDao.insertTeam(TeamEntity(name = name))
        }
    }
}
