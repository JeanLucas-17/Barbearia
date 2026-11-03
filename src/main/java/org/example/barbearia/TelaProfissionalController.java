package org.example.barbearia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaProfissionalController extends Principal
{
    @FXML public void voltar(ActionEvent event){nav(event, "/Barbearia/Barbearia.fxml");}
    @FXML public void cadProf(ActionEvent event){nav(event, "/TelaProfissional/CadastroProfissional.fxml");}
    @FXML public void conProf(ActionEvent event){nav(event, "/TelaProfissional/ConsultaProfissional.fxml");}
    @FXML public void excProf(ActionEvent event){nav(event, "/TelaProfissional/ExcluirProfissional.fxml");}
    @FXML public void altProf(ActionEvent event){nav(event, "/TelaProfissional/AlterarProfissional.fxml");}
}
