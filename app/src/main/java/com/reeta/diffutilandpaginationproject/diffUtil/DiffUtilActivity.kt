package com.reeta.diffutilandpaginationproject.diffUtil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.reeta.diffutilandpaginationproject.R
import kotlinx.android.synthetic.main.activity_diff_util.*

class DiffUtilActivity : AppCompatActivity() {

    var list=ArrayList<Student>()
    lateinit var studentAdapter: StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util)
        buildData()
        sendData()
    }

    private fun sendData() {
        studentAdapter= StudentAdapter()
        var linearLayoutManager= LinearLayoutManager(this)
        diffRecyclerView.apply {
            adapter=studentAdapter
            layoutManager=linearLayoutManager
            studentAdapter.getUpdatedList(list)
        }
    }

    private fun buildData() {
        for (i in 1..40) {
            list.add(Student("reeta Thakur", "$i"))

        }

    }
}