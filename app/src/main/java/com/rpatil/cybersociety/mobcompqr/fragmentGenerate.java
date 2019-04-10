package com.rpatil.cybersociety.mobcompqr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.HashMap;

public class fragmentGenerate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_generate);

        findViewById(R.id.qrgenerate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> genHis = new HashMap<>();

                genHis.put("timestamp", new Date().toString());
                genHis.put("Payload", ((EditText)findViewById(R.id.qrtext)).getText().toString());

                final String URL = "https://api.qrserver.com/v1/create-qr-code/?size=400x400&data=" + ((EditText)findViewById(R.id.qrtext)).getText().toString();
                Picasso.get().load(URL).into((ImageView)findViewById(R.id.qrimage));

            }
        });

    }
}
