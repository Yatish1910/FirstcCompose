package com.example.firstccompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstccompose.R

@Preview
@Composable
fun PreviewList(){
    LazyColumn(content = {
        items(getCategoryList()) {item->
            RenderList(image = item.image, title = item.title, subTitle = item.subTitle)
        }
    })
}



@Composable
private fun RenderList(image:Int, title: String, subTitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, CircleShape)

            )
            Column(modifier = Modifier.weight(.100f)) {
                Text(text = title,
                    fontWeight = FontWeight.Bold)
                Text(text = subTitle,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp)
            }
        }
    }
}
data class Category(
    val image: Int,
    val title: String,
    val subTitle: String
)
fun getCategoryList(): MutableList<Category>{
    val list = mutableListOf<Category>()
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    list.add(Category(image = R.drawable.ic_launcher_foreground, title = "Programing", subTitle = "C++, Kotlin"))
    return list
}