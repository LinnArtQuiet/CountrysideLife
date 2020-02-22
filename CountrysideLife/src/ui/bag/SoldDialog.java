package ui.bag;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Bag.FruitBag;
import Crop.Crop;
import main.APP;
import user.User;

public class SoldDialog extends JDialog{
	
		public SoldDialog(int cropId) {
		    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		    getContentPane().setLayout(new BorderLayout());
		    setSize(350, 150);  //窗口大小
		    setResizable(false);  //窗口大小不允许更改
		    setLocationRelativeTo(null);  //相对于屏幕左上角居中
		    
		    
		    JPanel jp=new JPanel();
		    getContentPane().add(jp);
		    jp.setLayout(null);
		    jp.setBounds(0, 0, 300, 114);
		    
			JLabel jl1=new JLabel("请输入销售数量：");
			JTextField jt=new JTextField();
			JButton jb1=new JButton("销售");
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
						JOptionPane.showMessageDialog(null,"打瞌睡可算不清价格哦！");
					}
					else
					{
						if(jt.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"销售数量不能为空,请重新输入销售数量！");
							return;
						}
						else {
							int count = Integer.parseInt(jt.getText());
							if(FruitBag.getFruitCount(cropId)<count)
							{
								JOptionPane.showMessageDialog(null,Crop.getName(cropId)+"果实数量不足,请重新输入销售数量！");
								return;
							}
							else
							{
								double money = Crop.getFruitMoney(cropId);
								double total = count*money;
								User.moneyAdd(APP.user, total);
								FruitBag.minusFruitCount(cropId, count);
								JOptionPane.showMessageDialog(null, Crop.getName(cropId)+"果实销售成功！感觉自己超富裕！");
								try {
									User.ExAdd(23);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								SoldDialog.this.dispose();
								return;
							}
							}
					}
						
				}
			});
			jb2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					SoldDialog.this.dispose();
					return;
				}
				
			});
	}

}
