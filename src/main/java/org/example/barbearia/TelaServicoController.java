package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaServicoController extends Principal
{
    @FXML public void voltar(ActionEvent event){nav(event, "/Barbearia/Barbearia.fxml");}
    @FXML public void cadServ(ActionEvent event){nav(event, "/TelaServico/CadastroServico.fxml");}
    @FXML public void conServ(ActionEvent event){nav(event, "/TelaServico/ConsultaServico.fxml");}
    @FXML public void excServ(ActionEvent event){nav(event, "/TelaServico/ExcluirServico.fxml");}
    @FXML public void altServ(ActionEvent event){nav(event, "/TelaServico/AlterarServico.fxml");}
}
