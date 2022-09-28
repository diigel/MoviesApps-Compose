package com.digel.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
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
                    constraintSet = decoupledConstraints(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Movie Apps",
                        modifier = Modifier.layoutId("text"),
                        fontSize = 24.sp
                    )
                    ListName("itemList")
                }
            }
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val itemList = createRefFor("itemList")
        val text = createRefFor("text")

        constrain(text) {
            top.linkTo(parent.top, margin)
            start.linkTo(parent.start, margin)
        }
        constrain(itemList) {
            top.linkTo(text.bottom, margin)
            start.linkTo(text.start)
        }
    }
}

@Composable
fun ListName(layoutId: String) {
    LazyColumn(modifier = Modifier.layoutId(layoutId)) {
        itemsIndexed(
            listOf("digel", "indah")
        ) { index, item ->
            Text(text = "${index + 1} Name is $item", fontSize = 12.sp)
        }
    }
}
