package com.softsuave.emoji_tester

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.softsuave.emoji_tester.ui.DrawEmojiActivity
import com.softsuave.emoji_tester.ui.adapter.OnItemClickListener

class CallGetEmoji(private val activity: AppCompatActivity) {
    private lateinit var listener: OnItemClickListener


    fun setListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun startActivityForEmoji(launcher: ActivityResultLauncher<Intent>) {
        val intent = Intent(activity, DrawEmojiActivity::class.java)
        launcher.launch(intent)
    }

    fun handleActivityResult(selectedEmoji: String) {
        listener.onItemClick(selectedEmoji)
    }

}