package com.softsuave.emoji_tester.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsuave.emoji_tester.MyApplication
import com.softsuave.emoji_tester.databinding.DrawEmojiActivityBinding
import io.reactivex.disposables.CompositeDisposable
import com.softsuave.emoji_tester.ui.adapter.EmojiDetectedAdapter
import com.softsuave.emoji_tester.util.GetEmojiItemClickListener
import timber.log.Timber
import javax.inject.Inject

class DrawEmojiActivity : AppCompatActivity(), EmojiDrawContract.View, GetEmojiItemClickListener {

    @Inject
    lateinit var presenter: EmojiDrawContract.Presenter
    private var _binding: DrawEmojiActivityBinding? = null
    private val binding by lazy { _binding!! }
    private val disposables = CompositeDisposable()
    private val REQUEST_EMOJI_ICON_CODE = 1234

    private lateinit var adapter: EmojiDetectedAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DrawEmojiActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyApplication.getComponent(this)
            .plusDrawEmojiComponent()
            .inject(this)

        binding.emojiDetectedRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = EmojiDetectedAdapter(this)
        binding.emojiDetectedRecycler.adapter = adapter

        presenter.bindView(this)
        binding.drawingView.strokesObservable
            ?.subscribe { presenter.onStrokeAdded(it) }?.let { disposables.add(it) }
        disposables.add(binding.drawingView.skipObservable
            .subscribe { presenter.onSkip() })
        adapter.setOnItemClickListener(this)
    }

    override fun onGuessesReturned(strings: List<String>) {
        binding.emojiDetectedContainer.visibility = View.VISIBLE
        adapter.detectedList = strings
    }

    override fun setEmojiToDraw(emoji: String, emojiDescription: String) {
        adapter.emojiToDraw = emoji
    }

    override fun onEmojiDrawnCorrectly(emoji: String) {
        binding.emojiDetectedContainer.visibility = View.INVISIBLE
        adapter.detectedList = emptyList()
        binding.drawingView.clear()
    }

    override fun onAllEmojisDrawn() {
        Timber.d("onAllEmojisDrawn")
    }

    override fun onAllEmojisDrawnWithCheat() {
        Timber.d("onAllEmojisDrawnWithCheat")
    }

    override fun onTimeOut() {
        Timber.d("OnTimeout")
    }

    override fun showErrorMessage() {
        Timber.d("\uD83D\uDE1E Check your internet connection \uD83D\uDCF6")
       // Toast.makeText(this, R.string.network_error, Toast.LENGTH_SHORT).show()
    }

    override fun getEmojiItemClick(emoji: String) {
        Timber.d("Emoji String ====> %s", emoji)
        val returnIntent = Intent()
        returnIntent.putExtra("selectedEmoji", emoji)
        setResult(REQUEST_EMOJI_ICON_CODE, returnIntent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
