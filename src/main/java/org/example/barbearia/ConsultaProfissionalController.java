package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConsultaProfissionalController extends Principal
{
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtCpf;

    @FXML public void buscar()
    {
        String codigo = txtCodigo.getText();

        if (codigo.isEmpty())
        {
            alertW.setTitle("CONSULTA PROFISSIONAL");
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
        }

        if (!encontrado)
        {
            alertW.setTitle("CONSULTA PROFISSIONAL");
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