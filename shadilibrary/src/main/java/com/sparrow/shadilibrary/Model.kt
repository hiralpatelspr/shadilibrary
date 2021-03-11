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


data class States(
    val detail: List<Details>
)

data class Details(
    val city_id: String,
    val city_name: String,
    val id: String,
    val sub_city_name: String
)

data class Cities(
        val detail: List<city>
)

data class city(
        val city_id: String,
        val city_name: String,
        val id: String,
        val sub_city_name: String
)


data class Education(
    val detail: List<edu>
)

data class edu(
    val id: String,
    val name: String
)


data class Religions(
    val detail: List<rel>
)

data class rel(
    val id: String,
    val name: String
)