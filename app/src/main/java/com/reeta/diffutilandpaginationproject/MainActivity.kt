package com.reeta.diffutilandpaginationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reeta.diffutilandpaginationproject.diffUtil.DiffUtilActivity
import com.reeta.diffutilandpaginationproject.pagination.ui.PaginationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDiffUtil.setOnClickListener {
            val intent=Intent(this,DiffUtilActivity::class.java)
            startActivity(intent)
        }

        btnPagination.setOnClickListener {
            val intent=Intent(this, PaginationActivity::class.java)
            startActivity(intent)
        }
    }
}