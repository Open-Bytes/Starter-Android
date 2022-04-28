package com.app.presentation.activity.screen

import android.content.Context
import androidx.compose.runtime.Composable
import com.app.presentation.loader.ProgressDialog
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
interface AppScreen<VM : AppViewModel> {
    val vm: VM
    val host: ScreenHost

    @Composable
    fun Content()

    private val loaderDialog: ProgressDialog
        get() = ProgressDialog(context = context())

    fun activity() = host.activity
    fun context(): Context = host.activity.baseContext

    fun navigate(route: ScreenRoute) {
        host.navigate(route)
    }

    fun navigate(route: String) {
        host.navigate(route)
    }

    fun setup() {
        vm.loading.observeForever { isLoading ->
            when (isLoading) {
                true -> loaderDialog.show()
                false -> loaderDialog.dismiss()
            }
        }
    }
}