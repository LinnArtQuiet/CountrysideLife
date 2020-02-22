package ui.move;
/**author YJX
 * 2019/12/13*/
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MoveBird extends JPanel{
	
	private Bird aBird;
	/**���캯��*/
	public MoveBird(){  
		aBird=new Bird(this);
        initUI();
    }
     /**����aBird�߳�*/ 
    public void initUI(){
        aBird.start();    
    }
    /**����paint����*/
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(aBird.birdImage, aBird.x, aBird.y, 35, 70, this);//�趨aBird��СΪ35��35
    }
}
//�ڲ���Bird
class Bird extends Thread{
	//ת���ƶ�����ͼƬ
	public Image birdImage;
	//�����ģ�0��0����ʼ�ƶ�
	public int x=0;
	public int y=0;
	//������JPanel
	public JPanel jp;
	//һ����ƶ��ٶ�
	public int movesp=1;
	
	/**����������JPanel*/
	public Bird(JPanel jp) {
		this.jp=jp;

	} 
	
	/**�����ƶ��߼�*/
	
	/**��һ���ƶ�
	 * �ӣ�0��0����ʼ������ƽ��ֱ����300��0��*/
	 public int Firstmove(){
		 if(x!=300) {//����ֱ��300
			x+=movesp;
			return 1;
		}	    			 
	     return 2;
	 }
	 
	 /**�ڶ����ƶ�
	  * �ӣ�300��0����ʼ����ƽ��ֱ����300��50��
	  * ��ͼƬ��Ϊ�����ƶ���ͼƬ*/
	 public int Secondmove(){
		 if(y!=50) {
			 y+=5;
			 return 2;
		 }
		 birdImage=new ImageIcon(this.getClass().getResource("/image/birdleft.png")).getImage();
		 return 3;
	 }
	
	 /**�������ƶ�
	  * �ӣ�300��50����ʼ�����·��ƶ�ֱ����220��130��*/
	 public int Thirdmove() {
		 if(x!=220) {
			 x-=movesp;
			 y+=movesp;
			 return 3;
		 }
		 return 4;
	 }
	 
	 /**���Ĳ��ƶ�
	  * �ӣ�220��130������ƽ��ֱ����130��130��*/
	 public int Forthmove(){
		 if(x!=130) {
			 x-=movesp;
			 return 4;
		 }
		 return 5;
	 }
	 
	 /**���岽�ƶ�
	  * �ӣ�130��130�������Ϸ��ƶ�ֱ����0��0��
	  * ��ͼƬ��Ϊ�����ƶ���ͼƬ*/
	 public int fifthmove() {
		 if(x!=0) {
			 x-=movesp;
			 y-=movesp;
			 return 5;
		 }
		 birdImage=new ImageIcon(this.getClass().getResource("/image/birdright.png")).getImage();
		 return 1;
	 }
	 
	 /**����run����
	  * ÿ0.1��ı�һ������*/
	 public void run(){
		 //�趨��ʼ��ͼƬΪ�����ƶ���ͼƬ
		 	birdImage=new ImageIcon(this.getClass().getResource("/image/birdright.png")).getImage();
		 	int i=1;
	        while(true){
	        	//����i�ж��ƶ�����
	        	switch (i) {
				case 1:i=Firstmove();break;
				case 2:i=Secondmove();break;
				case 3:i=Thirdmove();break;
				case 4:i=Forthmove();break;
				case 5:i=fifthmove();break;
				}
	        	jp.repaint();
	            try {
	                Thread.sleep(100);//0.1��ˢ��һ��
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	 }
}