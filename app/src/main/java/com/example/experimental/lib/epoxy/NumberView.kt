package com.example.experimental.lib.epoxy

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.experimental.R

@EpoxyModelClass(layout = R.layout.item_number)
abstract class NumberView: EpoxyModelWithHolder<NumberView.Holder>() {
    @EpoxyAttribute
    lateinit var title: String
    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.tv.text = title
    }
    inner class Holder: KotlinEpoxyHolder(){
        val tv by bind<TextView>(R.id.tv)
    }
}

//@EpoxyModelClass(layout = R.layout.layout_header)
//abstract class HeaderView : EpoxyModelWithHolder<HeaderView.Holder>() {
//
//    @EpoxyAttribute
//    lateinit var title: String
//
//    override fun bind(holder: Holder) {
//        super.bind(holder)
//        holder.title.text = title
//    }
//
//    inner class Holder : KotlinEpoxyHolder() {
//        val title by bind<AppCompatTextView>(R.id.header_title)
//    }
//}