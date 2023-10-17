package com.example.lab6.fourth.network.pojo

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
@Root(name = "Valute", strict = false)
data class CoinInfo(

    @field:Element(name = "Name")
    @param:Element(name = "Name")
    val name: String,

    @field:Element(name = "Value")
    @param:Element(name = "Value")
    val value: String
)
