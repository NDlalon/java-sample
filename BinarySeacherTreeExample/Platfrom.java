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
		JFrame jfr=new JFrame("管理帳戶");
		CustomerSystem.add();
		
		jfr.setSize(new Dimension(295,180));
		jfr.add(getAccount());
		jfr.setVisible(true);
		jfr.setDefaultCloseOperation(jfr.EXIT_ON_CLOSE);
	}
	
	public JPanel getAccount() {
		JPanel jpl=new JPanel();
		jpl.setSize(new Dimension(280,140));
		
		JLabel jlbA=new JLabel("帳號");
		jlbA.setSize(50,50);
		jlbA.setLocation(5, 10);
		
		JLabel jlbP=new JLabel("密碼");
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
		
		JButton login=new JButton("登入帳號");
		login.setSize(100,30);
		login.setLocation(30,100);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jtxfA.getText().length()>0 && jtxfP.getText().length()>0) {
					NodeForCustomerInformation nodeForCustomerInformation=CustomerSystem.search(jtxfA.getText());
					if(nodeForCustomerInformation==null) {
						JOptionPane.showMessageDialog(jpl,"帳號輸入錯誤");
					}
					else {
						if(nodeForCustomerInformation.getKey().getPassword().equals(jtxfP.getText())) {
							if(nodeForCustomerInformation.getKey().getSex().equals("男")) {
								JOptionPane.showMessageDialog(jpl,"登入成功\n歡迎回來"+nodeForCustomerInformation.getKey().getName()+"先生");
							}
							else {
								JOptionPane.showMessageDialog(jpl,"登入成功\n歡迎回來"+nodeForCustomerInformation.getKey().getName()+"小姐");
							}
						}
						else {
							JOptionPane.showMessageDialog(jpl,"密碼輸入錯誤");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(jpl,"請輸入帳號密碼");
				}
			}
		});
		jpl.add(login);
		
		
		JButton delete=new JButton("刪除帳號");
		delete.setSize(100,30);
		delete.setLocation(150,100);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jtxfA.getText().length()>0 && jtxfP.getText().length()>0) {
					NodeForCustomerInformation nodeForCustomerInformation=CustomerSystem.search(jtxfA.getText());
					if(nodeForCustomerInformation==null) {
						JOptionPane.showMessageDialog(jpl,"查無帳號");
					}
					else {
						if(nodeForCustomerInformation.getKey().getPassword().equals(jtxfP.getText())) {
							CustomerSystem.delete(jtxfA.getText());
						}
						else {
							JOptionPane.showMessageDialog(jpl,"密碼輸入錯誤");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(jpl,"請輸入帳號密碼");
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
