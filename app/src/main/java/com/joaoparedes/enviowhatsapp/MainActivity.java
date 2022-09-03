package com.joaoparedes.enviowhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutMsg;
    private TextInputLayout inputLayoutTel;

    private TextInputEditText inputTextMsg;
    private TextInputEditText inputTextTel;

    private Button buttonEnviarMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutMsg = findViewById(R.id.edit_layout_msg);
        inputLayoutTel = findViewById(R.id.edit_layout_tel);
        inputTextMsg = findViewById(R.id.edit_msg);
        inputTextTel = findViewById(R.id.edit_tel);
        buttonEnviarMsg = findViewById(R.id.button_enviar_msg);

        buttonEnviarMsg.setOnClickListener(v -> {
           EnviaMensagem();
        });


    }

    private void EnviaMensagem() {

        String mensagem = inputTextMsg.getText().toString();
        String telefone = inputTextTel.getText().toString();

        if(mensagem.isEmpty()) {
            inputLayoutMsg.setError("Insira uma mensagem");
            return;
        }

//        if(telefone.isEmpty()) {
//            inputLayoutTel.setError("Insira um telefone");
//            return;
//        }

        String link = "https://wa.me/" + telefone + "?text=" + mensagem;

        Uri webpage = Uri.parse(link);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        startActivity(webIntent);

    }
}