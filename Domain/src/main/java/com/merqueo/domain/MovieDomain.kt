package com.merqueo.domain

import com.merqueo.businessmodels.result.IMovieResult
import com.merqueo.domain.base.DomainBase
import com.merqueo.repository.RepositoryManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Class used to manage the view model for the movie view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MovieDomain(private val repositoryManager: RepositoryManager) : DomainBase() {
    fun getMovies(movieResult : IMovieResult){
        launch(Dispatchers.Main) {
            try {
                errorManager.onShowLoader()
                if(hasInternet) {
                    val movies = withContext(Dispatchers.IO) { repositoryManager.getRemoteMovies() }
                    movieResult.setMovieList(movies)
                    repositoryManager.deleteAllMoviesLocal()
                    for (movie in movies) {
                        repositoryManager.saveMovieLocal(movie)
                    }
                }else{
                    val movies = repositoryManager.getLocalMovies()
                    movieResult.setMovieList(movies)
                }
                errorManager.onHideLoader()
            } catch (exception: HttpException) {
                errorManager.onServiceErrorHttpException(exception.message, exception)
            } catch (exception: SocketTimeoutException) {
                errorManager.onSocketTimeoutException(exception.message)
            } catch (exception: IOException) {
                errorManager.onSocketTimeoutException(exception.message)
            }

        }
    }
}