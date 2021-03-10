package com.sparrow.shadilibrary

data class Ragister_one(
    val message: String,
    val success: Boolean
)


data class Ragister_two(
    val message: String,
    val success: Boolean
)

data class Ragister_three(
    val message: String,
    val success: Boolean
)

data class Ragister_four(
    val msg: String,
    val success: Boolean
)

data class country(
    val detail: List<Detail>
)

data class Detail(
    val id: String,
    val name: String
)