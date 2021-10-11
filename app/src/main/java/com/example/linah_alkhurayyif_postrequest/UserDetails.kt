package com.example.linah_alkhurayyif_postrequest

import com.google.gson.annotations.SerializedName

class UserDetails {
    var data: List<User>? =null
    class User{
        @SerializedName("name")
        var name: String? =null
        @SerializedName("location")
        var location: String? =null
        @SerializedName("pk")
        var pk: Int? =null
        constructor(name: String?, location: String?,pk: Int?) {
            this.name = name
            this.location = location
            this.pk = pk
        }
    }
}