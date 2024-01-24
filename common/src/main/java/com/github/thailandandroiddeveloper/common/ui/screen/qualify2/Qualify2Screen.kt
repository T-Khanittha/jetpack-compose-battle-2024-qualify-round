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
import androidx.compose.ui.graphics.RectangleShape
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
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (contentContainer, buttonNext, skipButton, customIndicator, img) = createRefs()
        SkipButton(
            modifier = Modifier
                .width(59.dp)
                .height(40.dp)
                .constrainAs(skipButton) {
                    top.linkTo(parent.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                }
        )
        Box(modifier = Modifier
            .constrainAs(contentContainer) {
                top.linkTo(parent.top, margin = 64.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            ContentText()
        }
        Image(
            modifier = Modifier
                .width(347.dp)
                .height(446.dp)
                .constrainAs(img) {
                    top.linkTo(contentContainer.bottom)
                    bottom.linkTo(customIndicator.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.img_qualify_2_onboard),
            contentDescription = "", contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(customIndicator) {
                    bottom.linkTo(buttonNext.top, margin = 48.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.Center
        ) {
            CustomIndicator()
        }
        NextButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(102.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .constrainAs(buttonNext) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )
    }
}

@Composable
fun SkipButton(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    TextButton(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        shape = RectangleShape
    ) {
        Text(
            text = "Skip",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun ContentText() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Lorem ipsum dolor sit amet",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 32.dp),
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing,
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

@Composable
fun NextButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .height(40.dp)
                .width(251.dp)

        ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun CustomIndicator() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(3) {
            Dot()
        }
        RectangleCustom()
        Dot()
    }
}

@Composable
@Preview
fun SkipButtonPreview() = AppTheme {
    SkipButton(
        modifier = Modifier
            .width(59.dp)
            .height(40.dp)
    )
}

@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun ContentTextPreview() = AppTheme {
    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        ContentText()
    }
}

@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun NextButtonPreview() = AppTheme {
    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        NextButton()
    }
}

@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun CustomIndicatorPreview() = AppTheme {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        CustomIndicator()
    }
}

@Composable
fun Qualify22Screen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (contentContainer, buttonNext, skipButton, customIndicator, img) = createRefs()
        SkipButton(
            modifier = Modifier
                .width(59.dp)
                .height(40.dp)
                .constrainAs(skipButton) {
                    top.linkTo(parent.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                }
        )
        Box(modifier = Modifier
            .constrainAs(contentContainer) {
                top.linkTo(parent.top, margin = 64.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            ContentText()
        }
        Image(
            modifier = Modifier
                .width(347.dp)
                .constrainAs(img) {
                    top.linkTo(contentContainer.bottom)
                    bottom.linkTo(customIndicator.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.img_qualify_2_onboard),
            contentDescription = "", contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(customIndicator) {
                    bottom.linkTo(buttonNext.top, margin = 48.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.Center
        ) {
            CustomIndicator()
        }
        NextButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(102.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .constrainAs(buttonNext) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )
    }
}


// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion