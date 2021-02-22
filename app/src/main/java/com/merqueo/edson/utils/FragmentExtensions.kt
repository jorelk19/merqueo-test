package com.merqueo.edson.utils

import androidx.fragment.app.Fragment
import com.merqueo.edson.ui.utils.ViewModelFactory

/**
 * Extension functions for Fragment.
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 */
fun Fragment.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory()
}
