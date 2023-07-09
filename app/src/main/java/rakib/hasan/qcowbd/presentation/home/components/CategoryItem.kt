package rakib.hasan.qcowbd.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import rakib.hasan.qcowbd.common.Constants
import rakib.hasan.qcowbd.domain.model.Category

@Composable
fun CategoryItem(
    category: Category,
    onItemClick: (Category) -> Unit,
) {
    Column(
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .clip(shape = CircleShape)
            .background(color = Color.Gray.copy(0.5F)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(Constants.CATEGORIES_PATH + category.image),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f),
        )
        Text(
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterHorizontally)
                .weight(0.3f),
            text = category.title,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
        )
    }

}