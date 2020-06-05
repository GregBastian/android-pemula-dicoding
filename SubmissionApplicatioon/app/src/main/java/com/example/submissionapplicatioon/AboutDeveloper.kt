package com.example.submissionapplicatioon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class AboutDeveloper : AppCompatActivity(), View.OnClickListener {

    private var title = "About Developer"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_developer)
        setActionBarTitle(title)

        val btnSendEmail: ImageButton = findViewById(R.id.btn_send_email)
        btnSendEmail.setOnClickListener(this)

        val btnCheckProfile: ImageButton = findViewById(R.id.btn_check_dicoding)
        btnCheckProfile.setOnClickListener(this)
        }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_send_email -> {
                val emailDeveloper = "ivansebastian60@gmail.com"
                val dialPhoneIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$emailDeveloper"))
                //Uri.parse("mailto:")
                startActivity(dialPhoneIntent)
            }
            R.id.btn_check_dicoding -> {
                val profileDeveloperURL = "https://www.dicoding.com/users/768452"
                val checkDeveloperProfileIntent = Intent(Intent.ACTION_VIEW, Uri.parse(profileDeveloperURL))
                if (checkDeveloperProfileIntent.resolveActivity(packageManager) != null) {
                    startActivity(checkDeveloperProfileIntent)
                }
            }
        }
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
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
                finish()
            }
            R.id.action_about -> {
                //DO NOTHING BECAUSE YOU'RE ALREADY THERE
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }

}
