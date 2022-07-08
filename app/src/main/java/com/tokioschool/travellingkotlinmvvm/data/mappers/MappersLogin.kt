package com.tokioschool.travellingkotlinmvvm.data.mappers

import com.tokioschool.travellingkotlinmvvm.data.response.UserResponse
import com.tokioschool.travellingkotlinmvvm.domain.models.User

fun UserResponse.mapToUser() = User(
    name = this.name ?: "",
    surName = this.surName ?: "sin apellido",
    age = 23
)
