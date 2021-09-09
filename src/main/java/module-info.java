module com.qlqts.quanlyquantrasua {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    
    opens com.qlqts.quanlyquantrasua to javafx.fxml;
    exports com.qlqts.quanlyquantrasua;
    //exports com.qlqts.quanlyquantrasua.pojo;
}
