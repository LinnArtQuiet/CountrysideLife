package ui.store;
/**
 * @author zyn
 * @updateTime 2019.12.11
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Bag.FoodBag;
import Bag.SeedBag;
import Crop.Crop;
import Food.Food;
import main.APP;
import user.User;


public class PurchaseDialog extends JDialog{
	
		public PurchaseDialog(int sort, int Id, double price)
		//sort表示购买产品种类（1代表种子，2代表食物
		//Id表示购买产品在自己种类中的序列号
		//price表示该产品的单价
		{
		    getContentPane().setLayout(new BorderLayout());
		    setSize(350, 150);  //窗口大小
		    setResizable(false);  //窗口大小不允许更改
		    setLocationRelativeTo(null);  //相对于屏幕左上角居中
		    
		    
		    JPanel jp=new JPanel();
		    getContentPane().add(jp);
		    jp.setLayout(null);
		    jp.setBounds(0, 0, 300, 114);
		    
			JLabel jl1=new JLabel("请输入购买数量：");
			JTextField jt=new JTextField();
			JButton jb1=new JButton("购买");
			JButton jb2=new JButton("取消");
			
			jl1.setBounds(60, 20, 119, 17);
			jt.setBounds(216, 18, 55, 27);
			jb1.setBounds(67, 66, 74, 26);
			jb2.setBounds(213, 65, 70, 27);
			
			jp.add(jl1);
			jp.add(jt);
			jp.add(jb1);
			jp.add(jb2);	
			setVisible(true);
			
			jb1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(User.getState(APP.user) == 0)//正在睡觉
					{
						JOptionPane.showMessageDialog(null,"睡得迷迷糊糊当心遇上黑心商家！");
					}
					else
					{
						if(jt.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"购买数量不能为空,请重新输入购买数量！");
							return;
						}
						else { //输入了数量
							int purchaseCount = Integer.valueOf(jt.getText());
							double total = price*purchaseCount;
							int i = User.moneyMinus(APP.user, total);  //金币减少
							if(i==1)
							{//种子或食物数量增加
							if(sort==1){
								SeedBag.addSeedCount(Id, purchaseCount);
								JOptionPane.showMessageDialog(null, "恭喜！购买成功！"+purchaseCount+"个"+Crop.getName(Id)+"种子已放入包裹，请查收！！");
							}
							else{
								FoodBag.addFoodCount(Id, purchaseCount);
								JOptionPane.showMessageDialog(null, "恭喜！购买成功！"+purchaseCount+"个"+Food.getName(Id)+"已放入包裹，请查收！！");
							}
							try {
								User.ExAdd(23);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							PurchaseDialog.this.dispose();
							return;
							}
							else
							{
								JOptionPane.showMessageDialog(null,"囊中羞涩，快去赚钱！");
								PurchaseDialog.this.dispose();
							}
						}
					}
					
				}
			});
			jb2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					PurchaseDialog.this.dispose();
					return;
				}
				
			});
	}

}
