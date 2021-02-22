package com.merqueo.edson.ui.viewModels

import com.merqueo.edson.ui.models.HeaderModel
import com.merqueo.edson.ui.viewModels.base.BaseViewModel
import com.merqueo.edson.utils.Navigation

/**
 * Class used to manage the view model for the header view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class HeaderViewModel : BaseViewModel() {
    var headerModel = HeaderModel()

    /**
     * Function to execute back in header button
     * */
    fun onBackHeader(){
        Navigation.getInstance.onBack()
    }

    /**
     * Method to set the values in header
     * */
    fun setHeaderValues(headerTitle: String, isBackVisibility: Boolean) {
        headerModel.headerTitle = headerTitle
        headerModel.isBackVisibility = isBackVisibility
    }
}