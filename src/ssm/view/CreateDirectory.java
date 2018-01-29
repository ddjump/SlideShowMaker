/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssm.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javafx.collections.ObservableList;
import ssm.model.Slide;

/**
 *
 * @author Shen-Chieh Yen
 */
public class CreateDirectory {
    String title;
    int size;
    ObservableList<Slide> theSlides;
    
    public CreateDirectory(String t, int s, ObservableList<Slide> a) throws IOException {
        title = t;
        size = s;
        theSlides = a;
        
        String lineToTitle = "webfiles/sites/" + title; 
        
        File file = new File("webfiles/sites");
        if(!file.exists())
            file.mkdir();
        
        File fileTitle = new File(lineToTitle);
        if(!fileTitle.exists())
            fileTitle.mkdir();
        
        File cssFile = new File(lineToTitle + "/css");
        if(!cssFile.exists()) 
            cssFile.mkdir();
        
        File jsFile = new File(lineToTitle + "/js");
        if(!jsFile.exists())
            jsFile.mkdir();
        
        File imageFile = new File(lineToTitle + "/img");
        if(!imageFile.exists())
            imageFile.mkdir();
        
        Path insideDirectory = Paths.get(lineToTitle);
        Path cssDirectory = Paths.get(lineToTitle + "/css");
        Path jsDirectory = Paths.get(lineToTitle + "/js");
        Path imageDirectory = Paths.get(lineToTitle + "/img");
            
        Path pathToHtml = Paths.get("data/html/index.html");
        Path pathToCss = Paths.get("data/html/css/Slideshow.css");
        Path pathToJs = Paths.get("data/html/js/Slideshow.js");
        Path pathToJquery = Paths.get("data/html/js/jquery-1.11.3.js");
        Path pathToJSON = Paths.get("data/slide_shows/" + title + ".json");
        
        Path pathLArrow = Paths.get("data/html/img/arrow-left.png");
        Path pathRArrow = Paths.get("data/html/img/arrow-right.png");
        Path pathPlay = Paths.get("data/html/img/playbutton.png");
        Path pathPause = Paths.get("data/html/img/pausebutton.png");
        
        Path namePath = Paths.get("data/slide_shows/yen.json");
        
        Files.copy(pathToHtml, insideDirectory.resolve(pathToHtml.getFileName()),REPLACE_EXISTING);
        Files.copy(pathToCss, cssDirectory.resolve(pathToCss.getFileName()), REPLACE_EXISTING);
        Files.copy(pathToJs, jsDirectory.resolve(pathToJs.getFileName()),REPLACE_EXISTING);
        Files.copy(pathToJquery, jsDirectory.resolve(pathToJquery.getFileName()),REPLACE_EXISTING);
        Files.copy(pathToJSON, insideDirectory.resolve(namePath.getFileName()), REPLACE_EXISTING);
        
        Files.copy(pathLArrow, imageDirectory.resolve(pathLArrow.getFileName()), REPLACE_EXISTING);
        Files.copy(pathRArrow, imageDirectory.resolve(pathRArrow.getFileName()), REPLACE_EXISTING);
        Files.copy(pathPlay, imageDirectory.resolve(pathPlay.getFileName()), REPLACE_EXISTING);
        Files.copy(pathPause, imageDirectory.resolve(pathPause.getFileName()), REPLACE_EXISTING);
        
        for(int i = 0; i < size; i++) {
            Path dummyPath = Paths.get("images/slide_show_images/" + theSlides.get(i).getImageFileName());
            Files.copy(dummyPath, imageDirectory.resolve(dummyPath.getFileName()), REPLACE_EXISTING);
        }
    }
}
