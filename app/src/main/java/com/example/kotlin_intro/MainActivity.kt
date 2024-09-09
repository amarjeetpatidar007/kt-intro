package com.example.kotlin_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_intro.ui.theme.kotlin_introTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            kotlin_introTheme {
                // A surface container using the 'background' color from the theme
                Portfo()
            }
        }
    }
}



@Composable
fun Portfo() {
    val state = remember{
        mutableStateOf(false)
    }

    Surface(
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Amarjeet Patidar",
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(12.dp))


            Text(text = "Android Developer", style = MaterialTheme.typography.caption)

            Row {
                Image(
                    painter = painterResource(id = R.drawable.github), contentDescription = "",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "/amarjeetpatidar007",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

            }
            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {
                state.value = !state.value
            }) {
                Text(text = "My Projects")
            }

           if(state.value){
               LazyColumn{
                   items(getProList()){
                       ProjectItem(project = it)
                   }
               }
           }
        }
    }
}

@Composable
fun ProjectItem(project: Project){
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.profile), contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.h6)
            Text(text = project.desc, style = MaterialTheme.typography.caption)
        }

    }
}

fun getProList(): List<Project>{
    return listOf(
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        Project("Test","testing pro desc"),
        )
}

data class Project(
    val name: String,
    val desc: String
)




