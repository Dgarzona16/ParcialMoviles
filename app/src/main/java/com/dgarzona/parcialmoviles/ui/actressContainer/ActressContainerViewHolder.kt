package com.dgarzona.parcialmoviles.ui.actressContainer

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dgarzona.parcialmoviles.R

class ActressContainerViewHolder(actressView: View): RecyclerView.ViewHolder(actressView) {
    val name: TextView = actressView.findViewById(R.id.actress_name)
}