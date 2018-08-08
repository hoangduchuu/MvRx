package com.airbnb.mvrx.sample.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.airbnb.mvrx.sample.core.bindView
import com.airbnb.mvrx.sample.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class Marquee @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val titleView: TextView by bindView(R.id.title)
    private val subtitleView: TextView by bindView(R.id.subtitle)

    init {
        inflate(context, R.layout.marquee, this)
        orientation = VERTICAL
    }

    @TextProp
    fun setTitle(title: CharSequence) {
        titleView.text = title
    }

    @TextProp
    fun setSubtitle(subtitle: CharSequence?) {
        subtitleView.visibility = if(subtitle.isNullOrBlank()) View.GONE else View.VISIBLE
        subtitleView.text = subtitle
    }
}