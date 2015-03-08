
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

public class AppLauncher extends Application
{
    public static void main( String[] args )
    {
        Application.launch( args );
    }
    
    public void start( Stage stage )
    {
        Group group = new Group();
        Scene scene = new Scene( group, 500, 500 );
        
        BorderPane borderPane = new BorderPane();
        ScrollPane scrollPane = new ScrollPane();
        FlowPane flowPane = new FlowPane();
        
        scrollPane.setContent( flowPane );        
        borderPane.setCenter( scrollPane );
        borderPane.prefWidthProperty().bind( scene.widthProperty() );
        borderPane.prefHeightProperty().bind( scene.heightProperty() );
        
        
        App app = new App( "google", null, "google" );
        flowPane.getChildren().add( app.getButton() );
        
        group.getChildren().add( borderPane );
        
        stage.setScene( scene );
        stage.setTitle( "AppLauncher" );
        stage.show();
    }
}
