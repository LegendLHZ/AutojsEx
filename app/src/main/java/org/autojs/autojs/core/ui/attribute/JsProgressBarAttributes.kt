package org.autojs.autojs.core.ui.attribute

import android.view.View
import org.autojs.autojs.core.ui.inflater.ResourceParser
import org.autojs.autojs.core.ui.widget.JsProgressBar

class JsProgressBarAttributes(resourceParser: ResourceParser, view: View) : ProgressBarAttributes(resourceParser, view) {

    override val view = super.view as JsProgressBar

}