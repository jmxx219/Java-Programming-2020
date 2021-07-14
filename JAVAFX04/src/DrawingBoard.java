import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DrawingBoard extends Group {
	private Image spaceCraftImg = new Image("spacecraft.png");
	private Image explosionImg = new Image("explosion.png"); 
	private Image missileImg = new Image("missile.png");
	private ImageView scView = new ImageView(spaceCraftImg);
	private ImageView eView = new ImageView(explosionImg);
	private ImageView mView = new ImageView(missileImg);
		
	public DrawingBoard(){
		scView.setX(5);
		scView.setY(10);
		mView.setX(80);
		mView.setY(140);
		getChildren().addAll(scView,mView);
	}
	
	public void clear(){
		getChildren().clear();
		getChildren().add(eView);
		double destX = mView.getX()-eView.getBoundsInLocal().getWidth()/2;
		double destY = mView.getY()-eView.getBoundsInLocal().getHeight()/2;
		eView.setX(destX);
		eView.setY(destY);
	}
	public void moveShip(){
		scView.setX(scView.getX()+10);
	}
	public boolean moveMissile(){
		mView.setY(mView.getY()-10); 	
		if(scView.intersects(mView.getBoundsInLocal())){			
			return true;
		}
		else return false; 
	}
	
}
