package br.com.jupiter.android.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.components.CardCourse
import br.com.jupiter.android.components.CardCourseGroup
import br.com.jupiter.android.content.ContentScreen
import br.com.jupiter.android.courses.CourseScreen
import br.com.jupiter.android.courses.CourseScreen2
import br.com.jupiter.android.login.LoginScreen
import br.com.jupiter.android.orders.OrderScreen
import br.com.jupiter.android.registerPayment.RegisterPaymentScreen
import br.com.jupiter.android.registerUser1.RegisterUserScreen
import br.com.jupiter.model.Categorias


enum class Route {
    CONTENT, LOGIN, COURSES, CREATE, PAYMENT, ORDER, COURSES_DETAIL, CARD, CARD_GROUP
}

@Composable
fun Navigator(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    initial: Route = Route.COURSES
) {


    NavHost(
        navController = navHostController,
        startDestination = initial.name
    ) {

        composable(Route.LOGIN.name) {
            LoginScreen(
                onHomeNavigate = { navHostController.navigate(Route.COURSES.name) },
                onCreateNavigate = { navHostController.navigate(Route.CREATE.name) }
            )

        }

        composable(Route.COURSES.name) {
            CourseScreen(
                onCategoryDetail = { navHostController.navigate("${Route.COURSES_DETAIL}/$it") },
                navHostController = navHostController
            )
        }

        composable("${Route.COURSES_DETAIL}/{categoria}") {
            val categoria = it.arguments?.getString("categoria")
            CourseScreen2(categoria ?: "", navHostController = navHostController)
        }


        composable(Route.CARD.name) {
            CardCourse(
                curso = Mock.curso1,
                navHostController = navHostController,
                onCardNavigation = { id ->
                    println("Entrei com id: ${id}")
                    navHostController.navigate("${Route.CONTENT}/$id")
                })
        }


        composable("${Route.CONTENT}/{conteudo}") {
            val conteudo = it.arguments?.getString("conteudo")
            println(conteudo)
            ContentScreen(id = 1, onBack = { })
        }

        /*composable(Route.CONTENT.name) {
            ContentScreen(id = 1, onBack = { })
        }*/


        composable(Route.CREATE.name) {
            RegisterUserScreen(
                onNextButtonClicked = {
                    navHostController.navigate(Route.PAYMENT.name)
                }
            )
        }

        composable(Route.PAYMENT.name) {
            RegisterPaymentScreen(
                onNextButtonClicked = {
                    navHostController.navigate(Route.ORDER.name)
                }
            )
        }

        composable(Route.ORDER.name) {
            OrderScreen(
                onNextButtonClicked = {
                    navHostController.navigate(Route.COURSES.name)
                }
            )
        }

        cardsToGroup(navHostController)

    }


}


fun NavGraphBuilder.cardsToGroup(navController: NavController) {
    navigation(Route.CONTENT.name, route = Route.CARD.name) {

        composable(route = Route.CONTENT.name) {
            ContentScreen(onBack = {
                println("")
            }, id = 0)
        }

        /*composable("${Route.COURSES.name}/${Route.CARD_GROUP.name}") {
    CardCourseGroup(categoria = Categorias.FII.name, onCard = {
        println(it)
    }, navHostController = navHostController)
}*/


    }
}

