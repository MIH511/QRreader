package com.example.qrreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;


import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity{

    private ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readqr(View view) {

        zXingScannerView= new ZXingScannerView(this);
        zXingScannerView.setResultHandler(new setResultHolder());
        setContentView(zXingScannerView);
        zXingScannerView.startCamera();
    }

    @Override
    public void onPause() {

        super.onPause();
        zXingScannerView.stopCamera();
    }
    class setResultHolder implements ZXingScannerView.ResultHandler {

        @Override
        public void handleResult(Result result) {

            String tx=result.getText();
            Toast.makeText(MainActivity.this,tx,Toast.LENGTH_LONG).show();
            setContentView(R.layout.activity_main);
            zXingScannerView.stopCamera();
        }
    }
}

