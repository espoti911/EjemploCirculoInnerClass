module es.ieslosmontecillos.ejemplocirculoinnerclass {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.ejemplocirculoinnerclass to javafx.fxml;
    exports es.ieslosmontecillos.ejemplocirculoinnerclass;
}