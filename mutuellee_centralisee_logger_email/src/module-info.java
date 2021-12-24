module mutuellee_centralisee_logger_email {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	requires jbcrypt;
	requires junit;
	requires json.parser;
	requires log4j;
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics , javafx.fxml;
	opens model to javafx.graphics , javafx.fxml , javafx.base;
}