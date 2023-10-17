package com.example.lab6.fourth.network.pojo

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ValCurs", strict = false)
data class CoinsInfoDto(
    @field:ElementList(name = "Valute", inline = true, required = false)
    @param:ElementList(name = "Valute", inline = true, required = false)
    val coinsList: List<CoinInfo>
)
