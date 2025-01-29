@Dao
interface TeamDao {
    @Query("SELECT * FROM teams")
    fun getTeams(): Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: TeamEntity)

    @Delete
    suspend fun deleteTeam(team: TeamEntity)
}