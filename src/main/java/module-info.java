module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    //requires org.hibernate.orm.core;
    requires java.naming;
    requires com.sun.xml.bind;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires com.fasterxml.jackson.core;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}