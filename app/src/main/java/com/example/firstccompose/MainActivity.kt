@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.firstccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstccompose.ui.theme.FirstcComposeTheme
import com.example.firstccompose.ui.theme.Navigation
import com.example.firstccompose.ui.theme.QuoteData
import com.example.firstccompose.ui.theme.QuoteList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstcComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MyApp(modifier = Modifier)
                }
            }
        }
    }
}


@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnBoarding by rememberSaveable {
        mutableStateOf(false)
    }
    Surface(
        modifier = modifier
    ) {
        if (!shouldShowOnBoarding) {
            OnBoarding(modifier, onContinueClicked = { shouldShowOnBoarding = true })
        } else {
            FavoriteCard()
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }
) {
//    Column(                                               */Simple Column/*
//        modifier = modifier.padding(vertical = 4.dp)
//    ) {
//        names.forEach { name ->
//            Greeting(name = name)
//        }
//    }
    LazyColumn(modifier = Modifier.padding(all = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}


@Composable
fun Greeting(name: String) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ), modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
    ) {
        CardContent(name)
    }
}

@Composable
fun CardContent(name: String) {
    var expandable by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello")
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expandable) {
                Text(
                    text = name, style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }

        }
        IconButton(onClick = { expandable = !expandable }) {
            Icon(
                imageVector = if (expandable) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expandable) {
                    stringResource(R.string.check)
                } else {
                    stringResource(R.string.notCheck)
                }
            )
        }
    }
}


@Composable
private fun SearchBar(modifier: Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        placeholder = {
            Text("Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp),

        )
}

@Composable
private fun AlignYourBody(
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(88.dp)
        )
        Text(
            text = "Inversion",
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0E)
@Composable
fun AlignBodyPreview() {
    FirstcComposeTheme {
        AlignYourBody(modifier = Modifier.padding(8.dp))
    }
}

@Composable
private fun OnBoarding(
    modifier: Modifier = Modifier, onContinueClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Welcome to Universe 1")
        Button(
            modifier = Modifier.padding(24.dp), onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
private fun FavoriteCard(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.layouts23_1440),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(text = "Week of the Year",
                modifier = Modifier.padding(horizontal = 16.dp) ,style = MaterialTheme.typography.titleMedium,)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCard() {
    FirstcComposeTheme {
        FavoriteCard()
    }
}


//onContinueClicked: () -> Unit,
//modifier: Modifier = Modifier
//) {
//
//    Column(
//        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Welcome to the Basics Codelab!")
//        Button(
//            modifier = Modifier.padding(vertical = 24.dp),
//            onClick = onContinueClicked
//        ) {
//            Text("Continue")
//        }
//    }

@Preview
@Composable
private fun Default() {
    FirstcComposeTheme {
        MyApp()
    }
}


@Composable
fun App(quoteArrayList: MutableList<QuoteData>) {
    if (Navigation.currentPage.value == Pages.LISTING) {
        QuoteList(data = quoteArrayList) {
            Navigation.switch(it)
        }
    } else {

    }

}

@Preview
@Composable
fun PreviewList() {
    FirstcComposeTheme {

    }
}

@Composable
fun Conversation(list: List<String>) {
    LazyColumn {
        items(list) {
            ItemList(content = it)
        }
    }
}

@Composable
fun ItemList(content: String) {
    Row(modifier = Modifier.padding(all = 10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Icons",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = "Yatish")
            Spacer(modifier = Modifier.height(6.dp))
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = content,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
//@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
//@Composable
//private fun Greeting() {
//
//    Text(
//        text = "Yatish", fontStyle = FontStyle.Italic,
//        fontWeight = FontWeight.ExtraBold,
//
//        )
//    Spacer(modifier = Modifier.height(80.dp))
//
//    Image(
//        painter = painterResource(id = R.drawable.ic_launcher_foreground),
//
//        contentDescription = "Dummy Photo",
//        contentScale = ContentScale.Crop,
//        colorFilter = ColorFilter.tint(Color.Black),
//        modifier = Modifier
//            .size(80.dp)
//            .padding(20.dp)
//            .clip(CircleShape)
//            .border(2.dp, Color.Gray, CircleShape)
//    )
//
//}

enum class Pages {
    LISTING, DETAIL
}