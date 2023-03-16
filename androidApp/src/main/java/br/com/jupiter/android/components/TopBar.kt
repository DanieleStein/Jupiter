package br.com.jupiter.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.jupiter.android.R
import br.com.jupiter.android.nav.Route

@Composable
fun TopBar(title: String, navHostController: NavHostController?) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { navHostController?.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, "backIcon", tint = Color.White)
            }
        },
        backgroundColor = Color(0xFF0051EF)
    )
}

@Composable
fun TopBarPerfil(title: String, navHostController: NavHostController?) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { navHostController?.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, "backIcon", tint = Color.White)
            }
        },

        actions = {

            IconButton(onClick = {
                navHostController?.navigate(Route.PROFILE.name)
            }) {
                Image(
                    painter = painterResource(R.drawable.ic_profile2),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(40.dp)
                        .clip(CircleShape)
                )
            }

        },
        backgroundColor = Color(0xFF0051EF)
    )
}

@Composable
fun TopBarPerfilMain(title: String, navHostController: NavHostController?) {

    val showExitDialog = remember { mutableStateOf(false) }

    if (showExitDialog.value) {
        ExitDialog(
            onDismiss = { showExitDialog.value = !showExitDialog.value },
            onExit = { navHostController?.popBackStack() }
        )
    }



    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { showExitDialog.value = !showExitDialog.value }) {
                Icon(Icons.Filled.ArrowBack, "backIcon", tint = Color.White)
            }
        },

        actions = {

            IconButton(onClick = {
                navHostController?.navigate(Route.PROFILE.name)
            }) {
                Image(
                    painter = painterResource(R.drawable.ic_profile2),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(40.dp)
                        .clip(CircleShape)
                )
            }

        },
        backgroundColor = Color(0xFF0051EF)
    )
}




@Composable
fun TopBarCourse(
    titulo: String,
    navHostController: NavHostController?,
    onSearchClick: (Boolean) -> Unit
) {

    //val showSearch = remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = titulo,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { navHostController?.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, "backIcon", tint = Color.White)
            }
        },

        actions = {
            IconButton(onClick = {
                /*onSearchClick.invoke(showSearch.value)
                println("TOPBAR: $showSearch")
                showSearch.value = !showSearch.value*/
            }) {
                Image(
                    painter = painterResource(R.drawable.baseline_search_24),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(40.dp)
                        .clip(CircleShape)
                )
            }

            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.ic_profile2),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(40.dp)
                        .clip(CircleShape)
                )
            }

        },
        backgroundColor = Color(0xFF0051EF)
    )
}


@Composable
fun TopBarPerfilOnly(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.White
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.ic_profile2),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(40.dp)
                        .clip(CircleShape)
                )
            }
        },

        backgroundColor = Color(0xFF0051EF)
    )
}

@Composable
fun TopBarProfile(title: String, navHostController: NavHostController?) {
  TopAppBar(
    title = {
      Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        color = Color.White
      )
    },
    navigationIcon = {
      IconButton(onClick = { navHostController?.popBackStack() }) {
        Icon(Icons.Filled.ArrowBack, "backIcon", tint = Color.White)
      }
    },
    backgroundColor = Color(0xFF0051EF)
  )
}


@Preview
@Composable
fun TopBar1Preview() {
    TopBar(title = "JUPITER", navHostController = null)
}

@Preview
@Composable
fun TopBarPerfilOnlyPreview() {
    TopBarPerfilOnly(title = "JUPITER")
}

@Preview
@Composable
fun TopBarPerfilPreview() {
    TopBarPerfil(title = "JUPITER", navHostController = null)
}

@Preview
@Composable
fun TopBarCoursePreview() {
    TopBarCourse(titulo = "JUPITER", navHostController = null) {

    }
}

@Preview
@Composable
fun TopBarProfilePreview() {
  TopBarProfile(title = "JUPITER", navHostController = null)
}
