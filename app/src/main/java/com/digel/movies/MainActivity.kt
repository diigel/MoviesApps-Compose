package com.digel.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.digel.movies.ui.theme.MoviesAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppsTheme {
                ConstraintLayout(
                    constraintSet = decoupledConstraints(),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Movies Apps",
                        modifier = Modifier
                            .layoutId("text")
                            .fillMaxWidth()
                            .background(Color.Blue)
                            .padding(8.dp),
                        fontSize = 24.sp,
                        color = Color.White
                    )
                    ListName("itemList")
                }
            }
        }
    }
}

private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val itemList = createRefFor("itemList")
        val text = createRefFor("text")

        constrain(text) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }
        constrain(itemList) {
            top.linkTo(text.bottom)
            start.linkTo(text.start)
        }
    }
}

@Composable
fun ListName(layoutId: String) {
    Card(
        modifier = Modifier.fillMaxWidth().layoutId(layoutId).padding(8.dp),
        elevation = 8.dp,
        border = BorderStroke(1.dp, Color.Gray),
        backgroundColor = Color.White
    ) {
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            itemsIndexed(
                listOf("digel", "indah")
            ) { index, item ->

                Text(text = "${index + 1} Name is $item", fontSize = 12.sp)
            }
        }
    }
}
