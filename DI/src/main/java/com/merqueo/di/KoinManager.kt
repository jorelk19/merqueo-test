package com.merqueo.di

import org.koin.core.context.startKoin

/**
 * Class used to manage the koin dependency injection that load different modules in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class KoinManager {
    companion object {
        fun initKoin(movieApi: String, apiKey: String) {
            startKoin {
                modules(
                    arrayListOf(
                        RepositoryModule(apiKey).initModule(),
                        NetworkModule(movieApi).initModule(),
                        domainModule
                    )
                )
            }
        }
    }
}