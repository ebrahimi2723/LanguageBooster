package com.example.languagebooster.data

import model.Words

object MockData {
    private  val list = ArrayList<Words>()
    public fun addToList(words: Words){
        list.add(words)
    }
    public fun grtListWord():ArrayList<Words>{
        return list
    }
}