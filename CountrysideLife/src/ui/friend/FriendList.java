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
	/**构造函数，输入一个对象数组*/
	public FriendList() {
		setCellRenderer(new MyListCellRenderer());// 设置用于绘制列表中每个单元的委托。
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 设置选择模式为单选
		setVisibleRowCount(5);//设置滚动面板最多同时显示5个
		setListDate(friends);
	}
	public void setListDate(Vector<Friends> friends) {
		//读取好友数组里的每个对象
		super.setListData(friends);
	}
	/**每个列项的单击任务*/
	private class MyListCellRenderer extends JLabel implements ListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList list,Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			if (value instanceof Friends) {
				Friends friend = (Friends)value;
				setText(friends.get(index).name);// 设置显示的名字
				setIcon(Images.getImg(friends.get(index).path));// 设置显示的图片
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
