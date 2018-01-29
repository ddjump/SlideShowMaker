package ssm.view;

import java.awt.Font;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static ssm.StartupConstants.CSS_CLASS_FONT_WORDS;
import static ssm.StartupConstants.CSS_CLASS_LANG_PROMPT_BTN;
import static ssm.StartupConstants.ENGLISH_LANG;
import static ssm.StartupConstants.FINNISH_LANG;
import static ssm.StartupConstants.ICON_YEN;
import static ssm.StartupConstants.LABEL_LANGUAGE_SELECTION_PROMPT;
import static ssm.StartupConstants.OK_BUTTON_TEXT;
import static ssm.StartupConstants.STYLE_SHEET_UI;

/**
 *
 * @author McKillaGorilla
 */
public class LanguageSelectionDialog extends Stage {
    VBox vBox;
    Label languagePromptLabel;
    ComboBox languageComboBox;
    Button okButton;
    String selectedLanguage = ENGLISH_LANG;
    //Stage stage;
    
    public LanguageSelectionDialog() {
	languagePromptLabel = new Label(LABEL_LANGUAGE_SELECTION_PROMPT);
        
	// INIT THE LANGUAGE CHOICES
	ObservableList<String> languageChoices = FXCollections.observableArrayList();
	languageChoices.add(ENGLISH_LANG);
	languageChoices.add(FINNISH_LANG);
	languageComboBox = new ComboBox(languageChoices);
	languageComboBox.getSelectionModel().select(ENGLISH_LANG);
        
        okButton = new Button(OK_BUTTON_TEXT);
        okButton.getStyleClass().add(CSS_CLASS_LANG_PROMPT_BTN);
	
	vBox = new VBox();
	vBox.getChildren().add(languagePromptLabel);
	vBox.getChildren().add(languageComboBox);
	vBox.getChildren().add(okButton);
        vBox.setSpacing(35);
        vBox.setAlignment(Pos.CENTER);
	vBox.getStyleClass().add(CSS_CLASS_LANG_PROMPT_BTN);
        
	okButton.setOnAction(e -> {
	    selectedLanguage = languageComboBox.getSelectionModel().getSelectedItem().toString();
	    this.hide();
	});
	
	// NOW SET THE SCENE IN THIS WINDOW
	Scene scene = new Scene(vBox,300 , 300);
        scene.getStylesheets().add(STYLE_SHEET_UI);
	setScene(scene);
    }
    
    public String getSelectedLanguage() {
	return selectedLanguage;
    }
}
