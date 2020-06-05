package com.example.submissionapplicatioon

object MountainData {
    private val mountainNames = arrayOf(
        "Gunung Latimojong",
        "Gunung Bromo",
        "Gunung Merapi",
        "Gunung Semeru",
        "Gunung Rinjani",
        "Gunung Kerinci",
        "Gunung Slamet",
        "Gunung Sumbing",
        "Gunung Ijen",
        "Gunung Kelud",
        "Gunung Gede",
        "Gunung Papandayan"
    )

    private val mountainLocations = arrayOf(
        "Sulawesi Selatan",
        "Jawa Timur",
        "Yogyakarta",
        "Jawa Timur",
        "Nusa Tenggara Barat",
        "Jambi",
        "Jawa Tengah",
        "Jawa Tengah",
        "Jawa Timur",
        "Jawa Timur",
        "Jawa Barat",
        "Jawa Barat"
    )

    private val mountainImages = intArrayOf(
        R.drawable.latimojong,
        R.drawable.bromo,
        R.drawable.merapi,
        R.drawable.semeru,
        R.drawable.rinjani,
        R.drawable.kerinci,
        R.drawable.slamet,
        R.drawable.sumbing,
        R.drawable.ijen,
        R.drawable.kelud,
        R.drawable.gede,
        R.drawable.papandayan
    )

    val mountainElevation = mapOf(
        "Gunung Bromo" to "2329 m",
        "Gunung Merapi" to "2930 m",
        "Gunung Semeru" to "3676 m",
        "Gunung Rinjani" to "3726 m",
        "Gunung Kerinci" to "3805 m",
        "Gunung Slamet" to "3428 m",
        "Gunung Sumbing" to "3371 m",
        "Gunung Ijen" to "2779 m",
        "Gunung Kelud" to "1731 m",
        "Gunung Gede" to "2958 m",
        "Gunung Papandayan" to "2265 m",
        "Gunung Latimojong" to "3478 m"
    )

    val mountainStatus = mapOf(
        "aktif" to arrayOf(
            "Gunung Bromo",
            "Gunung Merapi",
            "Gunung Semeru",
            "Gunung Rinjani",
            "Gunung Kerinci",
            "Gunung Slamet",
            "Gunung Sumbing",
            "Gunung Ijen",
            "Gunung Kelud",
            "Gunung Gede",
            "Gunung Papandayan"
        ),
        "tidak aktif" to arrayOf(
            "Gunung Latimojong"
        )
    )


    val listData: ArrayList<Mountain>
        get() {
            val mountainList = arrayListOf<Mountain>()
            for (position in mountainNames.indices) {
                val mountain = Mountain()
                mountain.name = mountainNames[position]
                mountain.location = mountainLocations[position]
                mountain.photo = mountainImages[position]
                mountainList.add(mountain)
            }
            return mountainList
        }
}