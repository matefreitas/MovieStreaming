package com.example.moviestreaming.presenter.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.moviestreaming.R
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import com.example.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: Painter,
    isLoading: Boolean = false,
    onclick: () -> Unit
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("button_loading.json"))

    Button(
        onClick = onclick,
        modifier = modifier
            .height(58.dp)
            .border(
                width = 1.dp,
                color = MovieStreamingTheme.colorScheme.borderColor,
                shape = RoundedCornerShape(16.dp)
            ),
        enabled = !isLoading,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MovieStreamingTheme.colorScheme.backgroundSocialButtonColor
        ),
        content = {
            if (isLoading) {
                LottieAnimation(
                    composition = composition,
                    modifier = Modifier
                        .size(70.dp),
                    iterations = LottieConstants.IterateForever,
                    maintainOriginalImageBounds = true,
                    contentScale = ContentScale.Crop
                )
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = icon,
                        modifier = Modifier.size(24.dp),
                        contentDescription = text
                    )

                    text?.let{
                        Spacer(modifier = Modifier.size(16.dp))
                        Text(
                            text = text,
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 22.4.sp,
                                fontFamily = UrbanistFamily,
                                fontWeight = FontWeight.Bold,
                                color = MovieStreamingTheme.colorScheme.textColor,
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.2.sp
                            )
                        )
                    }

                }
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun SocialButtonPreview() {
    MovieStreamingTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MovieStreamingTheme.colorScheme.backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            SocialButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Sign in with Google",
                icon = painterResource(id = R.drawable.ic_google),
                onclick = {}
            )
            SocialButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Sign in with Facebook",
                icon = painterResource(id = R.drawable.ic_facebook),
                onclick = {}
            )
            SocialButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Sign in with Github",
                icon = painterResource(id = R.drawable.ic_github),
                onclick = {}
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SocialButton(
                    icon = painterResource(id = R.drawable.ic_google),
                    onclick = {}
                )
                SocialButton(
                    icon = painterResource(id = R.drawable.ic_facebook),
                    onclick = {}
                )
                SocialButton(
                    icon = painterResource(id = R.drawable.ic_github),
                    onclick = {}
                )
            }
        }
    }
}