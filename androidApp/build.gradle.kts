plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "br.com.jupiter.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "br.com.jupiter.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
  val navVersion = "2.5.3"
  val iconsVersion = "1.3.1"
  implementation(project(":shared"))
  implementation("androidx.compose.ui:ui:1.2.1")
  implementation("androidx.compose.ui:ui-util:1.3.3")
  implementation("androidx.compose.ui:ui-tooling:1.2.1")
  implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
  implementation("androidx.compose.foundation:foundation:1.2.1")
  implementation("androidx.compose.material:material:1.2.1")
  implementation("androidx.activity:activity-compose:1.5.1")
  implementation("androidx.compose.material:material-icons-extended:$iconsVersion")//Dependencia de icones para a nossa tela de login
  implementation("androidx.navigation:navigation-compose:$navVersion") //Variável com o número da versão lá em cima, aqui podemos só chamar ela
  implementation("androidx.compose.material3:material3:1.0.1")
  implementation("com.google.accompanist:accompanist-pager:0.19.0")//efeito de carrosel, seja de imagem ou conteudo, e quando deslizamos ela puxa a imagem e para na imagem
  implementation("io.coil-kt:coil-compose:2.2.2")
  implementation("androidx.core:core-splashscreen:1.0.0")//Lib da tela SplashScreen
  implementation("androidx.media3:media3-exoplayer:1.0.0-rc01")
  implementation("androidx.media3:media3-ui:1.0.0-rc01")
}
