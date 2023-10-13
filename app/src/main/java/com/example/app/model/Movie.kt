package com.example.app.model

import android.net.wifi.aware.AwareResources
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movie (
    @StringRes val id: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val duration: Int
)