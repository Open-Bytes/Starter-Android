package com.app.data.api.albums

import com.app.core.domain.albums.AlbumsRepository
import com.app.core.domain.albums.model.Album
import retrofit2.Response

class AlbumsRepositoryImpl(val api: AlbumsApi) : AlbumsRepository {

    override suspend fun getAlbums(): Response<List<Album>> {
        return api.getAlbums()
    }
}