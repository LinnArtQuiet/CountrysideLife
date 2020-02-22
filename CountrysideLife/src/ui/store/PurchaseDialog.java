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
		//sort��ʾ�����Ʒ���ࣨ1�������ӣ�2����ʳ��
		//Id��ʾ�����Ʒ���Լ������е����к�
		//price��ʾ�ò�Ʒ�ĵ���
		{
		    getContentPane().setLayout(new BorderLayout());
		    setSize(350, 150);  //���ڴ�С
		    setResizable(false);  //���ڴ�С���������
		    setLocationRelativeTo(null);  //�������Ļ���ϽǾ���
		    
		    
		    JPanel jp=new JPanel();
		    getContentPane().add(jp);
		    jp.setLayout(null);
		    jp.setBounds(0, 0, 300, 114);
		    
			JLabel jl1=new JLabel("�����빺��������");
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
						JOptionPane.showMessageDialog(null,"˯�����Ժ����������Ϻ����̼ң�");
					}
					else
					{
						if(jt.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"������������Ϊ��,���������빺��������");
							return;
						}
						else { //����������
							int purchaseCount = Integer.valueOf(jt.getText());
							double total = price*purchaseCount;
							int i = User.moneyMinus(APP.user, total);  //��Ҽ���
							if(i==1)
							{//���ӻ�ʳ����������
							if(sort==1){
								SeedBag.addSeedCount(Id, purchaseCount);
								JOptionPane.showMessageDialog(null, "��ϲ������ɹ���"+purchaseCount+"��"+Crop.getName(Id)+"�����ѷ������������գ���");
							}
							else{
								FoodBag.addFoodCount(Id, purchaseCount);
								JOptionPane.showMessageDialog(null, "��ϲ������ɹ���"+purchaseCount+"��"+Food.getName(Id)+"�ѷ������������գ���");
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
								JOptionPane.showMessageDialog(null,"������ɬ����ȥ׬Ǯ��");
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
