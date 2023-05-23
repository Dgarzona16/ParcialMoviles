package com.dgarzona.parcialmoviles.ui.actressContainer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dgarzona.parcialmoviles.R
import com.dgarzona.parcialmoviles.models.Actress

class ActressContainerAdapter(
    private val actressList: List<Actress>
    ): RecyclerView.Adapter<ActressContainerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActressContainerViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.actress_item,parent,false)
        return ActressContainerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActressContainerViewHolder, position: Int) {
        val actress = actressList[position]
        holder.name.text = actress.name
    }

    override fun getItemCount(): Int {
        return actressList.count()
    }
}