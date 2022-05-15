package com.zachdachampion.hourtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zachdachampion.hourtracker.ui.theme.HourTrackerTheme
import java.time.LocalDate
import java.time.ZonedDateTime

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HourTrackerTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          Box(Modifier.padding(16.dp)) {

            EntryList(data = arrayListOf(
              EntryData(LocalDate.now().toEpochDay(), ZonedDateTime.now().minusHours(2).minusMinutes(5), ZonedDateTime.now(), "Test task"),
              EntryData(LocalDate.now().toEpochDay(), ZonedDateTime.now().minusHours(124).minusMinutes(2), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay(), ZonedDateTime.now().minusHours(0).minusMinutes(12), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 2, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 2, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 3, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 3, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 3, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 5, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 1, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 1, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 1, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
              EntryData(LocalDate.now().toEpochDay() - 1, ZonedDateTime.now().minusHours(124).minusMinutes(9), ZonedDateTime.now(), "Another task"),
            ))
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  HourTrackerTheme {
    Greeting("Android")
  }
}
