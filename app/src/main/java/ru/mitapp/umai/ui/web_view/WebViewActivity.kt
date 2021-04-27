package ru.mitapp.umai.ui.web_view

import android.app.Activity
import android.content.Intent
import android.net.http.SslError
import android.view.KeyEvent
import android.view.MenuItem
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityWebViewBinding

class WebViewActivity : BaseActivity<ActivityWebViewBinding>(R.layout.activity_web_view) {

    private val url : String?
    get() = intent.getStringExtra("url")
    private val titleText : String?
    get() = intent.getStringExtra("title")
    lateinit var toolbar: Toolbar


    companion object{
        fun start(activity : Activity, url : String, title : String){
            val intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra("url", url)
            intent.putExtra("title", title)
            activity.startActivity(intent)
        }
    }

    override fun setupView() {
        toolbar = findViewById(R.id.toolbarPartners)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = titleText

        binding!!.webView.settings.javaScriptEnabled = true
        binding!!.webView.settings.loadWithOverviewMode = true
        binding!!.webView.settings.useWideViewPort = true
        binding!!.webView.settings.domStorageEnabled = true
        /*bindi!!ng.webView.settings.builtInZoomControls = true*/


        binding!!.webView.webViewClient = object : WebViewClient() {
            override
            fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed()
            }
        }

        binding!!.webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(
                view: WebView,
                newProgress: Int
            ) {
                super.onProgressChanged(view, newProgress)
                binding!!.progress.progress = newProgress
                if (newProgress < 100 && binding!!.progress.visibility == ProgressBar.GONE) {
                    binding!!.progress.visibility = ProgressBar.VISIBLE
                }
                if (newProgress == 100) {
                    binding!!.progress.visibility = ProgressBar.GONE
                }
            }
        }

        url?.let { binding!!.webView.loadUrl(it) }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)
//
//    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK && binding!!.webView.canGoBack()) {
            binding!!.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            onBackPressed()
        return true
    }


}