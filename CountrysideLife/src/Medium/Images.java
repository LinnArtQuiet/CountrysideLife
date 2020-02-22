package Medium;

import javax.swing.ImageIcon;

public class Images {

	public static ImageIcon getImg(String path){
		
		ImageIcon img = new ImageIcon(Images.class.getResource(path));
		return img;
	}
	
}
