package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify1Screen() {
    Column(modifier = Modifier.fillMaxSize()) {
        MyTopAppBar()
        ProfileCard()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = { },
        navigationIcon = {
            Image(painter = painterResource(id = R.drawable.ic_qualify_1_menu),
                contentDescription = "menu",
                modifier = Modifier.clickable { })

        },
        actions = {
            Image(painter = painterResource(id = R.drawable.ic_qualify_1_profile),
                contentDescription = "profile",
                modifier = Modifier.clickable { })
        },
    )
}

@Composable
fun ProfileCard() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 16.dp, 16.dp, 72.dp)
    ) {
        val (profileCard, thumbContainer) = createRefs()
        ConstraintLayout(
            modifier = Modifier
                .constrainAs(profileCard) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clip(RoundedCornerShape(16.dp))
        ) {
            val (profileImage, profileDetail) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.img_qualify_1_profile),
                contentDescription = "profile image",
                modifier = Modifier
                    .constrainAs(profileImage) {
                        top.linkTo(profileCard.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
            )
            Column(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.75f))
                    .height(192.dp)
                    .padding(20.dp)
                    .constrainAs(profileDetail) {
                        bottom.linkTo(profileImage.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                verticalArrangement = Arrangement.Top,
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "John Doe",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing
                )
                Row(modifier = Modifier.height(20.dp)) {
                    Icon(
                        modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_qualify_1_gender_male),
                        contentDescription = "gender male",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Male",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp, end = 19.dp)
                        .height(60.dp),
                    text = "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing
                )
            }
        }
        Row(
            modifier = Modifier.constrainAs(thumbContainer) {
                top.linkTo(profileCard.bottom)
                bottom.linkTo(profileCard.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            horizontalArrangement = Arrangement.spacedBy(43.dp)
        ) {
            ThumbDownButton {}
            ThumbUpButton {}
        }
    }
}

@Composable
fun ThumbDownButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.errorContainer)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_qualify_1_thumb_down),
            contentDescription = "thumb down"
        )
    }
}

@Composable
fun ThumbUpButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_qualify_1_thumb_up),
            contentDescription = "thumb down"
        )
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion