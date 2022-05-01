package net.passioncloud.hellostate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*


import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.passioncloud.hellostate.ui.theme.HelloStateTheme


@Preview
@Composable
fun WellnessScreenPreview() {
    HelloStateTheme {
        WellnessScreen()
    }
}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column {
        var count by remember { mutableStateOf(0) }

        if (count > 0) {
            var showTask by remember { mutableStateOf(true) } // will be forgotten when count == 0
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you done a walk",
                    onClose = { showTask = false })
            }
            Text(
                text = "You have had $count glasses.",
                modifier = modifier.padding(16.dp)
            )
        }

        Row(
            Modifier.padding(top=8.dp)
        ) {
            Button(
                onClick = {
                    count++;
                },
                modifier = Modifier.padding(top = 8.dp),
                enabled = count < 10
            ) {
                Text("Add one")
            }

            Button(
                onClick = {
                    count--
                },
                modifier = Modifier.padding(top = 8.dp),
                enabled = count > 0
            ) {
                Text("Minus one")
            }
            Button(
                onClick = { count = 0 }
            ) {
                Text("Clear water count")
            }
        }
    }
}