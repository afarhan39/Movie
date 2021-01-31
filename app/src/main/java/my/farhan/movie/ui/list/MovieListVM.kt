package my.farhan.movie.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.farhan.movie.data.db.Movie
import my.farhan.movie.repository.MovieRepo
import my.farhan.movie.util.TAG

class MovieListVM(private val movieRepo: MovieRepo) : ViewModel() {
    val movieList = movieRepo.moviesLD
    val selectedMovie = MutableLiveData<Movie>()

    fun onLoadMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepo.discoverMovies()
            Log.d(TAG, "aaaa")
        }
    }

    fun addMovieDetail() {
        viewModelScope.launch {
            movieRepo.getMovieDetails()
        }
    }

    fun selectMovie(movie: Movie) {
        movieRepo.selectedMovie.postValue(movie)
    }
}