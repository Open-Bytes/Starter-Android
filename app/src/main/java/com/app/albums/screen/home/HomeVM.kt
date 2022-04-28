package com.app.albums.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import com.app.albums.shared.di.TmpAlbumsRepo
import com.app.albums.shared.di.TmpUsersRepo
import com.app.core.domain.albums.model.Album
import com.app.core.domain.users.model.User
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val state: SavedStateHandle, //TODO: remove
) : AppViewModel() {

    var currentUser: User? by mutableStateOf(null)
    private var users = SnapshotStateList<User>()

    var albums = SnapshotStateList<Album>()

    init {
        fetchUsers()
        fetchAlbums()
    }

    private fun fetchUsers() {
        request(execute = {
            TmpUsersRepo.usersRepo.getUsers()
        }) {
            if (it.isNullOrEmpty()) {
                //TODO: show error
                return@request
            }
            users.clear()
            users.addAll(it)
            currentUser = users.random()
        }
    }

    private fun fetchAlbums() {
        request(execute = {
            TmpAlbumsRepo.albumsRepo.getAlbums()
        }) {
            if (it.isNullOrEmpty()) {
                //TODO: show error
                return@request
            }
            albums.clear()
            albums.addAll(it)
        }
    }
}