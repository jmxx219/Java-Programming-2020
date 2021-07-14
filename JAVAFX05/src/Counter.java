import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2020년도 2학기
 * @author 김상진
 * ProgressIndicator, ProgressBar, Slider, ScrollBar, Spinner 실습 
 */
public class Counter extends Application {

	public static final int MAX = 10;
	private ProgressIndicator pi = new ProgressIndicator();
	private ProgressBar pb = new ProgressBar();
	private Slider slider = new Slider(0, MAX, 0);
	private ScrollBar sb = new ScrollBar();
	private Spinner<Integer> spinner = new Spinner<>(0, MAX, 0);
	private Button decreaseButton = new Button("<<<");
	private Button increaseButton = new Button(">>>");
	
	private void counterChanged(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		int counter = newValue.intValue();
		pi.setProgress((double)counter/MAX);
		pb.setProgress((double)counter/MAX);
		slider.setValue(counter);
		sb.setValue(counter);
		spinner.getEditor().setText(counter+"");
	}

	private void setControls(){
		pi.setProgress(0d);
		
		pb.setMinWidth(280d);
		pb.setProgress(0d);
		
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(2);
		slider.setMinorTickCount(1);
		slider.valueProperty().addListener(
			(o,ov,nv)->counterChanged(o,ov,nv));
		
		sb.setMinWidth(280);
		sb.setMin(0);
		sb.setMax(MAX);
		sb.setBlockIncrement(1d);
		sb.setUnitIncrement(2d);
		sb.valueProperty().addListener(
			(o,ov,nv)->counterChanged(o,ov,nv));
		
		//spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, MAX));
		spinner.setEditable(true);
        spinner.valueProperty().addListener(
    		(o,ov,nv)->counterChanged(o,ov,nv));
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setControls();
		HBox buttonPane = new HBox();
		buttonPane.setSpacing(10);
		buttonPane.setPadding(new Insets(10));
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(decreaseButton, increaseButton);
		decreaseButton.setOnAction(e->{
			int count = (int)sb.getValue();
			if(count>0) --count;
			counterChanged(null, count+1, count);
		});
		increaseButton.setOnAction(e->{
			int count = (int)sb.getValue();
			if(count<MAX) ++count;
			counterChanged(null, count-1, count);
		});
		
		VBox box = new VBox();
		box.setSpacing(10);
		box.setPadding(new Insets(10));
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(pi, pb, slider, sb, spinner, buttonPane);
		primaryStage.setTitle("Slider, Spinner, ... Example");
		primaryStage.setScene(new Scene(box,300,300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
