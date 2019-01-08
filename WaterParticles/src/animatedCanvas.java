import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class animatedCanvas extends Canvas{
	int count = 0;
	int width,height;
	WaterTile tile;
	public animatedCanvas(int w, int h, double d){
		super(w,h);
		width = w;
		height = h;
		tile = new WaterTile(w,h,d);
		setOnMouseDragged(e -> {
			
			int x = (int) (e.getX() * width/getWidth());
			int y = (int) (e.getY() * height/getHeight());
			if(x<1)x=1;
			if(x>width-2)x=width-2;
			if(y<1)y=1;
			if(y>height-2)y=height-2;
	        tile.buff1[x][y] = 255;
	    });
		
		setOnMouseClicked(e -> {
			
			int x = (int) (e.getX() * width/getWidth());
			int y = (int) (e.getY() * height/getHeight());
			if(x<1)x=1;
			if(x>width-2)x=width-2;
			if(y<1)y=1;
			if(y>height-2)y=height-2;
	        tile.buff1[x][y] = 255;
	    });

	}
	public void drawData(){
		//scale
		this.setScaleX(1);
		this.setScaleY(1);
		
		//fun :3
		if(count%1==0){
			for(int i = 200;i<1;i++){
				tile.buff2[(int) (Math.random()*width)][(int) (Math.random()*height)] = 255;
			}
		}
		count++;
		
		
		//update buffers
		tile.update();
		
		//draw buffers
		GraphicsContext g = getGraphicsContext2D();
		tile.drawAt(g,0,0,getWidth(),getHeight());
		
		
	}
	
}