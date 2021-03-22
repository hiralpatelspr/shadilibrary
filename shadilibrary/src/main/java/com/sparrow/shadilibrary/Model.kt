package com.sparrow.shadilibrary

data class Ragister_one(
    val message: String,
    val success: Boolean
)


data class Ragister_two(
    val message: String,
    val success: Boolean
)

data class Registe_three(
    val message: String,
    val success: Boolean
)


data class Register_four(
    val message: String,
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


data class Sub_education(
    val detail: List<subedu>
)

data class subedu(
    val educations_name: String,
    val id: String,
    val religion_id: String,
    val sub_reg_name: String
)



data class Sub_Religion(
    val detail: List<subrel>
)

data class subrel(
    val id: String,
    val religion_id: String,
    val religion_name: String,
    val sub_reg_name: String
)



data class Register_five(
    val Message: String
)



data class Login(
    val msg: String,
    val success: Boolean
)

data class MatchArray(
    val detail: List<match_array>
)

data class match_array(
    val detail_bio: String,
    val gender: String,
    val id: String,
    val like_activite: String,
    val match_religion: String,
    val mcountry: String,
    val mdiet: String,
    val meducation: String,
    val name: String
)


data class Image_array(
    val detail: List<Detailss>
)

data class Detailss(
    val msg: String
)