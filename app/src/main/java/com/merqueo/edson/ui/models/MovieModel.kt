package com.merqueo.edson.ui.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class MovieModel : BaseObservable() {
    @Bindable
    var movieName: String = ""
    @Bindable
    var movieOverview : String = ""
    @Bindable
    var movieDate : String = ""
}