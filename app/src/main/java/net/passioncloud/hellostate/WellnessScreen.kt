package net.passioncloud.hellostate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import net.passioncloud.hellostate.ui.theme.HelloStateTheme

@Preview
@Composable
fun WellnessScreenPreview() {
    HelloStateTheme {
        WellnessScreen()
    }
}

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    StatefulCounter(modifier)

    val list = wellnessViewModel.tasks
    fun onCloseTask(item: WellnessTask) {
        wellnessViewModel.remove(item)
    }
//    fun k() = WellnessViewModel::changeChecked
    fun onCheckedChange(item: WellnessTask, checked: Boolean) {
        wellnessViewModel.changeChecked(item, checked)
    }

    WellnessTaskItemList(
        list = list,
        onCloseTask={ onCloseTask(it) },
        onCheckedChange = { item, checked -> onCheckedChange(item, checked) }
    )
}