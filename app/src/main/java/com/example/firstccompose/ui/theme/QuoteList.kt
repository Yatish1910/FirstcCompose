package com.example.firstccompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.text.Typography.quote


@Composable
fun QuoteList(data: MutableList<QuoteData>, onClick: (data : QuoteData) -> Unit) {
    LazyColumn(content = {
        items(data) {
            RenderQuoteList(data = it, onClick)
        }
    })
}

@Composable
fun RenderQuoteList(data: QuoteData, onClick: (data: QuoteData)-> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(data) }
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                imageVector = Icons.Filled.Face, contentDescription = "Author",
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .background(Color.White)
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = data.quotes, style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
            }
        }
    }
}

@Composable
fun QuoteDetail(data: QuoteData, onClick: (data: QuoteData) -> Unit) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f).clickable {  }
    ) {
        Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(32.dp)) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp, 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    imageVector = Icons.Filled.Face, contentDescription = "Author",
                    modifier = Modifier
                        .background(Color.White)
                        .size(40.dp)
                )
                Text(
                    text = data.quotes, style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
            }
        }
    }
}