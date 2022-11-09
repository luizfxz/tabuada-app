package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    /* Funcionais na tela do aplicativo */

    EditText input_user;

    Button calcular;

    TextView resultado;

    TextView resultado_text;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Pegando os valores do utilizarios na tela */

        input_user = (EditText)findViewById(R.id.input_user);

        calcular = (Button)findViewById(R.id.calcular);

        resultado = (TextView)findViewById(R.id.resultado);

        resultado_text = (TextView)findViewById(R.id.resultado_text);

        calcular.setOnClickListener(this);
    }
    /* Função para botão "calcular" quando for clicado */

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.calcular:

                /* Uma classe de string que armazena uma grande quantidade de caracteres "Buffer" */

                StringBuffer buffer = new StringBuffer();

                /* Pegando o valor que foi digitado e transformando em String*/

                String fs = input_user.getText().toString();

                /* Condição utilizando uma função para validar os campos */

                if (validarCampo(fs)) {

                    /* Pega o valor que foi passado pela string fs e transforma ela em inteiro */

                    int n = Integer.parseInt(fs);

                    /* Laço de repetição da multiplicação */

                    for (int i = 1; i <= 10; i++) {

                        /* Variavel para o resultado no laço de repetição */

                        int ans = 0;

                        /* Resultado da multiplicação */

                        ans = (i * n);

                        /* Resultado do laço de repetição com o valor inserido, por qual foi multiplicado e seu resultado */

                        buffer.append(n + " X " + i + " = " + ans + "\n\n");

                    }

                    /* Setando o resultado na tela */

                    resultado.setText(buffer);

                    /* Seta na tela o texto resultado */

                    resultado_text.setText("Resultados:");

                    /* Quebra do laço */

                    break;

                } else {

                    /* Condição caso o usuário não digite valor nenhum */

                    resultado_text.setText("Insira um valor!");

                    resultado.setText("");

                    break;
                }
            }
        }

    /* Função para validar os campos */

    public Boolean validarCampo (String inputUser) {
        if (inputUser == null || inputUser.equals("")) {
            return false;
        }
        else {
            return true;
        }
    }

}