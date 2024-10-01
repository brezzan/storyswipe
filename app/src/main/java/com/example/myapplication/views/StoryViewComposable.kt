package com.example.myapplication.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.models.storyData
import com.example.myapplication.viewmodel.StoryViewModel
import kotlin.math.max

@Composable
fun StoryViewComposable(
    modifier: Modifier,
    viewModel: StoryViewModel
){
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val imageModifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { offset ->
                        if (offset.x < constraints.maxWidth / 2) {
                            if (viewModel.index.value > 0) {
                                viewModel.leftSwipe()
                            }
                        } else {
                            if (viewModel.index.value < viewModel.listSize.value - 1) {
                                viewModel.rightSwipe()
                            }
                        }
                        viewModel.isPaused.value = false
                    },
                    onPress = {
                        try {
                            viewModel.isPaused.value = true
                            awaitRelease()
                        } finally {
                            viewModel.isPaused.value = false
                        }
                    }
                )
            }
        Image(
            painter = painterResource(id = storyData.storyList[viewModel.index.collectAsState().value].picture  ),
            contentDescription = "StoryImage",
            contentScale = ContentScale.FillHeight,
            modifier = imageModifier

        )

        Text(
                text = storyData.storyList[viewModel.index.collectAsState().value].description,
                modifier = Modifier
                    .align(Alignment.Center) // Align the text at the center of the Box
                    .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent background
                    .padding(16.dp), // Add some padding to the text
            color = Color.White, // Make the text color white
            fontSize = 24.sp // Set the font size
        )
    }
}

