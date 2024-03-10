package com.example.jetpackcomposerecylerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposerecylerview.ui.theme.JetpackComposeRecylerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeRecylerViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val listOfCourse = mutableListOf<CourseModel>()
    listOfCourse.add(CourseModel(R.drawable.java, "Java", "Java for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.python, "Python", "Python for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.android, "Android", "Android for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.js, "JavaScript", "JavaScript for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.c_plus_plus, "C++", "C++ for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.angular, "Angular", "Angular for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.react, "React", "React for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.java, "Java", "Java for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.python, "Python", "Python for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.android, "Android", "Android for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.js, "JavaScript", "JavaScript for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.c_plus_plus, "C++", "C++ for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.angular, "Angular", "Angular for absolute beginners"))
    listOfCourse.add(CourseModel(R.drawable.react, "React", "React for absolute beginners"))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            itemsIndexed(listOfCourse) { index, item ->
                CourseModelUI(
                    courseName = item.courseName,
                    courseDescription = item.courseDescription,
                    courseImage = item.courseImage
                )
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(listOfCourse) { index, item ->
                CourseModelUI(
                    courseName = item.courseName,
                    courseDescription = item.courseDescription,
                    courseImage = item.courseImage
                )
            }
        }
    }
}

@Composable
fun CourseModelUI(
    courseImage: Int,
    courseName: String,
    courseDescription: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp),
    ) {
        Image(
            painter = painterResource(id = courseImage),
            contentDescription = "Course Thumbnail",
            modifier = Modifier
                .width(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .height(60.dp)
                .background(color = Color.Black)
                .padding(6.dp)
        )

        Column(modifier = Modifier.padding(start = 5.dp)) {
            Text(
                text = courseName,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = courseDescription,
                color = Color.Gray,
            )
        }
    }

}

data class CourseModel(
    val courseImage: Int,
    val courseName: String,
    val courseDescription: String
)
