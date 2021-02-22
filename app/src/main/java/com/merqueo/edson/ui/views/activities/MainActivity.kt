package com.merqueo.edson.ui.views.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.merqueo.edson.R
import com.merqueo.edson.databinding.ActivityMainBinding
import com.merqueo.edson.ui.views.activities.base.BaseFragmentActivity
import com.merqueo.edson.ui.views.fragments.MoviesFragment
import com.merqueo.edson.utils.Navigation

class MainActivity : BaseFragmentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        initControls()
    }

    private fun initControls() {
        Navigation.getInstance.attachFragment(MoviesFragment(), R.id.fragment_container)
    }
}