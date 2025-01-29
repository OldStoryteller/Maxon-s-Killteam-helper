@Dao
interface `CharacterDao.kt` {
    @Query("SELECT * FROM characters WHERE teamId = :teamId")
    fun getCharactersByTeam(teamId: Int): Flow<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)

    @Delete
    suspend fun deleteCharacter(character: CharacterEntity)
}
