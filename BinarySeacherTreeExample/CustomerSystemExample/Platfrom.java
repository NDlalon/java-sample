import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Platfrom {
	CustomerSystem CustomerSystem=new CustomerSystem();
	public Platfrom() {
		JFrame jfr=new JFrame("�޲z�b��");
		CustomerSystem.add();
		
		jfr.setSize(new Dimension(295,180));
		jfr.add(getAccount());
		jfr.setVisible(true);
		jfr.setDefaultCloseOperation(jfr.EXIT_ON_CLOSE);
	}
	
	public JPanel getAccount() {
		JPanel jpl=new JPanel();
		jpl.setSize(new Dimension(280,140));
		
		JLabel jlbA=new JLabel("�b��");
		jlbA.setSize(50,50);
		jlbA.setLocation(5, 10);
		
		JLabel jlbP=new JLabel("�K�X");
		jlbP.setSize(50,50);
		jlbP.setLocation(5, 50);
		jpl.setLayout(null);
		jpl.add(jlbA);
		jpl.add(jlbP);
		
		JTextField jtxfA =new JTextField();
		jtxfA.setSize(200,40);
		jtxfA.setLocation(60,10);
		jpl.add(jtxfA);
		
		JTextField jtxfP =new JTextField();
		jtxfP.setSize(200,40);
		jtxfP.setLocation(60,60);
		jpl.add(jtxfP);
		
		JButton login=new JButton("�n�J�b��");
		login.setSize(100,30);
		login.setLocation(30,100);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jtxfA.getText().length()>0 && jtxfP.getText().length()>0) {
					NodeForCustomerInformation nodeForCustomerInformation=CustomerSystem.search(jtxfA.getText());
					if(nodeForCustomerInformation==null) {
						JOptionPane.showMessageDialog(jpl,"�b����J���~");
					}
					else {
						if(nodeForCustomerInformation.getKey().getPassword().equals(jtxfP.getText())) {
							if(nodeForCustomerInformation.getKey().getSex().equals("�k")) {
								JOptionPane.showMessageDialog(jpl,"�n�J���\\n�w��^��"+nodeForCustomerInformation.getKey().getName()+"����");
							}
							else {
								JOptionPane.showMessageDialog(jpl,"�n�J���\\n�w��^��"+nodeForCustomerInformation.getKey().getName()+"�p�j");
							}
						}
						else {
							JOptionPane.showMessageDialog(jpl,"�K�X��J���~");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(jpl,"�п�J�b���K�X");
				}
			}
		});
		jpl.add(login);
		
		
		JButton delete=new JButton("�R���b��");
		delete.setSize(100,30);
		delete.setLocation(150,100);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jtxfA.getText().length()>0 && jtxfP.getText().length()>0) {
					NodeForCustomerInformation nodeForCustomerInformation=CustomerSystem.search(jtxfA.getText());
					if(nodeForCustomerInformation==null) {
						JOptionPane.showMessageDialog(jpl,"�d�L�b��");
					}
					else {
						if(nodeForCustomerInformation.getKey().getPassword().equals(jtxfP.getText())) {
							CustomerSystem.delete(jtxfA.getText());
						}
						else {
							JOptionPane.showMessageDialog(jpl,"�K�X��J���~");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(jpl,"�п�J�b���K�X");
				}
			}
		});
		jpl.add(delete);
		
		return jpl;
	}
	
	public static void main(String[] args) {
		new Platfrom();
	}

}
