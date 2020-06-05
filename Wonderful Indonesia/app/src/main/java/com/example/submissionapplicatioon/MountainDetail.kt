package com.example.submissionapplicatioon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MountainDetail : AppCompatActivity(), View.OnClickListener {

    private lateinit var currentMountainImage: ImageView
    private lateinit var lokasiDetail : TextView
    private lateinit var ketinggianDetail : TextView
    private lateinit var statusDetail : TextView
    private lateinit var mountainNameDetail : TextView
    private lateinit var btnGoBack : Button
    private lateinit var btnCheckMaps : Button
    private lateinit var mountainNameClass : String

    private lateinit var rvGuides: RecyclerView
    private var listGuides: ArrayList<Guide> = arrayListOf()

    companion object {
        const val DATA_NAMA = "data_nama"
        const val DATA_GAMBAR = "data_gambar"
        const val DATA_LOKASI = "data_lokasi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mountain_detail)
        setActionBarTitle("Wonderful Indonesia")

        mountainNameClass = intent.getStringExtra(DATA_NAMA)
        val mountainLocation = intent.getStringExtra(DATA_LOKASI)
        val mountainImage = intent.getIntExtra(DATA_GAMBAR, 0)
        currentMountainImage = findViewById(R.id.current_mountain)
        currentMountainImage.setImageResource(mountainImage)

        setDetailInformation(mountainNameClass, mountainLocation)

        rvGuides = findViewById(R.id.rv_guides)
        rvGuides.setHasFixedSize(true)

        listGuides.addAll(GuideData.listData)
        showRecyclerCardView()

        btnGoBack = findViewById(R.id.btn_back_to_main_activity)
        btnCheckMaps = findViewById(R.id.btn_lookup_on_maps)

        btnGoBack.setOnClickListener(this)
        btnCheckMaps.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_back_to_main_activity ->{
                finish()
            }
            R.id.btn_lookup_on_maps ->{
                val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${mountainNameClass}"))
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }
    }

    private fun showRecyclerCardView() {
        rvGuides.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        val cardViewHeroAdapter = GuideCardAdapter(listGuides)
        rvGuides.adapter = cardViewHeroAdapter
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun setDetailInformation(mountainName : String , mountainLocation: String){
        mountainNameDetail = findViewById(R.id.mountain_nama_detail)
        mountainNameDetail.text = mountainName.toString()

        lokasiDetail = findViewById(R.id.lokasi_tabel)
        ketinggianDetail = findViewById(R.id.ketinggian_tabel)
        statusDetail = findViewById(R.id.status_detail)

        lokasiDetail.text = mountainLocation.toString()

        ketinggianDetail.text = MountainData.mountainElevation[mountainName].toString()

        statusDetail.text = when{
            mountainName in MountainData.mountainStatus["aktif"]!! -> "Aktif"
            mountainName in MountainData.mountainStatus["tidak aktif"]!! -> "Tidak Aktif"
            else -> "Data Not Available"
        }
    }

}
