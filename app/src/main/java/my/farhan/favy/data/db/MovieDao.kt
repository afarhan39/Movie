package my.farhan.favy.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/***
 * DAO (Data Access Object) to Access [Movie]
 */
@Dao
interface MovieDao {
    @Query("SELECT * FROM Movie")
    suspend fun findAll(): List<Movie>

    @Query("SELECT * FROM Movie WHERE movieId = :movieId")
    suspend fun findMovie(movieId: Int): Movie

    @Query("SELECT * FROM Movie")
    fun findAllLD(): LiveData<List<Movie>>

    @Query("SELECT * FROM Movie WHERE movieId = :id")
    fun findMovieLD(id: Int): LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addList(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(movie: Movie)

    @Query("DELETE FROM Movie")
    suspend fun deleteAllMovie()
}