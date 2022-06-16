module fr.afpa {
    requires javafx.controls;
    requires javafx.fxml;
    
    exports fr.afpa.main;
    opens fr.afpa.main to javafx.fxml;
    exports fr.afpa.utils;
    opens fr.afpa.utils to javafx.fxml;

}