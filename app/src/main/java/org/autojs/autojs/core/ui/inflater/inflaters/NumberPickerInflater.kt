package org.autojs.autojs.core.ui.inflater.inflaters

import android.content.Context
import android.view.ViewGroup
import android.widget.NumberPicker
import org.autojs.autojs.core.ui.inflater.ResourceParser
import org.autojs.autojs.core.ui.inflater.ViewCreator

open class NumberPickerInflater<V : NumberPicker>(resourceParser: ResourceParser) : LinearLayoutInflater<V>(resourceParser) {

    override fun getCreator(): ViewCreator<in V> = object : ViewCreator<NumberPicker> {
        override fun create(context: Context, attrs: HashMap<String, String>, parent: ViewGroup?): NumberPicker {
            return NumberPicker(context)
        }
    }

}
