package com.example.mediremind.data.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date
import java.util.Random

data class HomeData(
    val id: String,
    val medId: String,
    val medtime: Long

)

val r = Random()
val low: Int = 5
val high: Int = 300


val timeUpdateList = listOf(
    HomeData("0", "0", Timestamp.now().seconds + (3 * 60)),
    HomeData("0", "1", Timestamp.now().seconds + (45 * 60)),
    HomeData("1", "0", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),
    HomeData("1", "1", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),
    HomeData("2", "0", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),
    HomeData("2", "1", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),
    HomeData("3", "0", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),
    HomeData("3", "1", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),
    HomeData("4", "0", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),
    HomeData("4", "1", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),
    HomeData("4", "2", Timestamp.now().seconds + ((r.nextInt(high - low) + low) * 60)),


    )
