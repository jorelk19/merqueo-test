package com.merqueo.edson.ui.viewModels

import com.merqueo.edson.ui.models.HeaderModel
import com.merqueo.edson.ui.viewModels.base.BaseViewModel
import com.merqueo.edson.utils.Navigation

class HeaderViewModel : BaseViewModel() {
    var headerModel = HeaderModel()
    fun onBackHeader(){
        Navigation.getInstance.onBack()
    }
}