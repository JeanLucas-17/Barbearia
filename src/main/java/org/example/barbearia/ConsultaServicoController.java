package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConsultaServicoController extends Principal
{
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNome;
    @FXML private TextField txtPreco;
    @FXML private TextField txtDuracao;

    @FXML public void buscar()
    {
        String codigo = txtCodigo.getText();

        if (codigo.isEmpty())
        {
            alertW.setTitle("CONSULTA SERVICO");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha o campo de codigo!");
            alertW.showAndWait();

            return;
        }

        boolean encontrado = false;

        limparCampos();

        for (String[] servico : serv)
        {
            if (servico[0].equals(codigo))
            {
                txtCodigo.setText(servico[0]);
                txtNome.setText(servico[1]);
                txtPreco.setText(servico[2]);
                txtDuracao.setText(servico[3]);

                encontrado = true;

                break;
            }
        }

        if (!encontrado)
        {
            alertW.setTitle("CONSULTA SERVICO");
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
        txtPreco.clear();
        txtDuracao.clear();
    }

    @FXML public void voltar(ActionEvent event){nav(event, "/TelaServico/TelaOpcoesServico.fxml");}
}
