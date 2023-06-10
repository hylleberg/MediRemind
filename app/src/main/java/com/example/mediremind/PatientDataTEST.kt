package com.example.mediremind

data class PatientDataTEST(val name: String, val cpr: String, val pic: Int, val free: Boolean)
val patients_test = listOf(
    PatientDataTEST("Ove Sprogdøv", "123456-1234", R.drawable.ove, true),
    PatientDataTEST("Nancy Berggren", "654321-4321", R.drawable.nancy, true),
    PatientDataTEST("Kitty Kattemor", "212121-3232", R.drawable.kitty, true),
    PatientDataTEST("Helga Bjørnson", "887766-9999", R.drawable.helga, true),
    PatientDataTEST("Kitty Kattemor", "212121-3232", R.drawable.kitty, false),
    PatientDataTEST("Helga Bjørnson", "887766-9999", R.drawable.helga, false),

    )