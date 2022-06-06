package com.example.languagebooster.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.languagebooster.R
import model.Words
import soup.neumorphism.NeumorphImageButton
import soup.neumorphism.NeumorphImageView

class RecyclerAdapter(var wordList: ArrayList<Words>) :
    RecyclerView.Adapter<RecyclerAdapter.WordHolder>() {

    class WordHolder(view: View) : RecyclerView.ViewHolder(view) {
        var keyword: TextView = view.findViewById(R.id.item_text)
        var neumorphImageView: NeumorphImageView = view.findViewById(R.id.imgView)
        var star: NeumorphImageButton = view.findViewById(R.id.starHolder)
        var border: View = view.findViewById(R.id.border)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        /**
        in this method we must Inflate the recycler_view_row.xml
         */

        val inflateView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
        return WordHolder(inflateView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WordHolder, position: Int) {


        var item = wordList[position]
        /**
         * set text from word list to recycler view
         */

        holder.keyword.text = "${item.keyword} : ${item.meaning}"


        /**
         * set star to fill or stork
         */

        setStar(holder, item)

        /**
         *  set Invisible last border
         */

        if (position == wordList.size - 1) {
            holder.border.visibility = View.GONE
        }

        /**
         * set onclickListener for star button
         */
        holder.star.setOnClickListener {
            item.stared = !item.stared

            setStar(holder,item)
        }
    }



    override fun getItemCount(): Int {
        return wordList.size
    }


    /**
     *  this metod change the star to stroke or fill
     */
    private fun setStar(
        holder: WordHolder,
        item: Words
    ) {
        holder.star.setImageResource(
            if (item.stared)
                R.drawable.star_fild_24
            else
                R.drawable.star_border_24
        )
    }
}