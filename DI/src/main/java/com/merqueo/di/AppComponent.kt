package com.merqueo.di

import com.merqueo.repository.RepositoryManager

/**
 * Class used to manage the components from application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class AppComponent(
    val repositoryManager: RepositoryManager
)
