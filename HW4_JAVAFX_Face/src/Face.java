import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
//import java.lang.Math;

/**
 * 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * 파일명: Face.java
 * @author 손지민 2019136072
 * @version 2020년도 2학기
 * JavaFX를 이용한 얼굴 그리기
 */
public class Face extends Group{
	private int xLeft;
	private int yTop;
	public Face(int x, int y){
	xLeft = x;
	yTop = y;
	} // Face(int, int)
	public Group getGroup(){
	// 완성하시오.
		//얼굴형 그리기
		Circle faceCircle = new Circle(xLeft+30,yTop+30, 25d);
		faceCircle.setStroke(Color.BLACK);
		faceCircle.setStrokeWidth(1.5d);
		faceCircle.setFill(Color.WHITE);
		
		//왼쪽눈 그리기
		Circle leftEyeCircle = new Circle(xLeft+20,yTop+23, 5d);
		leftEyeCircle.setStroke(Color.BLACK);
		leftEyeCircle.setStrokeWidth(1.5d);
		leftEyeCircle.setFill(null);
		
		//오른쪽 눈 그리기
		Circle rightEyeCircle = new Circle(xLeft+40,yTop+23, 5d);
		rightEyeCircle.setStroke(Color.BLACK);
		rightEyeCircle.setStrokeWidth(1.5d);
		rightEyeCircle.setFill(null);
		
		Line[] lines = new Line[11];
		//코 그리기
		lines[0] = new Line(xLeft+30,yTop+30,xLeft+30,yTop+38);
		//입술 그리기
		lines[1] = new Line(xLeft+15,yTop+38,xLeft+25,yTop+45);
		lines[2] = new Line(xLeft+25,yTop+45,xLeft+35,yTop+45); 
		lines[3] = new Line(xLeft+35,yTop+45,xLeft+45,yTop+38);
		//머리카락 그리기
		lines[4] = new Line(xLeft,yTop+30,xLeft,yTop+50);
		lines[5] = new Line(xLeft+60,yTop+30,xLeft+60,yTop+50);
		lines[6] = new Line(xLeft,yTop+50,xLeft+15,yTop+50);
		lines[7] = new Line(xLeft+45,yTop+50,xLeft+60,yTop+50);
		//앞머리 그리기
		lines[8] = new Line(xLeft+20,yTop+8.5,xLeft+20,yTop+15);
		lines[9] = new Line(xLeft+30,yTop+5,xLeft+30,yTop+15);
		lines[10] = new Line(xLeft+40,yTop+8.5,xLeft+40,yTop+15);
		
		for(var line: lines) {
			line.setStroke(Color.BLACK);
			line.setStrokeWidth(1.5d);
			line.setFill(null);
		}
		
		//머리 그리기
		Arc hair = new Arc(xLeft+30,yTop+30,30d,30d,0d,180);
		hair.setType(ArcType.OPEN);
		hair.setStroke(Color.BLACK);
		hair.setFill(null);
		hair.setStrokeWidth(1.5d);
		
	
		Group group = new Group();
		group.getChildren().addAll(faceCircle, leftEyeCircle, rightEyeCircle, hair);
		group.getChildren().addAll(lines);
		
		return group;
	} 
}
