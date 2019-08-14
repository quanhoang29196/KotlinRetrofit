package com.example.kotlinretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(private val objects: ArrayList<Users>, private val listener: Listener) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    interface Listener {
        fun onItemClick(users: Users)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(objects[position], listener)

    }

    override fun getItemCount(): Int = objects.count()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(view)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(users: Users, listener: Listener) {

            itemView.setOnClickListener { listener.onItemClick(users) }
            itemView.something.text = users.something
            itemView.anything.text = users.anything

        }

    }
}