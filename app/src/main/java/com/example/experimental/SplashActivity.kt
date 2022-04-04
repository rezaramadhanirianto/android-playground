package com.example.experimental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import com.example.experimental.configurationChanges.ConfigurationChangesActivity
import com.example.experimental.custom.backgroundThread.NumberCounter
import com.example.experimental.custom.fragment.ExampleAttachActivity
import com.example.experimental.custom.pendingIntent.PendingIntentActivity
import com.example.experimental.custom.service.ServiceActivity
import com.example.experimental.custom.transition.FirstActivity
import com.example.experimental.liveDataRecyclerView.RecyclerViewActivity
import com.example.experimental.singleActivity.SingleActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        NumberCounter.start()
        Handler(Looper.getMainLooper())
            .postDelayed({
                startActivity(Intent(this, ExampleAttachActivity::class.java))
                finish()
            }, 3000)
    }
}