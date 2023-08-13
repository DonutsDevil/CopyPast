package com.swapnil.copypast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.swapnil.copypast.CopyPastApplication
import com.swapnil.copypast.R
import com.swapnil.copypast.model.ClipBoardItem
import com.swapnil.copypast.repository.CopyPastDB
import com.swapnil.copypast.repository.CopyPastRepository
import com.swapnil.copypast.repository.roomDB.dao.ClipBoardItemDao
import com.swapnil.copypast.repository.roomDB.utils.ClipBoardItemWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var copyPastDB: CopyPastDB

    @Inject
    lateinit var clipBoardItemDao: ClipBoardItemDao

    @Inject
    lateinit var clipBoardItemWrapper: ClipBoardItemWrapper

    @Inject
    lateinit var copyPastRepository: CopyPastRepository

    private lateinit var addButton: Button
    private lateinit var getButton: Button

    private lateinit var text: TextView

    lateinit var scope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as CopyPastApplication).applicationComponent.inject(this)

        addButton = findViewById(R.id.btn_add)
        getButton = findViewById(R.id.btn_get)
        text = findViewById(R.id.txt_display)
        addButton.setOnClickListener(addButtonListener())
        getButton.setOnClickListener(getButtonListener())
        scope = CoroutineScope(Dispatchers.IO)
    }

    private fun addButtonListener() = View.OnClickListener {
        scope.launch {
            copyPastRepository.addClipBoardItem(ClipBoardItem())
        }
    }

    private fun getButtonListener() = View.OnClickListener {
        scope.launch {
            val list = copyPastRepository.getClipBoardListToBeShown()
            runOnUiThread {
                text.text = list.joinToString { x -> x.id.toString()  + " -- ${x.text} \n\n" }
            }
        }
    }
}

// TODO: Add A service to launch a floating view, Persmission to launch a Floating View, RecylerView to hold the clipboards, Ask user for count to show in the list of copied list. 
// TODO: Have a layout for Permission to ask to start and stop, Permission. 