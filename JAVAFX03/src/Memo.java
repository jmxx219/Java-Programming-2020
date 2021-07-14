
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2020년도 2학기
 * @author 김상진 
 * Memo.java
 * 파일에 저장할 수 있는 간단한 메모 응용
 */
public class Memo extends Application {
	private TextArea memo = new TextArea();
	private Stage mainStage;
	private File currentFile = null;
	private MenuItem saveMenuItem = new MenuItem("저장");
	private MenuItem clearMenuItem = new MenuItem("전체 지우기");
	
	private void saveAS() {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showSaveDialog(mainStage);
		if(file==null) return;
		try(PrintWriter out = new PrintWriter(file)){
			out.print(memo.getText());
			mainStage.setTitle("메모창: "+file.getName());
			currentFile = file;
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
	}
	private void openMemo() {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(mainStage);
		if(file==null) return;
		try(Scanner reader = new Scanner(file)){
			StringBuilder in = new StringBuilder();
			while(reader.hasNextLine()){
				in.append(reader.nextLine()).append("\n");
			}
			memo.setText(in.toString());
			currentFile = file;
			mainStage.setTitle("메모창: "+currentFile.getName());
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}

	}
	private void selectFont() {
		List<String> fonts = Font.getFamilies();
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Arial", fonts);
		dialog.setTitle("폰트 선택");
		dialog.setHeaderText(null);
		dialog.setContentText("폰트를 선택하세");
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent()){
			memo.setFont(Font.font(result.get(),FontWeight.NORMAL,FontPosture.REGULAR,16));
			Platform.runLater( new Runnable() {
			    @Override
			    public void run() {
			        memo.positionCaret(memo.getText().length());
			    }
			});
		}
	}
	private MenuBar constructMenuBar(){
		MenuItem openMenuItem = new MenuItem("불러오기");
		saveMenuItem.setGraphic(new ImageView(new Image("save.png")));
		openMenuItem.setGraphic(new ImageView(new Image("load.png")));
		clearMenuItem.setGraphic(new ImageView(new Image("clear.png")));
		
		saveMenuItem.setDisable(true);
		clearMenuItem.setDisable(true);
		
		openMenuItem.setOnAction(e->openMemo());
		saveMenuItem.setOnAction(e->saveAS());
		clearMenuItem.setOnAction(e->{
			memo.setText("");
		});
		
		MenuItem fontMenuItem = new MenuItem("Select Font");
		fontMenuItem.setOnAction(e->selectFont());
		
		Menu fileMenu = new Menu("File");
		Menu formatMenu = new Menu("Format");
		fileMenu.getItems().addAll(openMenuItem, saveMenuItem,
				new SeparatorMenuItem(), clearMenuItem);
		formatMenu.getItems().add(fontMenuItem);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, formatMenu);
		return menuBar;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane mainPane = new BorderPane();
		
		Button saveBtn = new Button("저장");
		Button openBtn = new Button("불러오기");
		Button clearBtn = new Button("전체 지우기");
		
		HBox buttonPane = new HBox();
		buttonPane.setSpacing(10);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(10));
		buttonPane.getChildren().addAll(saveBtn, openBtn, clearBtn);
		saveBtn.setGraphic(new ImageView(new Image("save.png")));
		openBtn.setGraphic(new ImageView(new Image("load.png")));
		clearBtn.setGraphic(new ImageView(new Image("clear.png")));
		saveBtn.setOnAction(e->saveAS());
		openBtn.setOnAction(e->openMemo());
		clearBtn.setOnAction(e->memo.setText(""));
		saveBtn.setDisable(true);
		clearBtn.setDisable(true);
		
		memo.textProperty().addListener((obs, oldVal, newVal)->{
			saveBtn.setDisable(memo.getText().length()==0);
			clearBtn.setDisable(memo.getText().length()==0);
			saveMenuItem.setDisable(memo.getText().length()==0);
			clearMenuItem.setDisable(memo.getText().length()==0);
		});
		
		ScrollPane contentsPane = new ScrollPane(memo);
		contentsPane.setPadding(new Insets(10));
		
		mainPane.setTop(constructMenuBar());
		mainPane.setCenter(contentsPane);
		mainPane.setBottom(buttonPane);
		
		mainStage = primaryStage;
		
		primaryStage.setTitle("KoreaTech Memo App");
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
