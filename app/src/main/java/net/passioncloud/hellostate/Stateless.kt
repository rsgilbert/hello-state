package net.passioncloud.hellostate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.passioncloud.hellostate.ui.theme.HelloStateTheme

@Preview
@Composable
fun StatefulCounterPreview() {
    HelloStateTheme {
        StatefulCounter()
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    var remainingLives by rememberSaveable { mutableStateOf(5) }
    Column {
        StatelessCounter(count, onIncrement = { count++ }, modifier=modifier)
        StatelessCounter(count = remainingLives, onIncrement = { remainingLives-- })
    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if(count > 0) {
            Text("You have $count glasses")
        }
        Button(onClick=onIncrement, Modifier.padding(top=8.dp)) {
            Text(text = "Increment")
        }
    }
}