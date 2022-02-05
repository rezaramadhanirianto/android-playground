package com.example.experimental.singleActivity.modules.list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.experimental.R
import com.example.experimental.singleActivity.data.common.models.Movie
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ItemMovie(movie: Movie) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
//        Image(
//            painterResource(id = R.drawable.ic_launcher_background),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(55.dp)
//                .padding(4.dp)
//        )
        GlideImage(
            imageModel = movie.posterPath,
            modifier = Modifier.size(55.dp)
                .padding(4.dp),
            loading = {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val indicator = createRef()
                    CircularProgressIndicator(
                        modifier = Modifier.constrainAs(indicator) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                    )
                }
            },
            // shows an error text message when request failed.
            failure = {
                Text(text = "image request failed.")
            })
        Column(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .weight(1F)
        ) {
            Text(
                text = movie.title,
                style = typography.h6.copy(fontSize = 16.sp),
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = "${movie.description}, ${movie.overview}",
                style = typography.subtitle2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        if (movie.id % 3 == 0L) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .padding(4.dp)
                    .size(20.dp)
            )
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
@Preview
fun PreviewItemMovie() {
    val movie = Movie(100, "https://png.pngtree.com/thumb_back/fh260/background/20200714/pngtree-modern-double-color-futuristic-neon-background-image_351866.jpg", 100, "Light Saber", "asdf", 100.0, "asdfadsf")
    ItemMovie(movie = movie)
}