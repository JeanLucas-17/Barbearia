package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AlterarProfissionalController extends Principal
{
    @FXML private TextField txtCodigo;
    @FXML private TextField txtAtualNome;
    @FXML private TextField txtAtualIdade;
    @FXML private TextField txtAtualTelefone;
    @FXML private TextField txtAtualEndereco;
    @FXML private TextField txtAtualCpf;

    @FXML private TextField txtNovoCodigo;
    @FXML private TextField txtNovoNome;
    @FXML private TextField txtNovoIdade;
    @FXML private TextField txtNovoTelefone;
    @FXML private TextField txtNovoEndereco;
    @FXML private TextField txtNovoCpf;

    int i;

    @FXML public void nSalvar()
    {
        limparCampos();
    }

    @FXML public void salvar()
    {
        String codigo = txtCodigo.getText().trim();
        String nome = txtNovoNome.getText().trim();
        String idade = txtNovoIdade.getText().trim();
        String telefone = txtNovoTelefone.getText().trim();
        String endereco = txtNovoEndereco.getText().trim();
        String cpf = txtNovoCpf.getText().trim();

        String novosDados[] = {codigo, nome, idade, telefone, endereco, cpf};

        if (codigo.isEmpty() || nome.isEmpty() || idade.isEmpty() ||
                telefone.isEmpty() || endereco.isEmpty() || cpf.isEmpty())
        {
            alertW.setTitle("ALTERAR PROFISSIONAL");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha todos os campos!");
            alertW.showAndWait();

            return;
        }

        prof.remove(i);
        prof.add(novosDados);

        alertI.setTitle("ALTERAR PROFISSIONAL");
        alertI.setHeaderText(null);
        alertI.setContentText("Dados do Profissional Alterados!");
        alertI.showAndWait();

        limparCampos();
    }

    @FXML public void buscar()
    {
        String codigo = txtCodigo.getText();
        i = 0;

        if (codigo.isEmpty())
        {
            alertW.setTitle("ALTERAR PROFISSIONAL");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha o campo de codigo!");
            alertW.showAndWait();

            return;
        }

        boolean encontrado = false;

        limparCampos();

        for (String[] profissional : prof)
        {
            if (profissional[0].equals(codigo))
            {
                txtCodigo.setText(profissional[0]);
                txtAtualNome.setText(profissional[1]);
                txtAtualIdade.setText(profissional[2]);
                txtAtualTelefone.setText(profissional[3]);
                txtAtualEndereco.setText(profissional[4]);
                txtAtualCpf.setText(profissional[5]);

                txtNovoCodigo.setText(profissional[0]);
                txtNovoNome.setText(profissional[1]);
                txtNovoIdade.setText(profissional[2]);
                txtNovoTelefone.setText(profissional[3]);
                txtNovoEndereco.setText(profissional[4]);
                txtNovoCpf.setText(profissional[5]);

                encontrado = true;

                break;
            }
            i++;
        }

        if (!encontrado)
        {
            alertW.setTitle("ALTERAR PROFISSIONAL");
            alertW.setHeaderText(null);
            alertW.setContentText("Codigo nao existe!");
            alertW.showAndWait();
        }
    }

    @Override
    public void limparCampos()
    {
        txtCodigo.clear();
        txtAtualNome.clear();
        txtAtualIdade.clear();
        txtAtualTelefone.clear();
        txtAtualEndereco.clear();
        txtAtualCpf.clear();

        txtNovoCodigo.clear();
        txtNovoNome.clear();
        txtNovoIdade.clear();
        txtNovoTelefone.clear();
        txtNovoEndereco.clear();
        txtNovoCpf.clear();
    }

    @FXML public void voltar(ActionEvent event){nav(event, "/TelaProfissional/TelaOpcoesProfissional.fxml");}
}
