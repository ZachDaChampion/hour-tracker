package com.zachdachampion.hourtracker

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.Duration
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

data class EntryData(
  val startDay: Long,
  val startTime: ZonedDateTime,
  val endTime: ZonedDateTime,
  val task: String?,
)

@Composable
fun Entry(data: EntryData) {

  val duration = Duration.between(data.startTime, data.endTime)
  val days = duration.toDays()
  val hours = duration.toHours() - (days * 24)
  val minutes = duration.toMinutes() - (days * 24 * 60) - (hours * 60)

  val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm Z")
  val startString = data.startTime.format(formatter)
  val endString = data.endTime.format(formatter)
  val durationString = when {
    days > 0 -> "${days}d ${hours}h ${minutes}m"
    hours > 0 -> "${hours}h ${minutes}m"
    else -> "$minutes minutes"
  }

  Row {
    Column(Modifier.weight(1f)) {
      Text(text = durationString, style = MaterialTheme.typography.titleLarge)
      if (data.task != null)
        Text(text = data.task, style = MaterialTheme.typography.bodyLarge)
    }
    Column(horizontalAlignment = Alignment.End) {
      Text(text = startString, style = MaterialTheme.typography.bodySmall)
      Text(text = endString, style = MaterialTheme.typography.bodySmall)
    }
  }
}

@Composable
fun EntryHeader(data: Long) {

  val formatter = DateTimeFormatter.ofPattern("EEEE, MMM d")
  val date = LocalDate.ofEpochDay(data)
  val dateString = date.format(formatter)

    Box(Modifier
      .fillMaxWidth()
      .background(MaterialTheme.colorScheme.background)) {
      Text(dateString, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(top = 56.dp, bottom = 16.dp))
      Spacer(Modifier
        .fillMaxWidth()
        .align(Alignment.BottomStart)
        .height(16.dp)
        .offset(y = 16.dp)
        .background(brush = Brush.verticalGradient(colors = listOf(MaterialTheme.colorScheme.background, Color.Transparent))))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EntryList(data: List<EntryData>) {

  val grouped = data.groupBy { it.startDay }

  LazyColumn {
    grouped.forEach { (day, entries) ->
      stickyHeader {
        EntryHeader(data = day)
      }

      items(items = entries, itemContent = { entry ->
        Box(Modifier.padding(vertical = 8.dp)) { Entry(entry) }
      })
    }
  }
}