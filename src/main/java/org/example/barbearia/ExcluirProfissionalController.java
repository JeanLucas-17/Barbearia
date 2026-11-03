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

    @FXML public void nExcluir()
    {
        limparCampos();
    }

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

        for (String[] profissional : prof)
        {
            if (profissional[0].equals(codigo))
            {
                txtCodigo.setText(profissional[0]);
                txtNome.setText(profissional[1]);
                txtIdade.setText(profissional[2]);
                txtTelefone.setText(profissional[3]);
                txtEndereco.setText(profissional[4]);
                txtCpf.setText(profissional[5]);

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
