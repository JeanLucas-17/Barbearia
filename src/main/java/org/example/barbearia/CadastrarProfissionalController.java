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

        boolean encontrado = false;

        for (Profissional profissional : prof)
        {
            if (profissional.getCodigo().equals(codigo))
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
            Profissional novoProf = new Profissional();
            novoProf.setCodigo(codigo);
            novoProf.setNome(nome);
            novoProf.setIdade(idade);
            novoProf.setTelefone(telefone);
            novoProf.setEndereco(endereco);
            novoProf.setCpf(cpf);

            prof.add(novoProf);

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