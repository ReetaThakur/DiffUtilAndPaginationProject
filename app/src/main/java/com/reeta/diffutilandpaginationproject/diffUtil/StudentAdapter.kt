package com.reeta.diffutilandpaginationproject.diffUtil

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.reeta.diffutilandpaginationproject.R

class StudentAdapter:RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // list id old data without changes
    private var list:ArrayList<Student> = ArrayList<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_details_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val s_list = list[position]
        holder.setData(s_list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    //in activity say notifyDataSetChanged we can also do same work with this method also
    fun getUpdatedList(newList: ArrayList<Student>) {
        //newList is new data with changes
       val diffUtil=StudentDiffUtil(list,newList)
        val diffResult=DiffUtil.calculateDiff(diffUtil)
        list.clear()
        list.addAll(newList) // we are adding all update item in old list to show on recycler view
         diffResult.dispatchUpdatesTo(this) //to know adapter that data is change
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tvName)
        var address: TextView = itemView.findViewById(R.id.tvAddress)
        fun setData(student: Student) {
            name.text = student.name
            address.text = student.id
        }
    }
}