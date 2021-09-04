package com.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_album_details.*
import kotlinx.android.synthetic.main.item_album_list.*

class AlbumDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        back_to_dashboards.setOnClickListener {
            finish()
        }

        txt_album_detail_title.text = intent.getStringExtra("title")
    }
}
