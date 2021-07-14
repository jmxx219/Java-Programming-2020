import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * TreeViewDemo.java
 * TreeView 예제
 */
public class TreeViewDemo extends Application {
	TreeView<String> tree; 
	Label selectedText = new Label();
	
	public void treeChanged(
		ObservableValue<? extends TreeItem<String>> observable, 
		TreeItem<String> oldValue,
		TreeItem<String> newValue) {
			selectedText.setText(newValue.getValue());
	}
	
	/*
	private void insertLeaf(TreeItem<String> parent, String... titles){
		for(int i=0; i<titles.length; i++){
			TreeItem<String> node = new TreeItem<>(titles[i]);
			node.setExpanded(true);
			parent.getChildren().add(node);
		}
	}
	*/
	
	private void constructTree(){
		TreeItem<String> schools = new TreeItem<>("학부");
		TreeItem<String> cse = new TreeItem<>("컴퓨터공학부");
		TreeItem<String> eec = new TreeItem<>("전기전자통신공학부");
		schools.getChildren().add(cse);
		schools.getChildren().add(eec);
		cse.getChildren().add(new TreeItem<String>("HW"));
		cse.getChildren().add(new TreeItem<String>("SW"));
		cse.getChildren().add(new TreeItem<String>("스마트IT"));
		eec.getChildren().add(new TreeItem<String>("전기"));
		eec.getChildren().add(new TreeItem<String>("전자"));
		eec.getChildren().add(new TreeItem<String>("정보통신"));
				
		
		//schools.setExpanded(false);
		schools.setExpanded(true);
		
		//cse.setExpanded(false);
		//eec.setExpanded(false);
		//insertLeaf(cse, "HW", "SW", "스마트IT");
		//insertLeaf(eec, "전기", "전자", "정보통신");
		
		tree = new TreeView<>(schools);
		tree.getSelectionModel().selectedItemProperty().addListener(
				(o,ov,nv)->treeChanged(o,ov,nv));
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		constructTree();
		VBox treeBox = new VBox();
		treeBox.setSpacing(10);
		treeBox.setPadding(new Insets(10));
		treeBox.getChildren().addAll(tree, selectedText);
		
		primaryStage.setTitle("TreeView Example");
		primaryStage.setScene(new Scene(treeBox, 300, 400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
