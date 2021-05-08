package com.example.finalproject.activities

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.example.finalproject.R
import com.example.finalproject.activities.NiatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quran2.*

class MainActivity : AppCompatActivity() {

    lateinit var context : Context
    lateinit var uriString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }


        btn_quran.setOnClickListener(){
            startActivity(Intent(this, Layout_quran::class.java))
        }

        btn_hukum.setOnClickListener(){
            startActivity(Intent(this, HukumActivity::class.java))
        }

        btn_doa.setOnClickListener(){
            startActivity(Intent(this, DoaActivity::class.java))
        }

        btn_niat.setOnClickListener(){
            startActivity(Intent(this, NiatActivity ::class.java))
        }
        }

    private fun ext(){
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Peringatan !")
        dialog.setMessage("Anda yakin ingin keluar ?")
        dialog.setPositiveButton("Ya") { _: DialogInterface, _: Int ->
            finish()
            super.onBackPressed()
        }
        dialog.setNegativeButton("Tidak") { _: DialogInterface, _: Int -> }
        dialog.show()
    }


    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val window = activity.window
            val layoutParams = window.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            window.attributes = layoutParams
        }
    }
}