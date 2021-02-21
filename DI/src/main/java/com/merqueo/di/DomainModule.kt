package com.merqueo.di

import com.merqueo.domain.MovieDomain
import com.merqueo.repository.RepositoryManager
import org.koin.dsl.module

/**
 * Variable used to load the domain modules that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
val domainModule = module {
    single { provideMovieDomain(get()) }
}

private fun provideMovieDomain(repositoryManager: RepositoryManager) = MovieDomain(repositoryManager)


