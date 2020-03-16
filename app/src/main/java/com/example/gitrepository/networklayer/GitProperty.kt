package com.example.gitrepository.networklayer

import com.squareup.moshi.Json

/**
 * @author olivverde
 * Gather Api stuff.
 * Retrieved from: https://jsonplaceholder.typicode.com/
 */
data class GitProperty(
    @Json(name = "login") val userName: String,
    @Json(name = "avatar_url") val userImage: String,
    @Json(name = "repos_url") val repositoryUrl: String

)