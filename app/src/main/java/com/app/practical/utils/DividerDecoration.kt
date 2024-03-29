package com.app.practical.utils

import android.R
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class DividerDecoration(context: Context) : ItemDecoration() {
    private val mDivider: Drawable?
    private fun getOrientation(parent: RecyclerView): Int {
        val layoutManager: LinearLayoutManager?
        layoutManager = try {
            parent.layoutManager as LinearLayoutManager?
        } catch (e: ClassCastException) {
            throw IllegalStateException(
                "DividerDecoration can only be used with a " +
                        "LinearLayoutManager.", e
            )
        }
        return layoutManager!!.orientation
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        if (getOrientation(parent) == VERTICAL_LIST) {
            drawVertical(c, parent)
        } else {
            drawHorizontal(c, parent)
        }
    }

    fun drawVertical(c: Canvas?, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val recyclerViewTop = parent.paddingTop
        val recyclerViewBottom = parent.height - parent.paddingBottom
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                .layoutParams as RecyclerView.LayoutParams
            val top = Math.max(recyclerViewTop, child.bottom + params.bottomMargin)
            val bottom = Math.min(recyclerViewBottom, top + mDivider!!.intrinsicHeight)
            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c!!)
        }
    }

    fun drawHorizontal(c: Canvas?, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom
        val recyclerViewLeft = parent.paddingLeft
        val recyclerViewRight = parent.width - parent.paddingRight
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                .layoutParams as RecyclerView.LayoutParams
            val left = Math.max(recyclerViewLeft, child.right + params.rightMargin)
            val right = Math.min(recyclerViewRight, left + mDivider!!.intrinsicHeight)
            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c!!)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (getOrientation(parent) == VERTICAL_LIST) {
            outRect[0, 0, 0] = mDivider!!.intrinsicHeight
        } else {
            outRect[0, 0, mDivider!!.intrinsicWidth] = 0
        }
    }

    companion object {
        private val ATTRS = intArrayOf(
            R.attr.listDivider
        )
        const val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
        const val VERTICAL_LIST = LinearLayoutManager.VERTICAL
    }

    init {
        val a: TypedArray = context.obtainStyledAttributes(ATTRS)
        mDivider = a.getDrawable(0)
        a.recycle()
    }
}
