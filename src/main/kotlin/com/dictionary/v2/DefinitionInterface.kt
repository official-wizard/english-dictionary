package com.dictionary.v2

import com.dictionary.v2.response.Definitions
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DefinitionInterface {

    /**
     * Searches for the specified [term] in the urban dictionary
     */
    @GET("/api/v2/entries/en/{term}")
    fun define(
        @Path("term") term: String
    ): Call<Definitions>
}