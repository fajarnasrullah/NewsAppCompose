package com.jer.newsappcompose.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.jer.newsappcompose.presentation.bookmark.BookmarkScreen
import com.jer.newsappcompose.presentation.bookmark.BookmarkViewModel
import com.jer.newsappcompose.presentation.newsNavigator.NewsNavigator
import com.jer.newsappcompose.presentation.onBoarding.OnBoardingScreen
import com.jer.newsappcompose.presentation.onBoarding.OnBoardingViewModel

@Composable
fun NavGraph (startDestination: String) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {

                NewsNavigator()
//                val viewModel: HomeViewModel = hiltViewModel()
//                val articles = viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(
//                    articles = articles,
//                    navigate = {}
//                )
//                val viewModel: SearchViewModel = hiltViewModel()
//                SearchScreen(state = viewModel.state.value, event =  viewModel::onEvent, navigateToDetail = {})

//                val viewModel: BookmarkViewModel = hiltViewModel()
//                BookmarkScreen(state = viewModel.state.value, navigateToDetail = {})


            }
//            composable(route = Route.SearchScreen.route) {
//
////                val viewModel: SearchViewModel = hiltViewModel()
////                SearchScreen(state = viewModel.state.value, event =  {viewModel::onEvent}, navigate = {})
////
//            }
//            composable(route = Route.BookmarkScreen.route) {
//
//            }
//            composable(route = Route.DetailsScreen.route) {
//
//
//            }
        }
    }

}