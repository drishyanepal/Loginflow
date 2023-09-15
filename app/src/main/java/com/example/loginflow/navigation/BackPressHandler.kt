package com.example.loginflow.navigation

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcherOwner?> { null }

private class ComposableBackNavigationHandler(enabled: Boolean) : OnBackPressedCallback(enabled) {

    override fun handleOnBackPressed() {

    }
}