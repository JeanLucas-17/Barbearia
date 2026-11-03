package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AlterarServicoController extends Principal
{
    @FXML private TextField txtCodigo;
    @FXML private TextField txtAtualNome;
    @FXML private TextField txtAtualPreco;
    @FXML private TextField txtAtualDuracao;

    @FXML private TextField txtNovoCodigo;
    @FXML private TextField txtNovoNome;
    @FXML private TextField txtNovoPreco;
    @FXML private TextField txtNovaDuracao;

    int i;

    @FXML public void nSalvar()
    {
        limparCampos();
    }

    @FXML public void salvar()
    {
        String codigo = txtCodigo.getText().trim();
        String nome = txtNovoNome.getText().trim();
        String preco = txtNovoPreco.getText().trim();
        String duracao = txtNovaDuracao.getText().trim();

        String novosDados[] = {codigo, nome, preco, duracao};

        if (codigo.isEmpty() || nome.isEmpty() || preco.isEmpty() ||
                duracao.isEmpty())
        {
            alertW.setTitle("ALTERAR SERVICO");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha todos os campos!");
            alertW.showAndWait();

            return;
        }

        serv.remove(i);
        serv.add(novosDados);
        alertI.setTitle("ALTERAR SERVICO");
        alertI.setHeaderText(null);
        alertI.setContentText("Dados do Servico Alterados!");
        alertI.showAndWait();

        limparCampos();
    }

    @FXML public void buscar()
    {
        String codigo = txtCodigo.getText();
        i = 0;

        if (codigo.isEmpty())
        {
            alertW.setTitle("ALTERAR SERVICO");
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
                txtAtualNome.setText(servico[1]);
                txtAtualPreco.setText(servico[2]);
                txtAtualDuracao.setText(servico[3]);

                txtNovoCodigo.setText(servico[0]);
                txtNovoNome.setText(servico[1]);
                txtNovoPreco.setText(servico[2]);
                txtNovaDuracao.setText(servico[3]);

                encontrado = true;

                break;
            }
            i++;
        }

        if (!encontrado)
        {
            alertW.setTitle("ALTERAR SERVICO");
            alertW.setHeaderText(null);
            alertW.setContentText("Codigo nao existe!");
            alertW.showAndWait();
        }
    }

    @FXML public void voltar(ActionEvent event){nav(event, "/TelaServico/TelaOpcoesServico.fxml");}

    @Override
    public void limparCampos()
    {
        txtCodigo.clear();
        txtAtualNome.clear();
        txtAtualPreco.clear();
        txtAtualDuracao.clear();

        txtNovoCodigo.clear();
        txtNovoNome.clear();
        txtNovoPreco.clear();
        txtNovaDuracao.clear();
    }
}
