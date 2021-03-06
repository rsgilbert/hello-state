package net.passioncloud.hellostate

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.passioncloud.hellostate.ui.theme.HelloStateTheme


@Preview
@Composable
fun WellnessTaskItemPreview() {
    HelloStateTheme {
        WellnessTaskItem(wellnessTask = WellnessTask(3, "Movie"), onClose = {}, onCheckedChange = {})
    }
}


@Composable
fun WellnessTaskItem(
    wellnessTask: WellnessTask,
    onClose: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    WellnessTaskItem(
        taskName = wellnessTask.label,
        checked = wellnessTask.checked,
        onCheckedChange = onCheckedChange,
        onClose = onClose,
        modifier=modifier
    )
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier= Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text=taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick=onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}