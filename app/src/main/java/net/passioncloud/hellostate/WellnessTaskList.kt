package net.passioncloud.hellostate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WellnessTaskItemList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (item: WellnessTask) -> Unit,
    onCheckedChange: (item: WellnessTask, checked: Boolean) -> Unit
) {
    LazyColumn(modifier=modifier) {
        items(
            items=list,
            key=WellnessTask::id
        ) { item ->
            WellnessTaskItem(
                item,
                modifier=modifier,
                onClose={onCloseTask(item)},
                onCheckedChange={onCheckedChange(item, it)}
            )
        }
    }
}