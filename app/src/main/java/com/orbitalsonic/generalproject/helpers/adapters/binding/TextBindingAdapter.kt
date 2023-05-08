package com.orbitalsonic.generalproject.helpers.adapters.binding

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.orbitalsonic.generalproject.R

/**
 * @param: dTextColor -> Set attribute color for this
 *  Syntax:
 *      xml     ->   app:dTextColor="@{item.isSelected}"
 */
@BindingAdapter("dTextColor")
fun TextView.setDTextColor(isItemSelected:Boolean) {
//    if (isItemSelected){
//        val typedArray = context.theme.obtainStyledAttributes(intArrayOf(R.attr.colorFromAttribute))
//        val textColor = typedArray.getColor(0, 0)
//        typedArray.recycle()
//        this.setTextColor(textColor)
//    }else{
//        this.setTextColor(ContextCompat.getColor(context, R.color.normalColor))
//    }

}
