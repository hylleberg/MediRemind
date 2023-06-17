package com.example.mediremind.ui.screens.home.model

import com.example.mediremind.data.model.HomeData
import com.example.mediremind.data.model.timeUpdateList


data class HomeScreenState(
    val homedata: List<HomeData> = timeUpdateList,
)
