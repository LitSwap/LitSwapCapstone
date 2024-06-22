package com.bangkit.caps.data.local.remote

import com.bangkit.caps.data.entity.Book
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    interface ApiService {
        @GET("api/books")
        suspend fun getBooks(): Response<List<Book>>

        @POST("api/books")
        suspend fun addBook(@Body book: Book): Response<Book>
    }
}