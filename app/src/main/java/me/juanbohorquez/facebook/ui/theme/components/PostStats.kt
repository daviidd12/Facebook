package me.juanbohorquez.facebook.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostStats(
    modifier: Modifier = Modifier,
    likesCount: Int = 124,
    commentsCount: Int = 18,
    sharesCount: Int = 5
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Sección izquierda: Círculo azul con ícono de pulgar y contador de likes
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .background(color = Color(0xFF1877F2), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = "Me gusta",
                    tint = Color.White,
                    modifier = Modifier.size(10.dp)
                )
            }

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "$likesCount",
                fontSize = 13.sp,
                color = Color(0xFF606770)
            )
        }

        // Sección derecha: Comentarios y compartidos
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (commentsCount > 0) {
                Text(
                    text = "$commentsCount comentarios",
                    fontSize = 13.sp,
                    color = Color(0xFF606770)
                )
            }

            if (commentsCount > 0 && sharesCount > 0) {
                Text(
                    text = " • ",
                    fontSize = 13.sp,
                    color = Color(0xFF606770)
                )
            }

            if (sharesCount > 0) {
                Text(
                    text = "$sharesCount compartidos",
                    fontSize = 13.sp,
                    color = Color(0xFF606770)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostStatsPreview() {
    PostStats()
}
