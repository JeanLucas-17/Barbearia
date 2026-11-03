package org.example.barbearia;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Principal
{
    Alert alertW = new Alert(Alert.AlertType.WARNING);
    Alert alertI = new Alert(Alert.AlertType.INFORMATION);

    protected static List<Profissional> prof = new ArrayList<>();
    protected static List<Servico> serv = new ArrayList<>();

    public void limparCampos() {}

    public void nav(ActionEvent event, String fxmlTela)
    {
        try
        {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource(fxmlTela));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        }
        catch (IOException e)
        {
            System.err.println("Erro ao carregar a tela: " + fxmlTela);
            e.printStackTrace();
        }
    }
}