package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify3Screen() {
    Column(modifier = Modifier.fillMaxSize()) {
        MyTopAppBar()
        ImageCollection()
        Chips()
        SenderCardCollection()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "John Doe",
                style = MaterialTheme.typography.titleLarge,
                letterSpacing = 0.3.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        navigationIcon = {
            Image(painter = painterResource(id = R.drawable.ic_qualify_3_back),
                contentDescription = "menu",
                modifier = Modifier.clickable { })

        },
        actions = {
            Image(painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                contentDescription = "profile",
                modifier = Modifier.clickable { })
            Image(painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                contentDescription = "profile",
                modifier = Modifier.clickable { })
            Image(painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                contentDescription = "profile",
                modifier = Modifier.clickable { })
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        )
    )
}

private val listImage: List<Int> = listOf(
    R.drawable.img_qualify_3_photo_1,
    R.drawable.img_qualify_3_photo_2,
    R.drawable.img_qualify_3_photo_3
)

@Composable
fun ImageCollection(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listImage) { item ->
            ImageItem(item)
        }
    }
}

@Composable
private fun ImageItem(item: Int) {
    val borderColor = if (item == listImage[0]) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.primaryContainer
    }
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(320.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.background)
            .border(
                2.dp,
                borderColor,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp)),
            painter = painterResource(item), contentDescription = ""
        )
    }
}

@Composable
fun Chips() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(4) {
            val styleColor = if (it == 0) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outline
            }
            SuggestionChip(
                modifier = Modifier
                    .width(68.dp)
                    .height(32.dp),
                onClick = { },
                label = {
                    Text(
                        text = "Tag ${it + 1}",
                        style = MaterialTheme.typography.labelLarge,
                        color = styleColor,
                        letterSpacing = MaterialTheme.typography.bodySmall.letterSpacing
                    )
                },
                border = SuggestionChipDefaults.suggestionChipBorder(borderColor = styleColor)
            )
        }
    }

}

@Composable
fun SenderCardItem(message: String) {
    Box {
        Row(
            modifier = Modifier
                .height(96.dp)
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_qualify_3_sender),
                contentDescription = "sender",
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = "Lorem Ipsum",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                    letterSpacing = MaterialTheme.typography.bodySmall.letterSpacing
                )
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    letterSpacing = MaterialTheme.typography.labelMedium.letterSpacing
                )
            }
        }
    }
}

private val messages = listOf(
    "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
    "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
    "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
    "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget."
)

@Composable
fun SenderCardCollection() {
    LazyColumn(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(messages) {
            SenderCardItem(message = it)
        }
    }
}

@Composable
@Preview
fun CustomImageCollectionPreview() = AppTheme {
    ImageCollection(modifier = Modifier.background(MaterialTheme.colorScheme.background))
}

@Composable
@Preview
fun ChipsPreview() = AppTheme {
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Chips()
    }
}

@Composable
@Preview
fun SenderCardsPreview() = AppTheme {
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        SenderCardItem("Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.")
    }
}

@Composable
@Preview
fun SenderCardCollectionPreview() = AppTheme {
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        SenderCardCollection()
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion