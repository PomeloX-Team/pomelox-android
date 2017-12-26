package com.madlab.poonsak.pomelo_x.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.madlab.poonsak.pomelo_x.R

class RecyclerViewAdapter// Provide a suitable constructor (depends on the kind of dataset)
(private val values: MutableList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

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
                                    viewType: Int): ViewHolder {
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

        val name = values[position]
        holder.txtHeader.setText(name)
        holder.txtHeader.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                remove(position)
            }
        }
    )

        holder.txtFooter.setText("Footer: " + name)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return values.size
    }

}