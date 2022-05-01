package net.passioncloud.hellostate


data class WellnessTask(
    val id: Int,
    val label: String,
    val checked: Boolean = false
)