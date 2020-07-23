package com.fund.likeeat.utilities

import com.fund.likeeat.data.AppDatabase
import com.fund.likeeat.data.PlaceRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

    /**
     * Database Module
     */
    single { AppDatabase.getInstance(androidApplication()) }
    single(createdAtStart = false) { get<AppDatabase>().placeDao()}
    single { PlaceRepository(get()) }

    /**
     * ViewModel Module
     */

}