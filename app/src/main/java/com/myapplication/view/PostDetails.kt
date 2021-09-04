package com.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_post_details.*

class PostDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)

        back_to_dashboard.setOnClickListener {
            finish()
        }

        txt_post_details_title.text = intent.getStringExtra("name")
        txt_post_details_comments.text = intent.getStringExtra("comments")
    }
}
