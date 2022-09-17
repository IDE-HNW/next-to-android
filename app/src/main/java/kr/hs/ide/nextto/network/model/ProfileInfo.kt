package kr.hs.ide.nextto.network.model

data class ProfileInfo(
    val memberId :String,
    val name : String,
    val emergencyContact : String,
    val roleAddress : String,
    val detailAddress : String
)
