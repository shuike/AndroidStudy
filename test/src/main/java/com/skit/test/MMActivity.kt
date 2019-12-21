package com.skit.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/kk/ss", name = "KK")
class MMActivity : AppCompatActivity() {
    @Autowired
    @JvmField var name: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mm)
        ARouter.getInstance().inject(this)
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}
