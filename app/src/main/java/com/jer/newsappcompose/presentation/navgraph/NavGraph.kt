package com.jer.newsappcompose.presentation.navgraph

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.jer.newsappcompose.presentation.detail.DetailsScreen
import com.jer.newsappcompose.presentation.home.HomeScreen
import com.jer.newsappcompose.presentation.home.HomeViewModel
import com.jer.newsappcompose.presentation.onBoarding.OnBoardingEvent
import com.jer.newsappcompose.presentation.onBoarding.OnBoardingScreen
import com.jer.newsappcompose.presentation.onBoarding.OnBoardingViewModel
import com.jer.newsappcompose.presentation.search.SearchEvent
import com.jer.newsappcompose.presentation.search.SearchScreen
import com.jer.newsappcompose.presentation.search.SearchViewModel

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
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
//                val viewModel: HomeViewModel = hiltViewModel()
//                val articles = viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(
//                    articles = articles,
//                    navigate = {}
//                )
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(state = viewModel.state.value, event =  viewModel::onEvent, navigateToDetail = {})


            }
            composable(route = Route.SearchScreen.route) {

//                val viewModel: SearchViewModel = hiltViewModel()
//                SearchScreen(state = viewModel.state.value, event =  {viewModel::onEvent}, navigate = {})
//
            }
            composable(route = Route.BookmarkScreen.route) {

            }
            composable(route = Route.DetailsScreen.route) {


            }
        }
    }

}