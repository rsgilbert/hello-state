package net.passioncloud.hellostate

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel


class WellnessViewModel : ViewModel() {
    private val _tasks : MutableList<WellnessTask> = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeChecked(item: WellnessTask, checked: Boolean) {
        val changeIdx = _tasks.indexOfFirst { it.id == item.id }
        _tasks[changeIdx] = WellnessTask(item.id, item.label, checked)
    }
}


private fun getWellnessTasks() : List<WellnessTask> = List(30) { i ->
    WellnessTask(i, "Task # $i")
}

