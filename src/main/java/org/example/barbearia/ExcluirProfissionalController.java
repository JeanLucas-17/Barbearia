package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ExcluirProfissionalController extends Principal
{
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtCpf;

    int i;

    @FXML public void excluir()
    {
        String cod = txtCodigo.getText().trim();

        if (cod.isEmpty())
        {
            alertW.setTitle("EXCLUIR PROFISSIONAL");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha o campo de codigo!");
            alertW.showAndWait();
            return;
        }

        prof.remove(i);

        alertI.setTitle("EXCLUIR PROFISSIONAL");
        alertI.setHeaderText(null);
        alertI.setContentText("Dados do Profissional Excluidos!");
        alertI.showAndWait();

        limparCampos();
    }

    @FXML public void nExcluir() { limparCampos(); }

    @FXML public void buscar(ActionEvent event)
    {
        i = 0;
        String codigo = txtCodigo.getText();

        if (codigo.isEmpty())
        {
            alertW.setTitle("EXCLUIR PROFISSIONAL");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha o campo de codigo!");
            alertW.showAndWait();
            return;
        }

        boolean encontrado = false;
        limparCampos();

        for (Profissional profissional : prof)
        {
            if (profissional.getCodigo().equals(codigo))
            {
                txtCodigo.setText(profissional.getCodigo());
                txtNome.setText(profissional.getNome());
                txtIdade.setText(profissional.getIdade());
                txtTelefone.setText(profissional.getTelefone());
                txtEndereco.setText(profissional.getEndereco());
                txtCpf.setText(profissional.getCpf());

                encontrado = true;
                break;
            }
            i++;
        }

        if (!encontrado)
        {
            alertW.setTitle("EXCLUIR PROFISSIONAL");
            alertW.setHeaderText(null);
            alertW.setContentText("Codigo nao existe!");
            alertW.showAndWait();
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