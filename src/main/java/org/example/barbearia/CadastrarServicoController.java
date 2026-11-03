package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastrarServicoController extends Principal
{
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNome;
    @FXML private TextField txtDuracao;
    @FXML private TextField txtPreco;

    @FXML public void salvar()
    {
        String codigo = txtCodigo.getText().trim();
        String nome = txtNome.getText().trim();
        String duracao = txtDuracao.getText().trim();
        String preco = txtPreco.getText().trim();

        if (codigo.isEmpty() || nome.isEmpty() || duracao.isEmpty() ||
                preco.isEmpty())
        {
            alertW.setTitle("CADASTRO SERVICO");
            alertW.setHeaderText(null);
            alertW.setContentText("Por favor, preencha todos os campos!");
            alertW.showAndWait();

            return;
        }

        String codigoDigitado = txtCodigo.getText();

        boolean encontrado = false;

        for (String[] servico : serv)
        {
            String cod = servico[0];

            if (cod.equals(codigoDigitado))
            {
                alertW.setTitle("CADASTRO SERVICO");
                alertW.setHeaderText(null);
                alertW.setContentText("Codigo Ja existe!");
                alertW.showAndWait();

                encontrado = true;

                break;
            }
        }

        if (!encontrado)
        {
            String[] dados = new String[] {codigo, nome, preco, duracao};

            serv.add(dados);

            alertI.setTitle("CADASTRO SERVICO");
            alertI.setHeaderText(null);
            alertI.setContentText("Servico Cadastrado!");
            alertI.showAndWait();
            limparCampos();
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
