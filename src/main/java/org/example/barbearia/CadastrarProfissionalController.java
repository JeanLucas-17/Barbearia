package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastrarProfissionalController extends Principal
{
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtCpf;

    @FXML public void salvar()
    {
        String codigo = txtCodigo.getText().trim();
        String nome = txtNome.getText().trim();
        String idade = txtIdade.getText().trim();
        String telefone = txtTelefone.getText().trim();
        String endereco = txtEndereco.getText().trim();
        String cpf = txtCpf.getText().trim();

        if (codigo.isEmpty() || nome.isEmpty() || idade.isEmpty() ||
                telefone.isEmpty() || endereco.isEmpty() || cpf.isEmpty())
        {
            alertW.setTitle("CADASTRO PROFISSIONAL");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha todos os campos!");
            alertW.showAndWait();

            return;
        }

        String codigoDigitado = txtCodigo.getText();

        boolean encontrado = false;

        for (String[] profissional : prof)
        {
            String cod = profissional[0];

            if (cod.equals(codigoDigitado))
            {
                alertW.setTitle("CADASTRO PROFISSIONAL");
                alertW.setHeaderText(null);
                alertW.setContentText("Codigo Ja existe!");
                alertW.showAndWait();

                encontrado = true;

                break;
            }
        }

        if (!encontrado)
        {
            String[] dados = new String[] {codigo, nome, idade, telefone, endereco, cpf};

            prof.add(dados);

            alertI.setTitle("CADASTRO PROFISSIONAL");
            alertI.setHeaderText(null);
            alertI.setContentText("Profissional Cadastrado!");
            alertI.showAndWait();

            limparCampos();
        }
    }

    @Override
    public void limparCampos()
    {
        txtCodigo.clear();
        txtNome.clear();
        txtIdade.clear();
        txtTelefone.clear();
        txtEndereco.clear();
        txtCpf.clear();
    }

    @FXML public void voltar(ActionEvent event){nav(event, "/TelaProfissional/TelaOpcoesProfissional.fxml");}
}
