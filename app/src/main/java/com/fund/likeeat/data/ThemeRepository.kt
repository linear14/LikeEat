package com.fund.likeeat.data

import androidx.lifecycle.LiveData

class ThemeRepository (
    private val themeDao: ThemeDao
){
    fun getTheme(id: Long) = themeDao.getTheme(id)

    fun getThemeList(): LiveData<List<Theme>> {
        return themeDao.getThemeList()
    }

    suspend fun getThemeList2(uid: Long): List<Theme> {
        return themeDao.getThemeList2(uid)
    }
}