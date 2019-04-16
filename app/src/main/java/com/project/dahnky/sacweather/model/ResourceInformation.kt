package com.project.dahnky.sacweather.model

data class ResourceInformationList(
    val resources: List<ResourceInformation>
)


data class ResourceInformation(
    val title: String,
    val description: String,
    val link: String
)