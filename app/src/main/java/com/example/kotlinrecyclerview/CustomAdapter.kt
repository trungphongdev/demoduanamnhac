package com.example.kotlinrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

open class CustomAdapter(private val dataSet: List<DataModel>,
                         private val context: Context,
                         /*private val onClickItem: ItemClickListener*/) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface eventlistener {
        fun position(i: Int)
    }
    var listen: eventlistener? = null
    fun setlistener(listener1: eventlistener) {
         this.listen = listener1
    }

    var onClickItem1: ((Int) -> Unit)? = null

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }
     class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val textView:TextView = view.findViewById(R.id.myTextView)
         val cardView:CardView = view.findViewById(R.id.myCardView)

    }
     class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val txvCustom: TextView = view.findViewById(R.id.myTextViewCustom)
         val  txvCardView:CardView = view.findViewById(R.id.myCardViewCustom)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        if(viewType == VIEW_TYPE_ONE) {
            return ViewHolder(LayoutInflater.from(context).
            inflate(R.layout.layout_item_row,
                parent,
                false))
        } else {
            val view: View = LayoutInflater.from(parent.context).
            inflate(R.layout.custumer_item_row,parent,false)
            return CustomViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder) {
            holder.textView.text = dataSet[position].itemName
            holder.cardView.setBackgroundColor(
                ContextCompat.getColor(
                    context, R.color.teal_200))
        }
        if(holder is CustomViewHolder){
            holder.txvCustom.text = dataSet[position].itemName
            holder.txvCardView.setBackgroundColor(
                ContextCompat.getColor(context, R.color.purple_700)
            )
            // truyen nhan du lieu
            holder.txvCardView.setOnClickListener {  listen?.position(position) }
        // holder.txvCardView.setOnClickListener { onClickItem1?.let { it1 -> it1(position) } }
        //    holder.txvCardView.setOnClickListener { onClickItem.itemGetPosition(position) }
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataSet[position].newType
    }




}