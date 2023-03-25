package com.example.wordsample

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewWordActivity:AppCompatActivity() {

    private lateinit var editWordView: EditText
    val replyIntent = Intent()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_new_word)
        editWordView = findViewById(R.id.edit_word)

        val btnSave = findViewById<Button>(R.id.button_save)
        val btnGo = findViewById<Button>(R.id.buttonGo)
        btnSave.setOnClickListener {
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
        }

        btnGo.setOnClickListener {
            setResult(Activity.RESULT_OK,replyIntent)
            finish()
        }


    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

}