@Database(entities = [CharacterEntity::class, TeamEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun teamDao(): TeamDao
}