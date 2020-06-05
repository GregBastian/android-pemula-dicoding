package com.example.submissionapplicatioon

object GuideData {
    private val nameToPhoto = mapOf(
        "Jane" to R.drawable.jane,
        "Satrio" to R.drawable.satrio,
        "Clara" to R.drawable.clara,
        "Tina" to R.drawable.tina,
        "Steve" to R.drawable.steve,
        "Tenzin" to R.drawable.tenzin,
        "Wijaya" to R.drawable.wijaya
    )

    val listData: ArrayList<Guide>
        get() {
            val list = arrayListOf<Guide>()
            for ((guideName, guidePhoto) in nameToPhoto) {
                val guide = Guide()
                guide.name = guideName
                guide.photo = guidePhoto
                list.add(guide)
            }
            return list
        }
}