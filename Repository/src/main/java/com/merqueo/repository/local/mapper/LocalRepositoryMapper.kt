package com.merqueo.repository.local.mapper

import com.merqueo.businessmodels.business.Movie
import com.merqueo.repository.local.entities.MovieDTO

class LocalRepositoryMapper {
    companion object {
        fun mapMovieDTO(movie: Movie): MovieDTO {
            val movieDTO = MovieDTO()
            movieDTO.adult = movie.adult
            movie.backdropPath?.let {
                movieDTO.backdropPath = it
            }
            movie.mediaType?.let {
                movieDTO.mediaType = it
            }
            movie.originalLanguage?.let {
                movieDTO.originalLanguage = it
            }
            movie.originalTitle?.let {
                movieDTO.originalTitle = it
            }
            movie.overview?.let {
                movieDTO.overview = it
            }
            movieDTO.popularity = movie.popularity
            movie.posterPath?.let {
                movieDTO.posterPath = it
            }
            movie.releaseDate?.let {
                movieDTO.releaseDate = it
            }
            movie.title?.let {
                movieDTO.title = it
            }
            movieDTO.video = movie.video
            movieDTO.voteAverage = movie.voteAverage
            movieDTO.voteCount = movie.voteCount
            return movieDTO
        }

        fun mapMovieBusiness(movieDTO: MovieDTO): Movie {
            return Movie(
                adult = movieDTO.adult,
                backdropPath = movieDTO.backdropPath,
                mediaType = movieDTO.mediaType,
                originalLanguage = movieDTO.originalLanguage,
                originalTitle = movieDTO.originalTitle,
                overview = movieDTO.overview,
                popularity = movieDTO.popularity,
                posterPath = movieDTO.posterPath,
                releaseDate = movieDTO.releaseDate,
                title = movieDTO.title,
                video = movieDTO.video,
                voteAverage = movieDTO.voteAverage,
                voteCount = movieDTO.voteCount
            )
        }
    }
}
