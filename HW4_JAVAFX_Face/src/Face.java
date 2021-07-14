import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
//import java.lang.Math;

/**
 * �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * ���ϸ�: Face.java
 * @author ������ 2019136072
 * @version 2020�⵵ 2�б�
 * JavaFX�� �̿��� �� �׸���
 */
public class Face extends Group{
	private int xLeft;
	private int yTop;
	public Face(int x, int y){
	xLeft = x;
	yTop = y;
	} // Face(int, int)
	public Group getGroup(){
	// �ϼ��Ͻÿ�.
		//���� �׸���
		Circle faceCircle = new Circle(xLeft+30,yTop+30, 25d);
		faceCircle.setStroke(Color.BLACK);
		faceCircle.setStrokeWidth(1.5d);
		faceCircle.setFill(Color.WHITE);
		
		//���ʴ� �׸���
		Circle leftEyeCircle = new Circle(xLeft+20,yTop+23, 5d);
		leftEyeCircle.setStroke(Color.BLACK);
		leftEyeCircle.setStrokeWidth(1.5d);
		leftEyeCircle.setFill(null);
		
		//������ �� �׸���
		Circle rightEyeCircle = new Circle(xLeft+40,yTop+23, 5d);
		rightEyeCircle.setStroke(Color.BLACK);
		rightEyeCircle.setStrokeWidth(1.5d);
		rightEyeCircle.setFill(null);
		
		Line[] lines = new Line[11];
		//�� �׸���
		lines[0] = new Line(xLeft+30,yTop+30,xLeft+30,yTop+38);
		//�Լ� �׸���
		lines[1] = new Line(xLeft+15,yTop+38,xLeft+25,yTop+45);
		lines[2] = new Line(xLeft+25,yTop+45,xLeft+35,yTop+45); 
		lines[3] = new Line(xLeft+35,yTop+45,xLeft+45,yTop+38);
		//�Ӹ�ī�� �׸���
		lines[4] = new Line(xLeft,yTop+30,xLeft,yTop+50);
		lines[5] = new Line(xLeft+60,yTop+30,xLeft+60,yTop+50);
		lines[6] = new Line(xLeft,yTop+50,xLeft+15,yTop+50);
		lines[7] = new Line(xLeft+45,yTop+50,xLeft+60,yTop+50);
		//�ոӸ� �׸���
		lines[8] = new Line(xLeft+20,yTop+8.5,xLeft+20,yTop+15);
		lines[9] = new Line(xLeft+30,yTop+5,xLeft+30,yTop+15);
		lines[10] = new Line(xLeft+40,yTop+8.5,xLeft+40,yTop+15);
		
		for(var line: lines) {
			line.setStroke(Color.BLACK);
			line.setStrokeWidth(1.5d);
			line.setFill(null);
		}
		
		//�Ӹ� �׸���
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
