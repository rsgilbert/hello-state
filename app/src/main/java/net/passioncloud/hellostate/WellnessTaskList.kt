package net.passioncloud.hellostate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.passioncloud.hellostate.ui.theme.HelloStateTheme

//
//@Preview
//@Composable
//fun WellnessTaskItemListPreview() {
//    HelloStateTheme {
//        WellnessTaskItemList()
//    }
//}

@Composable
fun WellnessTaskItemList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (item: WellnessTask) -> Unit
) {
    LazyColumn(modifier=modifier) {
        items(
            items=list,
            key=WellnessTask::id
        ) { item ->
            WellnessTaskItem(
                item.label,
                modifier=modifier,
                onClose={onCloseTask(item)}
            )
        }
    }
}