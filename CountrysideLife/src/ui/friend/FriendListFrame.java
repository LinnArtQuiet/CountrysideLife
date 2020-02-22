package ui.friend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Medium.Images;
import main.APP;
import ui.pregame.MapFrame;

public class FriendListFrame extends JFrame{
	MapFrame thisMapFrame;
	public FriendListFrame(MapFrame frame) {
		this.thisMapFrame=frame;
		initGUI();
		}
	public void initGUI() {
		setTitle("�����б�");//���ô������
		setSize(350,429);//���ô����С
		setLocationRelativeTo(null);//���ô������
		setResizable(false);//���ô��岻�ɸı��С
		FriendPanel friendPanel=new FriendPanel(this);//�½����
		add(friendPanel);//�����װ�봰��
		setVisible(true);//���ô���ɼ�
	}
	
/**FriendListFrame�ڲ���FriendPanel*/
private class FriendPanel extends JPanel{
		private JScrollPane jScrollPane1;//�������
		private JList jList1;//�б�
		private FriendListFrame friendListFrame;//��Ӧ�ĺ���ũ������
		public FriendPanel(FriendListFrame friendListFrame) {
			this.friendListFrame=friendListFrame;
			initGUI();
			myListioner();
		}
		
		/**��Ӽ�����*/
		private void myListioner() {
			JListListioner jll = new JListListioner();
			jList1.addMouseListener(jll);

		}

		/**д�б�ļ�����*/
		private class JListListioner extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				Friends friend = (Friends) jList1.getSelectedValue();
				int flag = e.getModifiers();
				if (flag == InputEvent.BUTTON1_MASK) {
					if (!friend.name.equals(APP.user)){
						FriendFrame thisFriendFrame=new FriendFrame(friend.name);
						FriendListFrame.this.dispose();
						thisMapFrame.dispose();
						
					}
				}
			}
		}

		/**��ʼ��*/
		private void initGUI() {
			try {
				//��������С
				
				this.setPreferredSize(new Dimension(350, 400));
				setLocationRelativeTo(null);
				
				JLabel topbackLabel=new JLabel();
				ImageIcon topback=Images.getImg("/image/moveback.jpg");
				topbackLabel.setIcon(topback);
				topbackLabel.setPreferredSize(new Dimension(350,400));
				this.add(topbackLabel);
				this.setPreferredSize(getPreferredSize());//1
				{
					jScrollPane1 = new JScrollPane();
					topbackLabel.add(jScrollPane1);
					//����jScrollPane1͸��
					jScrollPane1.setOpaque(false);
					jScrollPane1.getViewport().setOpaque(false);
					//����jScrollPane1��С
					jScrollPane1.setBounds(0, 0, 340, 400);
					jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//���ô�ֱ������һֱ����
					jList1 = new FriendList();
					//����jlist1͸��
					jList1.setBackground(new Color(255,255,255,0));
					jList1.setOpaque(false);
					((JLabel)jList1.getCellRenderer()).setOpaque(false);
					jScrollPane1.setViewportView(jList1);		
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}
}
