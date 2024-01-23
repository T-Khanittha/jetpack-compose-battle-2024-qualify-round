package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify2Screen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
    ) {

        val (tuTo, buttonNext) = createRefs()
        Tutorial(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .constrainAs(tuTo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Button(
            onClick = {},
            modifier = Modifier
                .height(40.dp)
                .width(251.dp)
                .constrainAs(buttonNext) {
                    bottom.linkTo(parent.bottom, margin = 31.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun Tutorial(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (skipButton, tutorialContent) = createRefs()
        SkipButton(modifier = Modifier
            .width(59.dp)
            .height(40.dp)
            .constrainAs(skipButton) {
                top.linkTo(anchor = parent.top, margin = 8.dp)
                end.linkTo(anchor = parent.end, margin = 8.dp)
            }, onClick = { })
        Column(
            modifier = Modifier
                .width(347.dp)
                .constrainAs(tutorialContent) {
                    top.linkTo(parent.top, margin = 64.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
                letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing,
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),

                painter = painterResource(id = R.drawable.img_qualify_2_onboard),
                contentDescription = "", contentScale = ContentScale.Fit
            )
            Row(
                modifier = Modifier.padding(bottom = 48.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(3) {
                    Dot()
                }
                RectangleCustom()
                Dot()
            }
        }
    }
}


@Composable
fun SkipButton(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    TextButton(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
    ) {
        Text(
            text = "Skip",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}


@Composable
fun Dot() {
    Box(
        modifier = Modifier
            .width(16.dp)
            .height(16.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
    )
}

@Composable
fun RectangleCustom() {
    Box(
        modifier = Modifier
            .width(32.dp)
            .height(16.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(16.dp)
            )
    )
}


// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion