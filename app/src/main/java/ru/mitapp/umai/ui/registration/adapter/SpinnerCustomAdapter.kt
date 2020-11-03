package ru.mitapp.umai.ui.registration.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ru.mitapp.umai.R
import ru.mitapp.umai.models.SpinnerModel

class SpinnerCustomAdapter(context: Context,
                           objects: ArrayList<SpinnerModel>
) :
    BaseAdapter() {


    var mContext = context
    var list = objects

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        return getCustomView(position, convertView, parent)
    }


    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): SpinnerModel? {
        return list[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }



    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup) : View{
        val holder : SpinnerViewHolder
        val retView : View
        if(convertView == null){
            val layoutInflater : LayoutInflater = LayoutInflater.from(mContext)
            retView = layoutInflater.inflate(R.layout.region_spinner_item, null)
            holder = SpinnerViewHolder()

            holder.nameTv = retView.findViewById(R.id.name) as TextView
            holder.nameTv.text = list[position].name

            retView.tag = holder

        } else{
            holder = convertView.tag as SpinnerViewHolder
            retView = convertView
        }

        return retView!!
    }


    class SpinnerViewHolder{
        lateinit var nameTv : TextView
    }

}