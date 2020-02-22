package ui.move;
/**author YJX
 * 2019/12/13*/
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MoveBird extends JPanel{
	
	private Bird aBird;
	/**构造函数*/
	public MoveBird(){  
		aBird=new Bird(this);
        initUI();
    }
     /**启动aBird线程*/ 
    public void initUI(){
        aBird.start();    
    }
    /**重载paint方法*/
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(aBird.birdImage, aBird.x, aBird.y, 35, 70, this);//设定aBird大小为35×35
    }
}
//内部类Bird
class Bird extends Thread{
	//转载移动对象图片
	public Image birdImage;
	//从面板的（0，0）开始移动
	public int x=0;
	public int y=0;
	//依附的JPanel
	public JPanel jp;
	//一般的移动速度
	public int movesp=1;
	
	/**传入依附的JPanel*/
	public Bird(JPanel jp) {
		this.jp=jp;

	} 
	
	/**天鹅的移动逻辑*/
	
	/**第一步移动
	 * 从（0，0）开始，向右平移直至（300，0）*/
	 public int Firstmove(){
		 if(x!=300) {//右移直至300
			x+=movesp;
			return 1;
		}	    			 
	     return 2;
	 }
	 
	 /**第二步移动
	  * 从（300，0）开始向下平移直至（300，50）
	  * 将图片改为向左移动的图片*/
	 public int Secondmove(){
		 if(y!=50) {
			 y+=5;
			 return 2;
		 }
		 birdImage=new ImageIcon(this.getClass().getResource("/image/birdleft.png")).getImage();
		 return 3;
	 }
	
	 /**第三步移动
	  * 从（300，50）开始向左下方移动直至（220，130）*/
	 public int Thirdmove() {
		 if(x!=220) {
			 x-=movesp;
			 y+=movesp;
			 return 3;
		 }
		 return 4;
	 }
	 
	 /**第四步移动
	  * 从（220，130）向左平移直至（130，130）*/
	 public int Forthmove(){
		 if(x!=130) {
			 x-=movesp;
			 return 4;
		 }
		 return 5;
	 }
	 
	 /**第五步移动
	  * 从（130，130）向左上方移动直至（0，0）
	  * 将图片改为向右移动的图片*/
	 public int fifthmove() {
		 if(x!=0) {
			 x-=movesp;
			 y-=movesp;
			 return 5;
		 }
		 birdImage=new ImageIcon(this.getClass().getResource("/image/birdright.png")).getImage();
		 return 1;
	 }
	 
	 /**重载run方法
	  * 每0.1秒改变一次坐标*/
	 public void run(){
		 //设定初始的图片为向右移动的图片
		 	birdImage=new ImageIcon(this.getClass().getResource("/image/birdright.png")).getImage();
		 	int i=1;
	        while(true){
	        	//根据i判定移动方法
	        	switch (i) {
				case 1:i=Firstmove();break;
				case 2:i=Secondmove();break;
				case 3:i=Thirdmove();break;
				case 4:i=Forthmove();break;
				case 5:i=fifthmove();break;
				}
	        	jp.repaint();
	            try {
	                Thread.sleep(100);//0.1秒刷新一次
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	 }
}