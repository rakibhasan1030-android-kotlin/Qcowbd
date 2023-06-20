package rakib.hasan.qcowbd.presentation.home.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import rakib.hasan.qcowbd.domain.model.HomeProduct

@Composable
fun HomeProductItem(
    product: HomeProduct,
    onItemClick: (HomeProduct) -> Unit
) {
    Row(
        modifier = Modifier.run {
            fillMaxWidth()
                .clickable { onItemClick(product) }
                .padding(20.dp)
        },
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "${product.title})",
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${product.image})",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(CenterVertically)
        )
    }
}
