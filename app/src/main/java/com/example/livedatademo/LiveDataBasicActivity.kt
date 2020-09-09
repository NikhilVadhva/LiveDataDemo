package com.example.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedatademo.viewmodel.BasicViewModel
import kotlinx.android.synthetic.main.activity_live_data_basic.*

class LiveDataBasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_basic)

        val viewModel = ViewModelProvider(this).get(BasicViewModel::class.java)

        viewModel.seconds().observe(this, Observer {
            txtCounter.text = it.toString()
        })

        viewModel._finished.observe(this, Observer {
            if (it)
                Toast.makeText(this, "Finished !!", Toast.LENGTH_SHORT).show()
        })

        btStart.setOnClickListener{
            viewModel.startTimer()
        }
        btStop.setOnClickListener{
            viewModel.stopTimer()
            txtCounter.text = getString(R.string.value)
        }

    }
}