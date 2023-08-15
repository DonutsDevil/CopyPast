package com.swapnil.copypast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swapnil.copypast.CopyPastApplication
import com.swapnil.copypast.R
import com.swapnil.copypast.repository.CopyPastDB
import com.swapnil.copypast.repository.CopyPastRepository
import com.swapnil.copypast.repository.dao.ClipBoardItemDao
import com.swapnil.copypast.util.ClipboardItemAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var copyPastDB: CopyPastDB
    @Inject
    lateinit var clipBoardItemDao: ClipBoardItemDao
    @Inject
    lateinit var copyPastRepository: CopyPastRepository

    lateinit var tvCpStartMainText: TextView
    lateinit var tvCpStartSubText: TextView

    private lateinit var tvCpCounterMainText: TextView
    private lateinit var tvCpCounterSubText: TextView

    private lateinit var tvCpPermissionMainText: TextView
    private lateinit var tvCpPermissionSubText: TextView

    private lateinit var rvClipBoardItems: RecyclerView
    private lateinit var clipBoardItemAdapter: ClipboardItemAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as CopyPastApplication).applicationComponent.inject(this)
        initViews()
        setViewText()
        setClipBoardItemRecyclerView()
    }

    private fun initViews() {
        val includedStartCp = findViewById<LinearLayout>(R.id.included_starting_cp)
        tvCpStartMainText = includedStartCp.findViewById(R.id.tv_main_text)
        tvCpStartSubText = includedStartCp.findViewById(R.id.tv_sub_text)

        val includedCounterCp = findViewById<LinearLayout>(R.id.included_counter_cp)
        tvCpCounterMainText = includedCounterCp.findViewById(R.id.tv_main_text)
        tvCpCounterSubText = includedCounterCp.findViewById(R.id.tv_sub_text)

        val includedPermissionCp = findViewById<LinearLayout>(R.id.included_permission_cp)
        tvCpPermissionMainText = includedPermissionCp.findViewById(R.id.tv_main_text)
        tvCpPermissionSubText = includedPermissionCp.findViewById(R.id.tv_sub_text)

        rvClipBoardItems = findViewById(R.id.rv_copied_txt_items)
    }

    private fun setViewText() {
        tvCpStartMainText.text = getString(R.string.start_copypast)
        tvCpStartSubText.text = getString(R.string.start_copypast_sub)

        tvCpCounterMainText.text = getString(R.string.counter_copypast)
        tvCpCounterSubText.text = getString(R.string.counter_copypast_sub)

        tvCpPermissionMainText.text = getString(R.string.permission_copypast)
        tvCpPermissionSubText.text = getString(R.string.permission_copypast_sub_off)
    }

    private fun setClipBoardItemRecyclerView() {
        clipBoardItemAdapter = ClipboardItemAdapter()
        rvClipBoardItems.layoutManager = LinearLayoutManager(this)
        rvClipBoardItems.adapter = clipBoardItemAdapter
    }
}

// TODO: Add A service to launch a floating view, Persmission to launch a Floating View, RecylerView to hold the clipboards, Ask user for count to show in the list of copied list. 
// TODO: Have a layout for Permission to ask to start and stop, Permission. 