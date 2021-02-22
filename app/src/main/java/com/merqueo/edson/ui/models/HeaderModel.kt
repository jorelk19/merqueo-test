package com.merqueo.edson.ui.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class HeaderModel : BaseObservable() {
    @Bindable
    var headerTitle : String = ""
    @Bindable
    var isBackVisibility : Boolean = false
}