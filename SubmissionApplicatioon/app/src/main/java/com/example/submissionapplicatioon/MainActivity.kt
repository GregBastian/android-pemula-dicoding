package com.example.submissionapplicatioon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMountains: RecyclerView
    private var listMain: ArrayList<Mountain> = arrayListOf()
    private var title = "Wonderful Indonesia"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBarTitle(title)
        setContentView(R.layout.activity_main)

        rvMountains = findViewById(R.id.rv_mountains)
        rvMountains.setHasFixedSize(true)

        listMain.addAll(MountainData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMountains.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(listMain)
        rvMountains.adapter = listAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                //DO NOTHING BECAUSE YOU'RE ALREADY THERE
            }
            R.id.action_about -> {
                startActivity(Intent(this@MainActivity, AboutDeveloper::class.java))
            }

        }
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

}
