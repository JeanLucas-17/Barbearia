module org.example.barbearia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.barbearia to javafx.fxml;
    exports org.example.barbearia;
}