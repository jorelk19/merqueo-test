package com.merqueo.di

import com.merqueo.businessmodels.api.MovieApi
import com.merqueo.businessmodels.result.IMovieResult
import com.merqueo.domain.IMovieDomain
import com.merqueo.repository.RepositoryManager
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Variable used to load the repository modules that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class RepositoryModule(private val apiKey: String) {
    /**
     * Provider to get the repository manager instance
     * */
    private fun provideMovieRepository(movieApi: MovieApi) = RepositoryManager(movieApi, apiKey)

    fun initModule(): Module {
        return module {
            single { provideMovieRepository(get()) }
        }
    }
}


