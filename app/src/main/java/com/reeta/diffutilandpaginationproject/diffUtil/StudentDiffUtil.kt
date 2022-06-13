package com.reeta.diffutilandpaginationproject.diffUtil

import androidx.recyclerview.widget.DiffUtil

class StudentDiffUtil(private val oldStudentList: List<Student>,
private val newStudentList: List<Student>) :DiffUtil.Callback() {

    //this method will return old list size
    override fun getOldListSize(): Int {
       return oldStudentList.size
    }

    //this method will return new list size
    override fun getNewListSize(): Int {
        return newStudentList.size
    }

    // this method will comapre two list postion with there unique id. in this case student id
    // is unique that's why we are comparing list with ids
    // check both list position is same
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldStudentList[oldItemPosition].id== newStudentList[newItemPosition].id
    }

    // this method comapre content inside both list
    //check that inside that postion data is same or not
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldStudentList[oldItemPosition]==newStudentList[newItemPosition]
    }


}