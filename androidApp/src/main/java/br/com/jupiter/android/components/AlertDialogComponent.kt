package br.com.jupiter.android.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AlertDialogComponent(
    openDialog: Boolean,
    title: String,
    message: String,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    if (openDialog) {
        AlertDialog(
            modifier = modifier,
            title = { Text(text = title, color = Color.White) },
            text = { Text(text = message, color = Color.White) },
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(
                    onClick = onDismissRequest
                ) {
                    Text(text = "OK", color = Color.White)
                }
            },
            backgroundColor = Color(0xFF0051EF),
            contentColor = Color.White
        )
    }
}

@Preview
@Composable
fun AlertDialogComponent_Preview() {
    AlertDialogComponent(true, title = "Teste", message = "Teste", {})
}