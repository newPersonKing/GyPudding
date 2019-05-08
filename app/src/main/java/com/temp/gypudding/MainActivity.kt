package com.temp.gypudding

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AlertDialog
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Toast
import com.zcy.pudding.Choco
import com.zcy.pudding.Pudding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    // 默认形式
    fun click1(view: View) {
        Pudding.create(this) {
            setTitle("This is Title")
            setText("this is text")
        }
                .show()
    }

    // 设置背景颜色、字体
    fun click2(view: View) {
        Pudding.create(this) {
            setChocoBackgroundColor(resources.getColor(R.color.colorAccent))
            setTitleTypeface(Typeface.DEFAULT_BOLD)
        }.show()
    }

    // 更改icon
    fun click3(view: View) {
        Pudding.create(this) {
            setTitle("Choco Title")
            setText("this is text")
            setIcon(R.drawable.ic_event_available_black_24dp)
        }.show()
    }

    // 长说明 文字形式
    fun click4(view: View) {
        Pudding.create(this) {
            setText(R.string.verbose_text_text)
            setIcon(R.drawable.ic_event_available_black_24dp)
        }.show()
    }

    // 永久显示
    fun click5(view: View) {
        Pudding.create(this) {
            setTitle("Choco Title")
            enableInfiniteDuration = true
        }.show()
    }

    // loading 形式
    fun click6(view: View) {
        Pudding.create(this) {
            setTitle("Choco Title")
            setEnableProgress(true)
        }.show()
    }

    // loading 形式
    fun click8(view: View) {
        Pudding.create(this) {
            setTitle("Choco Title")
            setText("This is Text , it's very short and I don't like short \n This is Text , it's very short and I don't like short")
            enableInfiniteDuration = true
            enableSwipeToDismiss()
        }.show()
    }

    // loading 形式
    fun click9(view: View) {
        Pudding.create(this) {
            setTitle("Choco Title")
            setText("This is Text , it's very short and I don't like short \n This is Text , it's very short and I don't like short")
            onShow {
                Toast.makeText(this@MainActivity, "onShowListener", Toast.LENGTH_SHORT).show()
            }
            onDismiss {
                Toast.makeText(this@MainActivity, "onDismissListener", Toast.LENGTH_SHORT).show()
            }
        }.show()
    }

    // loading 形式
    fun click7(view: View) {
        Pudding.create(this) {
            setTitle("Choco Title")
            setText("This is Text , it's very short and I don't like short \n This is Text , it's very short and I don't like short")
            setChocoBackgroundColor(resources.getColor(R.color.color_FFCC00))
            enableInfiniteDuration = true
            addButton("OK", R.style.PuddingButton, View.OnClickListener {
                hide()
                Toast.makeText(this@MainActivity, "click ok", Toast.LENGTH_SHORT).show()
            })
            addButton("NO", R.style.PuddingButton, View.OnClickListener {
                Toast.makeText(this@MainActivity, "click no", Toast.LENGTH_SHORT).show()
            })

        }.show()
    }

    fun showAlertDialog(view: View) {
        AlertDialog.Builder(this)
                .setTitle("AlertDialog")
                .setMessage("normal AlertDialog will cover Pudding")
                .create().show()
    }

    // 启动一个Activity ,验证是否存在lack window exception
    fun startAnActivity(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

}
