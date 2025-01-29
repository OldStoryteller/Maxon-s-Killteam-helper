import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val imageUri: String?,
    val apl: Int,
    val m: Int,
    val s: Int,
    val w: Int,
    val weapons: String, // Список оружия через запятую
    val abilitiesNote: String,
    val teamId: Int // Привязка к команде
)

