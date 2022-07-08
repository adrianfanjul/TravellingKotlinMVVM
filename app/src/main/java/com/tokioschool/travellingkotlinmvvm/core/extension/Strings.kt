package com.tokioschool.travellingkotlinmvvm.core.extension

/*
 *Estension metod to check if string is Email
 */
fun String.isEmail(): Boolean {
       val regex=Regex( "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")
        return matches(regex)
}

fun String.isValidPass():Boolean{
    val regex=Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$")
    return matches(regex)
}