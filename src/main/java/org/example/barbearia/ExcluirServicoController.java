package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ExcluirServicoController extends Principal
{
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNome;
    @FXML private TextField txtPreco;
    @FXML private TextField txtDuracao;

    int i;

    @FXML public void excluir()
    {
        String codigo = txtCodigo.getText().trim();

        if (codigo.isEmpty())
        {
            alertW.setTitle("EXCLUIR SERVICO");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha o campo de codigo!");
            alertW.showAndWait();
            return;
        }

        serv.remove(i);

        alertI.setTitle("EXCLUIR SERVICO");
        alertI.setHeaderText(null);
        alertI.setContentText("Dados do Servico Excluidos!");
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
            alertW.setTitle("EXCLUIR SERVICO");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha o campo de codigo!");
            alertW.showAndWait();
            return;
        }

        boolean encontrado = false;
        limparCampos();

        for (Servico servico : serv)
        {
            if (servico.getCodigo().equals(codigo))
            {
                txtCodigo.setText(servico.getCodigo());
                txtNome.setText(servico.getNome());
                txtPreco.setText(servico.getPreco());
                txtDuracao.setText(servico.getDuracao());

                encontrado = true;
                break;
            }
            i++;
        }

        if (!encontrado)
        {
            alertW.setTitle("EXCLUIR SERVICO");
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