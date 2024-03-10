package com.example.netflix_ui_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflix_ui_clone.ui.theme.Netflix_UI_CloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val popularOnNetflix = mutableListOf<MovieItemModel>()
        popularOnNetflix.add(MovieItemModel(R.drawable.movie_1))
        popularOnNetflix.add(MovieItemModel(R.drawable.movie_2))
        popularOnNetflix.add(MovieItemModel(R.drawable.movie_3))
        popularOnNetflix.add(MovieItemModel(R.drawable.movie_5))
        popularOnNetflix.add(MovieItemModel(R.drawable.movie_6))
        popularOnNetflix.add(MovieItemModel(R.drawable.movie_7))

        val awardWinningTVShow = mutableListOf<MovieItemModel>()
        awardWinningTVShow.add(MovieItemModel(R.drawable.movie_8))
        awardWinningTVShow.add(MovieItemModel(R.drawable.movie_9))
        awardWinningTVShow.add(MovieItemModel(R.drawable.movie_10))
        awardWinningTVShow.add(MovieItemModel(R.drawable.movie_12))
        awardWinningTVShow.add(MovieItemModel(R.drawable.movie_13))
        awardWinningTVShow.add(MovieItemModel(R.drawable.movie_14))


        val onlyOnNetflix = mutableListOf<MovieItemModel>()
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_2))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_3))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_4))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_7))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_8))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_9))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_10))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_12))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_13))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_14))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_15))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_16))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_17))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_18))
        onlyOnNetflix.add(MovieItemModel(R.drawable.movie_long_19))

        val topSearches = mutableListOf<MovieItemModel>()
        topSearches.add(MovieItemModel(R.drawable.movie_15))
        topSearches.add(MovieItemModel(R.drawable.movie_16))
        topSearches.add(MovieItemModel(R.drawable.movie_17))
        topSearches.add(MovieItemModel(R.drawable.movie_18))
        topSearches.add(MovieItemModel(R.drawable.movie_19))
        topSearches.add(MovieItemModel(R.drawable.movie_7))

        val casualViewing = mutableListOf<MovieItemModel>()
        casualViewing.add(MovieItemModel(R.drawable.movie_6))
        casualViewing.add(MovieItemModel(R.drawable.movie_1))
        casualViewing.add(MovieItemModel(R.drawable.movie_8))
        casualViewing.add(MovieItemModel(R.drawable.movie_3))
        casualViewing.add(MovieItemModel(R.drawable.movie_5))
        casualViewing.add(MovieItemModel(R.drawable.movie_2))


        setContent {
            Netflix_UI_CloneTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black)
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 20.dp)
                ) {
                    topAppSection()
                    netflixContentChooser()
                    featuredMovieSection()
                    addSmallShowList("Popular on Netflix", popularOnNetflix)
                    addSmallShowList("Award_Winning TV Shows", awardWinningTVShow)
                    addSmallShowList("Only on Netflix", onlyOnNetflix, true)
                    addSmallShowList(showType = "Top Searches", showList = topSearches)
                    addSmallShowList(showType = "Casual Viewing", showList = casualViewing)
                }
            }
        }
    }

    @Composable
    fun topAppSection() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(top = 8.dp, start = 10.dp, end = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.netflix_logo),
                contentDescription = "Netflix Logo",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Netflix Logo",
                    modifier = Modifier
                        .width(50.dp)
                        .height(40.dp)
                        .padding(end = 20.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = "Netflix Logo",
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp),

                    )
            }

        }
    }

    @Composable
    fun netflixContentChooser() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "TV Shows", color = Color.LightGray, fontSize = 20.sp)
            Text(text = "Movies", color = Color.LightGray, fontSize = 20.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Categories", color = Color.LightGray, fontSize = 20.sp)
                Image(
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    contentDescription = "Category Dropdown"
                )
            }
        }
    }

    @Composable
    fun featuredMovieSection() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(top = 40.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.movie_long_7),
                contentDescription = "Featured Movie Image",
                modifier = Modifier.size(360.dp),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 80.dp, end = 80.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "British", color = Color.White)
                Text(
                    text = ".",
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 24.sp
                )
                Text(text = "Thriller", color = Color.White)
                Text(
                    text = ".",
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 24.sp
                )
                Text(text = "Crime", color = Color.White)
                Text(
                    text = ".",
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 24.sp
                )
                Text(text = "Drama", color = Color.White)
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 70.dp, end = 70.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(60.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add List"
                    )
                    Text(text = "My List", color = Color.White)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Play", color = Color.Black, fontSize = 18.sp)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(60.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = "Add List"
                    )
                    Text(text = "Info", color = Color.White)
                }
            }
        }
    }

    @Composable
    fun addSmallShowList(
        showType: String,
        showList: MutableList<MovieItemModel>,
        isLargeImage: Boolean = false
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, bottom = 4.dp, top = 12.dp)
                .background(color = Color.Black)
        ) {

            Text(
                text = showType,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            LazyRow {
                itemsIndexed(showList) { index, item ->
                    movieItemUIModel(imageRes = item.image, isLargeImage)
                }
            }
        }
    }

    @Composable
    fun movieItemUIModel(imageRes: Int, isLargeImage: Boolean = false) {
        if (isLargeImage) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Show's Image",
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(170.dp)
                    .height(340.dp)
                    .clip(RoundedCornerShape(6.dp)),
                contentScale = ContentScale.FillBounds
            )
        } else {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Show's Image",
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .clip(RoundedCornerShape(6.dp)),
            )
        }
    }

    data class MovieItemModel(
        val image: Int
    )
}

