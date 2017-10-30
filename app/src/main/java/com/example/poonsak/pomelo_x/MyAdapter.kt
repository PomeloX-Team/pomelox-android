package com.example.poonsak.pomelo_x

//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.TextView
//import com.example.poonsak.pomelo_x.MyAdapter.ViewHolder
//
//import com.example.poonsak.pomelo_x.R
//
//class MyAdapter// Provide a suitable constructor (depends on the kind of dataset)
//(private val mDataset: Array<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
//
//    // Provide a reference to the views for each data item
//    // Complex data items may need more than one view per item, and
//    // you provide access to all the views for a data item in a view holder
//    class ViewHolder(// each data item is just a string in this case
//            var mTextView: TextView) : RecyclerView.ViewHolder(mTextView)
//
//    // Create new views (invoked by the layout manager)
//    override fun onCreateViewHolder(parent: ViewGroup,
//                                    viewType: Int): MyAdapter.ViewHolder {
//        // create a new view
//        val v = LayoutInflater.from(parent.context)
//                .inflate(R.layout.recv_tv, parent, false) as TextView
//        // set the view's size, margins, paddings and layout parameters
//        return ViewHolder(v)
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        holder.mTextView.text = mDataset[position]
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount(): Int {
//        return mDataset.size
//    }
//}

//package com.vogella.android.recyclerview

import java.util.ArrayList

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class MyAdapter// Provide a suitable constructor (depends on the kind of dataset)
(private val values: MutableList<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    inner class ViewHolder(var layout: View) : RecyclerView.ViewHolder(layout) {
        // each data item is just a string in this case
        var txtHeader: TextView
        var txtFooter: TextView

        init {
            txtHeader = layout.findViewById<TextView>(R.id.firstLine)
            txtFooter = layout.findViewById<TextView>(R.id.secondLine)
        }
    }

    fun add(position: Int, item: String) {
        values.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        values.removeAt(position)
        notifyItemRemoved(position)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.ViewHolder {
        // create a new view
        val inflater = LayoutInflater.from(
                parent.getContext())
        val v = inflater.inflate(R.layout.recv_tv, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Log.d("Location: ", "Location: " + position)
        val name = values[position]
        holder.txtHeader.setText(name)
//        holder.txtHeader.setOnClickListener(object : OnClickListener {
//            override fun onClick(v: View) {
//                remove(position)
//            }
//        }
//    )

        holder.txtFooter.setText("Footer: " + name)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return values.size
    }

}