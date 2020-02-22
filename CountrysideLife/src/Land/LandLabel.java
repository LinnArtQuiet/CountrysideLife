package Land;
import java.awt.BorderLayout;
/**
 * @author YJX
 * @updateTime 2019.12.11*/
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Bag.SeedBag;
import Crop.Crop;
import Event.Event;
import Medium.Images;
import main.APP;
import user.User;

public class LandLabel extends JLabel{
	
	private JLabel landstate;//����״̬��ͼ
	private JLabel cropstate;//����״̬��ͼ
	private int landId;//��Ӧ����ID
	/**���캯��
	 * �����������������������ID
	 * ���г�ʼ����ͼ
	 * ��ȡ���ص�ũ����״̬
	 * ��Ӽ�����
	 * ��ʱˢ��״̬*/
	public LandLabel(int landId) {
		super();
		
		LandLabel.this.landId = landId;  //���õ�ǰ�����idֵ
		//��ʼ����ͼ
		initGUI();
		//������ؼ�����
		myListioner();
		
//		if(Land.getCropId(APP.user, landId)!=-1)
		if(Land.getCropId(APP.user, landId)!=-1 && !Land.isCropRipe(landId))
		{
			Land.grow(landId,LandLabel.this);
		}
	}
	
	
	
	
	/*��ʼ����ͼ*/
	private void initGUI() {
		try {
			this.setSize(225,80);
			this.setLayout(new BorderLayout());
			landstate= new JLabel();
			
			this.add(landstate,BorderLayout.CENTER);
			
			
			landstate.setLayout(null);
			landstate.setBounds(0, 0, 225,80);//����״̬��ͼλ��
			cropstate= new JLabel();
			landstate.add(cropstate);
			cropstate.setBounds(0, 0, 225,80);//����״̬��ͼλ��
			
			//�������غ�����״̬ͼ
			try {
				flush();
				}catch (Exception e1) {
					// TODO: handle exception
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*���ؼ�����*/
	private class MyMouseListener extends MouseAdapter{
		int level = Land.getLevel(landId);
		public void mouseClicked(MouseEvent e) {
			
			if(User.getClasses(APP.user)<level)
			{
				JOptionPane.showMessageDialog(null, "������"+level+"��������������ҪŬ����");
			}
			else
			{
				//������Я��ֵ
				int flag = e.getModifiers();
				//�ж����״̬�ǲ����������
				if (flag == InputEvent.BUTTON1_MASK) {
					if(User.getState(APP.user)==0)
					{
						JOptionPane.showMessageDialog(null, "˯��״̬�޷����в���");
					}
					else
					{
						//�ж����֪��Ҫ�����ջ�
						if (APP.gf.getMouseCursorIcon() == 100) {//�ջ��ܼ����Я��ֵΪ100
							if (Land.getCropId(APP.user, landId)!=-1) {//�ж������Ƿ�Ϊ��
								//�ж������Ƿ����
								if(Land.isCropRipe(landId)) {
									//����Event���ջ񷽷�
									Event.harvest(landId);
									//ˢ�µ�ǰ���ؼ�ũ����״̬ͼ
									try {
										flush();
										}catch (Exception e1) {
											// TODO: handle exception
										}
								}
								else if(Land.getStageNow(APP.user, landId)>Crop.getStageCount(Land.getCropId(APP.user, landId)))
								{
									JOptionPane.showMessageDialog(null, "���Ȳ�����ή��"+Crop.getName(Land.getCropId(APP.user, landId))+"��");
									return;
								}
								else{//��ǰũ���ﻹû����
									JOptionPane.showMessageDialog(null, Crop.getName(Land.getCropId(APP.user, landId))+"��û�г��죬�ٵȵȰɣ�");
									return;
									}
								}
							else{//��ǰ����û��ũ����
								JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
								return;
							}
						}
						//�ж����֪��Ҫ�����Ƴ�
						else if (APP.gf.getMouseCursorIcon() == 200) {//�Ƴ����ܼ����Я��ֵΪ200
							if (Land.getCropId(APP.user, landId)!=-1) {//�ж������Ƿ�Ϊ��
								if(Land.getStageNow(APP.user, landId)<=Crop.getStageCount(Land.getCropId(APP.user, landId)))
								{
									int is = JOptionPane.showConfirmDialog(null, Crop.getName(Land.getCropId(APP.user, landId))+"��û�п�ή��ȷ��Ҫ������");
									if(is == JOptionPane.OK_OPTION)
									{
										Event.move(landId);  //����Event���Ƴ�����
										//ˢ�µ�ǰ���ؼ�ũ����״̬ͼ
										try {
											flush();
											}catch (Exception e1) {
												// TODO: handle exception
											}
									}
								}
								else
								{
									//����Event���Ƴ�����
									Event.move(landId);
									//ˢ�µ�ǰ���ؼ�ũ����״̬ͼ
									try {
										flush();
										}catch (Exception e1) {
											// TODO: handle exception
										}
								}
							}
							else{//��ǰ����û��ũ����
								 JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
								 return;
							}
						}
						//�ж����֪��Ҫ���н�ˮ
						else if(APP.gf.getMouseCursorIcon() == 300) {//��ˮ���ܼ����Я��ֵΪ300
							if (Land.getCropId(APP.user, landId)!=-1) {//�ж������Ƿ�Ϊ��
								//�ж��Ƿ����
								if(Land.getStageNow(APP.user, landId)>(Crop.getStageCount(Land.getCropId(APP.user, landId))))
								{
									JOptionPane.showMessageDialog(null, Crop.getName(Land.getCropId(APP.user, landId))+"�ѿ������뼰ʱ������");
								}
								else
								{
									//�ж����ظ�ʪ״̬
									if(Land.getState(APP.user, landId)==2) {//������ʪ��
										JOptionPane.showMessageDialog(null, "�ٽ�ˮ"+Crop.getName(Land.getCropId(APP.user, landId))+"��Ҫ����������");
										return;
									}
									else if(Land.getState(APP.user, landId)==1) {//����������״̬��
										JOptionPane.showMessageDialog(null, "ˮ�ֹ�����");
										return;
									}
									else{  //�����Ǹɵ�
										//����Event�ཽˮ����
										Event.water(landId);
										//ˢ�µ�ǰ���ؼ�ũ����״̬ͼ
										try {
										flush();
										}catch (Exception e1) {
											// TODO: handle exception
											System.out.println("��ˮˢ���쳣");
										}
										//ˢ���������û������;���ֵ
									}
								}
														
							}
							else {//��ǰ����û��ũ����
								 JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
								 return;
							}
						}
						//�ж����֪��Ҫ���в���
						else if(APP.gf.getMouseCursorIcon()>0 && APP.gf.getMouseCursorIcon()<12) {//Ŀǰ�ݶ�11��ũ����ID��1-11
							if(Land.getCropId(APP.user, landId) == -1) {//�ж�����״̬�Ƿ����	
								//��ȡ��ǰ���Я����ũ����ID
								//����Event����ֲ����
								Event.sow( landId, APP.gf.getMouseCursorIcon(),LandLabel.this);
								//ˢ�µ�ǰ���ؼ�ũ����״̬ͼ
								if(SeedBag.getSeedCount(APP.gf.getMouseCursorIcon())==0)  //�������Ѿ������������ټ�����ֲ��
								{
									APP.gf.setMouseCursorIcon(0);
									APP.gf.setCursor(null);
								}
								try {
									flush();
									}catch (Exception e1) {
										// TODO: handle exception
										System.out.println("����ˢ���쳣");
									}
							}
							else{//��ǰ��������ũ����
								JOptionPane.showMessageDialog(null, "��������Ѿ���������");
								return;
							}
						}
					}
					
				}
			}
			
		}
	}
	
	/*������ؼ�����*/
	private void myListioner() {
		MyMouseListener myl = new MyMouseListener();
		LandLabel.this.addMouseListener(myl);
	}
	
	public void flush() {
		//�����������ݿ������ж����ظ�ʪ״̬
		landstate.setIcon(Images.getImg(Land.getLandPic(Land.getState(APP.user, landId))));
		if(0<=Land.getStageNow(APP.user, landId)&&Land.getStageNow(APP.user, landId)<=(Crop.getStageCount(Land.getCropId(APP.user, landId))+1))
		{
			//�����������ݿ��ж�����״̬
			String CropPicPath = Crop.getCropPic(Land.getCropId(APP.user, landId), Land.getStageNow(APP.user, landId));
			//���õ�ǰ���ﵱǰ״̬��ͼ
			cropstate.setIcon(Images.getImg(CropPicPath));
		}
		else
			cropstate.setIcon(null);
	}
	
}




