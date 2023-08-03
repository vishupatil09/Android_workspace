package com.example.texttableview

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout
    private lateinit var btnAddRow: Button
    private var rowCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tableLayout = findViewById(R.id.tableLayout)
        btnAddRow = findViewById(R.id.btnAddRow)

        btnAddRow.setOnClickListener {
            addTableRow()
        }
    }

    private fun addTableRow() {
        val row = TableRow(this)
        val layoutParams = TableLayout.LayoutParams(
            TableLayout.LayoutParams.MATCH_PARENT,
            TableLayout.LayoutParams.WRAP_CONTENT
        )
        row.layoutParams = layoutParams
        row.gravity = Gravity.CENTER_VERTICAL

        val textView = TextView(this)
        textView.text = "TextView!! ${++rowCount}"
        val textViewLayoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        textViewLayoutParams.marginStart = 16.dpToPx()
        textView.layoutParams = textViewLayoutParams

        row.addView(textView)
        tableLayout.addView(row)
    }

    private fun Int.dpToPx(): Int {
        return (this * resources.displayMetrics.density).toInt()
    }
}
