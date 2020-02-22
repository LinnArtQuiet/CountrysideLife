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
		    setSize(350, 150);  //���ڴ�С
		    setResizable(false);  //���ڴ�С���������
		    setLocationRelativeTo(null);  //�������Ļ���ϽǾ���
		    
		    
		    JPanel jp=new JPanel();
		    getContentPane().add(jp);
		    jp.setLayout(null);
		    jp.setBounds(0, 0, 300, 114);
		    
			JLabel jl1=new JLabel("����������������");
			JTextField jt=new JTextField();
			JButton jb1=new JButton("����");
			JButton jb2=new JButton("ȡ��");
			
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
			
					if(User.getState(APP.user) == 0)//����˯��
					{
						JOptionPane.showMessageDialog(null,"���˯���㲻��۸�Ŷ��");
					}
					else
					{
						if(jt.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"������������Ϊ��,��������������������");
							return;
						}
						else {
							int count = Integer.parseInt(jt.getText());
							if(FruitBag.getFruitCount(cropId)<count)
							{
								JOptionPane.showMessageDialog(null,Crop.getName(cropId)+"��ʵ��������,��������������������");
								return;
							}
							else
							{
								double money = Crop.getFruitMoney(cropId);
								double total = count*money;
								User.moneyAdd(APP.user, total);
								FruitBag.minusFruitCount(cropId, count);
								JOptionPane.showMessageDialog(null, Crop.getName(cropId)+"��ʵ���۳ɹ����о��Լ�����ԣ��");
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
