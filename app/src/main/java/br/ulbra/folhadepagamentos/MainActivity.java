package br.ulbra.folhadepagamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtSalario, edtFilhos;

    RadioGroup rgSexo;
    RadioButton rbMasculino, rbFeminino;

    Button btnCalcular;

    TextView txtFuncionario;
    TextView txtINSS;
    TextView txtIR;
    TextView txtSalarioFamilia;
    TextView txtLiquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtSalario = findViewById(R.id.edtSalario);
        edtFilhos = findViewById(R.id.edtFilhos);

        rgSexo = findViewById(R.id.rgSexo);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFeminino = findViewById(R.id.rbFeminino);

        btnCalcular = findViewById(R.id.btnCalcular);

        txtFuncionario = findViewById(R.id.txtFuncionario);
        txtINSS = findViewById(R.id.txtINSS);
        txtIR = findViewById(R.id.txtIR);
        txtSalarioFamilia = findViewById(R.id.txtSalarioFamilia);
        txtLiquido = findViewById(R.id.txtLiquido);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcularFolha();

            }
        });


    }
    private void calcularFolha(){

        try {

            String nome = edtNome.getText().toString();

            if(nome.isEmpty()){
                Toast.makeText(this,
                        "Digite o nome do funcionário!", Toast.LENGTH_LONG).show();
                return;
            }

            double salario = Double.parseDouble(edtSalario.getText().toString());

            int filhos = Integer.parseInt(edtFilhos.getText().toString());

            if(salario < 0){
                Toast.makeText(this, "Salário inválido!", Toast.LENGTH_LONG).show();
                return;
            }

            if(filhos < 0){
                Toast.makeText(this, "Número de filhos inválido!", Toast.LENGTH_LONG).show();
                return;
            }
            double inss = 0;

            if(salario <= 1212.00){

                inss = salario * 0.075;

            }else if(salario <= 2427.35){

                inss = salario * 0.09;

            }else if(salario <= 3641.03){

                inss = salario * 0.12;

            }else{

                inss = salario * 0.14;
            }

            double ir = 0;

            if(salario <= 1903.98){

                ir = 0;

            }else if(salario <= 2826.65){

                ir = salario * 0.075;

            }else if(salario <= 3751.05){

                ir = salario * 0.15;

            }else if(salario <= 4664.68){

                ir = salario * 0.225;

            }else{

                ir = salario * 0.275;
            }

            double salarioFamilia = 0;

            if(salario <= 1212.00){

                salarioFamilia = filhos * 56.47;

            }
            double salarioLiquido;

            salarioLiquido = salario - (inss + ir)
                    + salarioFamilia;

            String tratamento;

            if(rbMasculino.isChecked()){

                tratamento = "Sr.";

            }else{

                tratamento = "Sra.";
            }

            txtFuncionario.setText(tratamento + " " + nome);

            txtINSS.setText(String.format("INSS R$ %.2f", inss));

            txtIR.setText(String.format("IR R$ %.2f", ir));

            txtSalarioFamilia.setText(String.format("Salário Família R$ %.2f", salarioFamilia));

            txtLiquido.setText(String.format("Salário Líquido R$ %.2f", salarioLiquido));

            txtLiquido.setTextColor(Color.parseColor("#0D47A1"));

        }catch (Exception e){

            Toast.makeText(this,
                    "Preencha todos os campos corretamente!",
                    Toast.LENGTH_LONG).show();

        }

    }

    }
