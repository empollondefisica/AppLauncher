
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App
{
    /**
     *  Name
     *  Path to Executable
     *  Executable
     *  
     * 
     *  Button
     *  Edit Form
     *  New Form
     */
     
    private String Name;
    private String Command;
    private Image Icon;
    private String Description;
    
    private static final double HEIGHT = 200;
    private static final double WIDTH = 300;
    
    private Button button;
    
    public App( String name, Image icon, String command )
    {
        if( name == null || name.equals( "" ) )
        {
            Name = command;
        }
        else
        {
            Name = name;
        }
        Icon = icon;
        Command = command;
        
        button = new Button( Name );
        button.setOnAction( new EventHandler<ActionEvent>()
        {
            public void handle( ActionEvent actionEvent )
            {
                try
                {
                    Process process = Runtime.getRuntime().exec( command );
                    BufferedReader reader = new BufferedReader( new InputStreamReader( process.getInputStream() ) );
                }
                catch( IOException ioe )
                {
                    System.out.println( ioe.getMessage() );
                }
            }
        } );
        
        ContextMenu contextMenu = new ContextMenu();
        MenuItem editMenuItem = new MenuItem( "Edit..." );
        editMenuItem.setOnAction( new EventHandler<ActionEvent>()
        {
            public void handle( ActionEvent actionEvent )
            {
                editApp();
            }
        } );
        MenuItem deleteMenuItem = new MenuItem( "Delete" );
        
        contextMenu.getItems().add( editMenuItem );
        contextMenu.getItems().add( deleteMenuItem );
        
        button.setContextMenu( contextMenu );
    }
    
    public Button getButton()
    {
        return button;
    }
    
    public void editApp()
    {
        Stage editStage = new Stage();
        Group group = new Group();
        Scene scene = new Scene( group, WIDTH, HEIGHT );
        GridPane gridPane = new GridPane();
        
        Label nameLabel = new Label( "Name" );
        Label commandLabel = new Label( "Command" );
        Label descriptionLabel = new Label( "Description" );
        
        Button iconButton = new Button( "Icon" );
        
        Button cancelButton = new Button( "Cancel" );
        Button okButton = new Button( "Ok" );
        
        TextField nameField = new TextField();
        TextField commandField = new TextField();
        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setPrefSize( 200, 100 );
        
        gridPane.add( nameLabel, 0, 0 );
        gridPane.add( commandLabel, 0, 1 );
        gridPane.add( descriptionLabel, 0, 2 );
        gridPane.add( iconButton, 3, 0, 1, 2 );
        gridPane.add( nameField, 1, 0 );
        gridPane.add( commandField, 1, 1 );
        gridPane.add( descriptionTextArea, 0, 3, 3, 1 );
        gridPane.add( cancelButton, 0, 4 );
        gridPane.add( okButton, 1, 4 );
        
        group.getChildren().add( gridPane );
        editStage.setScene( scene );
        editStage.show();
    }
    
    public static App newApp()
    {
        App app = null;
        
        Stage newStage = new Stage();
        Group group = new Group();
        Scene scene = new Scene( group, WIDTH, HEIGHT );
        GridPane gridPane = new GridPane();
        
        Label nameLabel = new Label( "Name" );
        Label commandLabel = new Label( "Command" );
        Label descriptionLabel = new Label( "Description" );
        
        Button iconButton = new Button( "Icon" );
        
        TextField nameField = new TextField();
        TextField commandField = new TextField();
        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setPrefSize( 200, 100 );
        
        gridPane.add( nameLabel, 0, 0 );
        gridPane.add( commandLabel, 0, 1 );
        gridPane.add( descriptionLabel, 0, 2 );
        gridPane.add( iconButton, 3, 0, 1, 2 );
        gridPane.add( nameField, 1, 0 );
        gridPane.add( commandField, 1, 1 );
        gridPane.add( descriptionTextArea, 0, 3, 3, 1 );
        
        group.getChildren().add( gridPane );
        newStage.setScene( scene );
        newStage.show();
        
        return app;
    }
}
