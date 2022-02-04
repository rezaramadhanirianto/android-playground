import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlin.math.abs
import kotlin.math.min

/**
 * Layout Manager that provides animation scale to recycler view
 */
class ScaleLayoutManager internal constructor(
    context: Context?,
    orientation: Int,
    reverseLayout: Boolean
) : LinearLayoutManager(context, orientation, reverseLayout) {
    private var isScaleStart = false
    private var scaleOnScroll = false
    private var isScaleEnd = false
    private var shrinkDistance = 0.75f
    private var shrinkAmount = 0.1f

    override fun onLayoutChildren(recycler: Recycler, state: RecyclerView.State) {
        super.onLayoutChildren(recycler, state)
        scrollHorizontallyBy(0, recycler, state)
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: Recycler, state: RecyclerView.State): Int {
        val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
        return if (scaleOnScroll) {
            for (i in 0 until childCount) {



                /**
                 * Get child width and half width
                 */
                val child = getChildAt(i)
                val childWidth = (child!!.right - child.left).toFloat()
                val childWidthHalf = childWidth / 2f

                /**
                 * Get child center like if the item slice to 2 items
                 */
                val childCenter = if(isScaleEnd) child.left + childWidth else child.left + childWidthHalf
                val parentWidth = if (isScaleStart) childWidth else width.toFloat()
                val parentWidthHalf = if(isScaleEnd) parentWidth else parentWidth / 2f

                val d0 = 0f
                val d1 = shrinkDistance * parentWidthHalf

                val s0 = 1f
                val s1 = 1f - shrinkAmount

                /**
                 * Get scaling and set scaling
                 */
                val d = min(d1, abs(parentWidthHalf - childCenter))
                val position = s0 + (s1 - s0) * (d - d0) / (d1 - d0)
                child.scaleX = position
                child.scaleY = position
            }
            scrolled
        } else {
            scrolled
        }
    }

    fun setScaleOnScroll(scaleOnScroll: Boolean) : ScaleLayoutManager {
        this.scaleOnScroll = scaleOnScroll
        return this
    }

    fun isScaleStart(isScaleStart: Boolean) : ScaleLayoutManager{
        this.isScaleStart = isScaleStart
        return this
    }

    fun isScaleEnd(isScaleEnd: Boolean): ScaleLayoutManager{
        this.isScaleEnd = isScaleEnd
        return this
    }

    fun setShrinkAmount(shrinkAmount: Float) : ScaleLayoutManager{
        this.shrinkAmount = shrinkAmount
        return this
    }

    fun setShrinkDistance(shrinkDistance: Float) : ScaleLayoutManager{
        this.shrinkDistance = shrinkDistance
        return this
    }
}