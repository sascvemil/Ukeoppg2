package com.example.ukeoppg2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>()
    private var adapter: MsgAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMsg()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter
        send.setOnClickListener(this)
    }

    private fun initMsg() {
        val msg1 = Msg("TESTING", Msg.TYPE_RECEIVED)
        msgList.add(msg1)

        val msg2 = Msg("omg hiiii",Msg.TYPE_SENT)
        msgList.add(msg2)

        val msg3 = Msg("yes ma'am",Msg.TYPE_RECEIVED)
        msgList.add(msg3)

        val msg4 = Msg("heeeey suup ?",Msg.TYPE_SENT)
        msgList.add(msg4)

        val msg5 = Msg("damn",Msg.TYPE_SENT)
        msgList.add(msg5)
    }

    override fun onClick(v: View?) {
        when (v) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()){
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemChanged(msgList.size - 1)
                    recyclerView.scrollToPosition(msgList.size - 1)
                    inputText.setText("")
                }
            }
        }
    }
}