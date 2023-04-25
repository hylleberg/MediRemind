package com.example.mediremind

import android.graphics.drawable.Drawable

data class PatientData(val name: String, val cpr: String, val pic: Int, val free: Boolean)
val patients = listOf(
    PatientData("Ove Sprogdøv", "123456-1234", R.drawable.ove, true),
    PatientData("Nancy Berggren", "654321-4321", R.drawable.nancy, true),
    PatientData("Kitty Kattemor", "212121-3232", R.drawable.kitty, true),
    PatientData("Helga Bjørnson", "887766-9999", R.drawable.helga, true),
    PatientData("Jeff Bridges", "112233-5566", R.drawable.jeff, true),
    PatientData("Mikael Mortensen", "321321-2113", R.drawable.mikael, true),
    PatientData("Henrik Hansen", "443322-1100", R.drawable.henrik, true),
    PatientData("Kitty Kattemor", "212121-3232", R.drawable.kitty, false),
    PatientData("Helga Bjørnson", "887766-9999", R.drawable.helga, false),

)
