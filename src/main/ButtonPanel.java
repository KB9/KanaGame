package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;

import entities.Business;

public class ButtonPanel extends JPanel {
	private static Business business = new Business();
	int id = 0;
	int[] ids = new int[10];
	String[] names = new String[10];
	@SuppressWarnings({ "unchecked", "rawtypes" })
	final JComboBox comboBoxHire = new JComboBox(getHireableNames());
	@SuppressWarnings({ "unchecked", "rawtypes" })
	final JComboBox comboBoxFire = new JComboBox(business.getCurrentEmployees().toArray());
	static JButton hire = new JButton("Hire Selected Person");
	static JButton fire = new JButton("Fire Selected Person");
	 JLabel labelHire = new JLabel("Hireable People: ");
	 JLabel labelFire = new JLabel("Fireable People: ");

	@SuppressWarnings({ "unchecked" })
	public ButtonPanel() {
		setLayout(new FlowLayout() );
		setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit()
				.getScreenSize().getWidth(), 100));
		setFocusable(true);
		
		
		add(labelHire);
		add(comboBoxHire);
		add(hire);
		add(labelFire);
		add(comboBoxFire);
		add(fire);

		hire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!business.getEmployeesFull()) {
					for(int i = 0; i < 10; i++){
						if(business.getHireableEmployees().get(i).getId() == idSelectedItem()){
							business.hireEmployee(ids[i]);
						}
					}
					id++;
					comboBoxHire.removeAllItems();
					for (int x = 0; x < 10; x++) {
						comboBoxHire.addItem(getHireableNames()[x]);
					}
				}
			}
		});
//		fire.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(!business.getCurrentEmployees().isEmpty()){
//					business.getCurrentEmployees().remove(comboBoxFire.getSelectedItem().toString());
//				}
//				comboBoxFire.removeAllItems();
//				for (int x = 0; x < 10; x++) {
//					comboBoxHire.addItem(business.getCurrentEmployees().toArray()[x]);
//				}
//			}
//		});
	}
	public static void updates(){
		if(business.getEmployeesFull()){
			hire.setEnabled(false);
		}
		else{
			hire.setEnabled(true);
		}
	}

	public String[] getHireableNames() {
		for (int i = 0; i < 10; i++) {
			names[i] = business.getHireableEmployees().get(i).getName();
		}
		return names;
	}
	public int[] getIDs(){
		for (int i = 0; i < 10; i++) {
			ids[i] = business.getHireableEmployees().get(i).getId();
		}
		return ids;
	}
	
	public int idSelectedItem(){
		String a = comboBoxHire.getSelectedItem().toString();
		for(int i = 0; i < 10; i++){
			if(a == getHireableNames()[i] && comboBoxHire.getSelectedIndex() == i){
				return getIDs()[i];
			}
		}
		return 0;
		
	}
}
