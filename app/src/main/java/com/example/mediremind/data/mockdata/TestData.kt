package com.example.mediremind.data.mockdata

data class TestData(val name: String, val age: Int)

val testDataList: List<TestData> = listOf(
        TestData("Vibeke", 42),
        TestData("Hundekat", 99)
)
