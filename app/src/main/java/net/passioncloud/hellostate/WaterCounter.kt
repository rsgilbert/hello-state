package net.passioncloud.hellostate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*


import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}

@Composable
fun WaterCounter(modifier: Modifier =Modifier) {
    Column {
        var count by remember { mutableStateOf(30) }

        Text(
            text="You have had $count glasses.",
            modifier=modifier.padding(16.dp)
        )

        Button(
            onClick = {
                count++;
            },
            modifier=Modifier.padding(top=8.dp)
        ) {
            Text("Add one to $count")
        }
    }
}