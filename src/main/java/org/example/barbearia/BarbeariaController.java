package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BarbeariaController extends Principal
{
    @FXML public void botaoProf(ActionEvent event){nav(event, "/TelaProfissional/TelaOpcoesProfissional.fxml");}

    @FXML public void botaoServ(ActionEvent event){nav(event, "/TelaServico/TelaOpcoesServico.fxml");}
}
