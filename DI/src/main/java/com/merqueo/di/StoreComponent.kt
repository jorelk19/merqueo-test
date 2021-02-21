package com.merqueo.di

import com.merqueo.repository.RepositoryManager
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Class used to manage the koin component that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class StoreComponent : KoinComponent {
    private val repositoryManager : RepositoryManager by inject()
    val appComponent = AppComponent (
        repositoryManager = repositoryManager,
    )
}

val appComponent by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { StoreComponent().appComponent }