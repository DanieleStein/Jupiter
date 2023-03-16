package br.com.jupiter.android.nav

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.jupiter.android.content.ContentScreen
import br.com.jupiter.android.courses.CourseScreen
import br.com.jupiter.android.courses.CourseScreen2
import br.com.jupiter.android.login.LoginScreen
import br.com.jupiter.android.model.DetailScreen
import br.com.jupiter.android.orders.OrderScreen
import br.com.jupiter.android.profile.ProfileScreen
import br.com.jupiter.android.recoverPassword.RecoverPasswordScreen
import br.com.jupiter.android.registerPayment.RegisterPaymentScreen
import br.com.jupiter.android.registerUser1.RegisterUserScreen
import br.com.jupiter.model.Conteudo
import br.com.jupiter.model.Curso
import br.com.jupiter.util.DataResult


enum class Route {
    CONTENT, LOGIN, COURSES, CREATE, PAYMENT, ORDER, COURSES_DETAIL, RECOVERY, PROFILE, VIDEO
}

@Composable
fun Navigator(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    initial: Route = Route.LOGIN
) {
    val cursos = remember { mutableStateOf(emptyList<Curso>()) }
    val conteudos = remember { mutableStateOf(emptyList<Conteudo>()) }

    NavHost(
        navController = navHostController,
        startDestination = initial.name
    ) {

        composable(Route.LOGIN.name) {
            LoginScreen(
                onHomeNavigate = { navHostController.navigate(Route.COURSES.name) },
                onCreateNavigate = { navHostController.navigate(Route.CREATE.name) }
            ) { navHostController.navigate(Route.RECOVERY.name) }

        }

        composable(Route.COURSES.name) {
            CourseScreen(
                onCategoryDetail = { navHostController.navigate("${Route.COURSES_DETAIL}/$it") },
                navHostController = navHostController,
                onCursos = { dr ->
                    cursos.value = (dr as DataResult.Success<List<Curso>>).data
                }
            )
        }

        composable("${Route.COURSES_DETAIL}/{categoria}") {
            val categoria = it.arguments?.getString("categoria")
            CourseScreen2(
                categoria = categoria ?: "",
                navHostController = navHostController,
                cursos = cursos.value
            )
        }

        composable("${Route.CONTENT}/{conteudo}") {
            val conteudo = it.arguments?.getString("conteudo")?.toLong()
            if (conteudo != null) {
                ContentScreen(
                    navHostController = navHostController,
                    id = conteudo
                )
            }
        }

        composable("${Route.VIDEO}/{ordemConteudo}"){
            val ordemConteudo = it.arguments?.getString("ordemConteudo")?.toInt()

            DetailScreen(
                navHostController = navHostController,
                ordemConteudo = ordemConteudo ?: 1
            )

        }

        composable(Route.RECOVERY.name) {
            RecoverPasswordScreen(navHostController = navHostController)
        }

        composable(Route.PROFILE.name) {
            ProfileScreen(navHostController = navHostController)
        }

        composable(Route.CREATE.name) {
            RegisterUserScreen(
                onNextButtonClicked = {
                    navHostController.navigate(Route.PAYMENT.name)
                }, navHostController = navHostController

            )
        }

        composable(Route.PAYMENT.name) {
            RegisterPaymentScreen(
                onNextButtonClicked = {
                    navHostController.navigate(Route.ORDER.name)
                }, navHostController = navHostController
            )
        }

        composable(Route.ORDER.name) {
            OrderScreen(
                onNextButtonClicked = {}, navHostController = navHostController
            )
        }



    }

}



