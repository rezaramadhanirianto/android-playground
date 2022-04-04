package com.example.experimental.custom.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class ExampleAttachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frame = FrameLayout(this)
        frame.id = CONTENT_VIEW_ID
        setContentView(
            frame, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        if (savedInstanceState == null) {
            val newFragment: Fragment = DebugExampleTwoFragment()
            supportFragmentManager.beginTransaction()
                .replace(CONTENT_VIEW_ID, newFragment)
                .commit()
            val frag: Fragment = DebugExampleTwoFragment()
            supportFragmentManager.beginTransaction()
                .add(CONTENT_VIEW_ID, frag)
                .addToBackStack(DebugExampleTwoFragment::class.java.simpleName)
                .commit()
        }
    }
    class DebugExampleTwoFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val v = EditText(getActivity())
            v.setText("Hello Fragment!")
            return v
        }
    }

    companion object {
        private const val CONTENT_VIEW_ID = 10101010
    }
}