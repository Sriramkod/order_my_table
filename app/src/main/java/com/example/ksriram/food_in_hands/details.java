package com.example.ksriram.food_in_hands;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class details extends AppCompatActivity {

    private WebView webView;
    ProgressBar progressBar;
    Button button2;
    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (haveNetwork()) {

            webView = (WebView) findViewById(R.id.webView);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://learnfriendly.000webhostapp.com/dashb.html");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    progressBar.setVisibility(View.VISIBLE);
                    // setTitle("Please Wait...");
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    progressBar.setVisibility(View.GONE);
                    //setTitle(view.getTitle());
                    super.onPageFinished(view, url);
                }
            });
            Button btnReturn1 = (Button) findViewById(R.id.back);
            btnReturn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(details.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else if(!haveNetwork()) {
            Toast.makeText(details.this,"No internet",Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(details.this);
            builder.setMessage("Please check your internet connection,Click 'ok' to continue..")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setNegativeButton("",null);
            AlertDialog alert = builder.create();
            alert.show();
            Button btnReturn1 = (Button) findViewById(R.id.back);
            btnReturn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(details.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            });

        }
    }

private boolean haveNetwork(){

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
