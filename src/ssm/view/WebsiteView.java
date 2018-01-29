package ssm.view;

import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Shen-Chieh Yen
 */
public class WebsiteView extends Application {
    private Scene scene;
    private String title;
    private int size;
    
    public WebsiteView(String t, int s) {
        title = t;
        size = s;
    }
    
    public void start() throws MalformedURLException{
        // create the scene
        Stage stage = new Stage();
        stage.setTitle("WebView");
        scene = new Scene(new Browser());
        stage.setScene(scene);
        stage.show();
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class Browser extends Region {
 
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
     
        public Browser() throws MalformedURLException {
            // load the web page
            webEngine.load(new File("webfiles/sites/" + title + "/index.html").toURI().toURL().toExternalForm());
            getChildren().add(browser);
        }
    }
}