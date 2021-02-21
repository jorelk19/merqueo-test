package com.merqueo.domain

import com.merqueo.domain.base.DomainBase
import com.merqueo.repository.RepositoryManager

/**
 * Class used to manage the view model for the movie view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MovieDomain(private val repositoryManager: RepositoryManager) : DomainBase() {
}