package com.app.data.api.albums

import com.app.core.domain.albums.model.AlbumDto
import retrofit2.Response
import retrofit2.http.GET

interface AlbumsApi {

    @GET("albums")
    suspend fun getAlbums(): Response<List<AlbumDto>>
}