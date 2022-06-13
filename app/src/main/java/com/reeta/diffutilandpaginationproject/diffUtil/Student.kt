package com.reeta.diffutilandpaginationproject.diffUtil

data class Student(var name:String,var id:String){

    // this method use to make object equal
    // diff util use equals method for comparing 2 objects
    override fun equals(other: Any?): Boolean {
        if (javaClass != other?.javaClass) return false
        val student=other as Student
        if (name != student.name) return false
        if (id != student.id) return false
        return true
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
