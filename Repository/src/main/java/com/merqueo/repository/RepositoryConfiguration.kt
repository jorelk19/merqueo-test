package com.merqueo.repository

import android.content.Context
import io.realm.Realm

class RepositoryConfiguration {
    companion object{
        fun startRealm(context: Context){
            Realm.init(context)
        }
    }
}