package com.swapnil.copypast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.swapnil.copypast.CopyPastApplication
import com.swapnil.copypast.R
import com.swapnil.copypast.repository.CopyPastDB
import com.swapnil.copypast.repository.CopyPastRepository
import com.swapnil.copypast.repository.dao.ClipBoardItemDao
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

    lateinit var tvCpCounterMainText: TextView
    lateinit var tvCpCounterSubText: TextView

    lateinit var tvCpPermissionMainText: TextView
    lateinit var tvCpPermissionSubText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as CopyPastApplication).applicationComponent.inject(this)
        initViews()
        setViewText()
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
    }

    private fun setViewText() {
        tvCpStartMainText.text = getString(R.string.start_copypast)
        tvCpStartSubText.text = getString(R.string.start_copypast_sub)

        tvCpCounterMainText.text = getString(R.string.counter_copypast)
        tvCpCounterSubText.text = getString(R.string.counter_copypast_sub)

        tvCpPermissionMainText.text = getString(R.string.permission_copypast)
        tvCpPermissionSubText.text = getString(R.string.permission_copypast_sub_off)
    }
}

// TODO: Add A service to launch a floating view, Persmission to launch a Floating View, RecylerView to hold the clipboards, Ask user for count to show in the list of copied list. 
// TODO: Have a layout for Permission to ask to start and stop, Permission. 