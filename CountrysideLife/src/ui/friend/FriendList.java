package ui.friend;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import Medium.Images;

public class FriendList extends JList {
	private Vector<Friends> friends=Friends.getFriends();
	/**���캯��������һ����������*/
	public FriendList() {
		setCellRenderer(new MyListCellRenderer());// �������ڻ����б���ÿ����Ԫ��ί�С�
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ����ѡ��ģʽΪ��ѡ
		setVisibleRowCount(5);//���ù���������ͬʱ��ʾ5��
		setListDate(friends);
	}
	public void setListDate(Vector<Friends> friends) {
		//��ȡ�����������ÿ������
		super.setListData(friends);
	}
	/**ÿ������ĵ�������*/
	private class MyListCellRenderer extends JLabel implements ListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList list,Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			if (value instanceof Friends) {
				Friends friend = (Friends)value;
				setText(friends.get(index).name);// ������ʾ������
				setIcon(Images.getImg(friends.get(index).path));// ������ʾ��ͼƬ
			}
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setEnabled(true);
			setFont(list.getFont());
			setOpaque(true);
			return this;
		}
	}
}
