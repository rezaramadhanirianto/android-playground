package com.example.experimental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.experimental.custom.transition.FirstActivity
import com.example.experimental.liveDataRecyclerView.RecyclerViewActivity
import com.example.experimental.singleActivity.SingleActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper())
            .postDelayed({
                startActivity(Intent(this, SingleActivity::class.java))
            }, 500)
    }
}