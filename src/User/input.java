package User;

//import Game.FileOutputstream;
//import Game.Printwriter;
import Game.nansrii;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
 public class input  implements  ActionListener{
	public File file = new File("D:NANSRII.txt");
	private FileOutputStream file1 = new FileOutputStream(file);
	private PrintWriter writer = new PrintWriter(file1);	
	private JFrame Frame_GUI,Frame_Alert;
	private JLabel Label2_GUI,Label1_Alert,Label2_Alert;
	private JButton btnPlay,Button_Alert;
	private JTextArea text_GUI;
	private ReturnEnterNameHandler RN = new ReturnEnterNameHandler();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					input  window = new input ();
					window.Frame_GUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public input () throws IOException {
		initialize();
	}
	public void initialize() throws IOException{

		Frame_GUI = new JFrame();
		Frame_GUI.getContentPane().setFont(new Font("maaja", Font.PLAIN, 15));
		Frame_GUI.setTitle("NANSRII");
		Frame_GUI.setBounds(350, 100, 800, 600);
		Frame_GUI.setResizable(false);
		Frame_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame_GUI.getContentPane().setLayout(null);

		text_GUI = new JTextArea();
		text_GUI.setFont(new Font("maaja", Font.PLAIN, 40));
		text_GUI.setBounds(301, 423, 191, 46);
		Frame_GUI.getContentPane().add(text_GUI);

		btnPlay = new JButton("PLAY");
		btnPlay.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlay.setFont(new Font("maaja", Font.PLAIN, 40));
		btnPlay.setBounds(322, 493, 149, 46);
		btnPlay.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		btnPlay.addActionListener(this);
		Frame_GUI.getContentPane().add(btnPlay);

		Label2_GUI = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/image/BG3.jpg")).getImage();
		Label2_GUI.setIcon(new ImageIcon(img));
		Label2_GUI.setBounds(0, 0, 783, 560);
		System.out.print(Frame_GUI.getContentPane().add(Label2_GUI));
	}
	public void Alert() {


		Frame_Alert = new JFrame("NANSRII");
		Frame_Alert.setBounds(600, 270, 300, 120);
		Frame_Alert.setResizable(false);
		Frame_Alert.setUndecorated(true);
		Frame_Alert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame_Alert.getContentPane().setBackground(Color.black);
		Frame_Alert.getContentPane().setLayout(null);
		Frame_Alert.setVisible(true);
	

		Button_Alert = new JButton("OK");
		Button_Alert.setFont(new Font("majaa", Font.PLAIN, 20));
		Button_Alert.setBounds(100, 80, 100, 30);
		Button_Alert.addActionListener(RN);
		Frame_Alert.getContentPane().add(Button_Alert);

		Label2_Alert = new JLabel("กรุณาใส่ชื่อเพื่อเริ่มเกม");
		Label2_Alert.setBounds(50, 30, 220, 50);
		Label2_Alert.setFont(new Font("maaja", Font.BOLD, 36));
		Label2_Alert.setForeground(Color.white);
		Frame_Alert.getContentPane().add(Label2_Alert);

		Label1_Alert = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/image/BG.jpg")).getImage();
		Label1_Alert.setIcon(new ImageIcon(img1));
		Label1_Alert.setBounds(-400, -30, 783, 500);
		System.out.print(Frame_Alert.getContentPane().add(Label1_Alert));




	}
	public class ReturnEnterNameHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			Frame_Alert.setVisible(false);

		}
	}
	public void actionPerformed(ActionEvent e) {
		if(text_GUI.getText().trim().isEmpty()) {
			Alert(); //ถ้า User ไม่ได้กรอกชื่อจะไม่สามารถเริ่มเกมได้แล้วเกิด กล่องข้อความแจ้งเตือน
		}else {
			writer.println(text_GUI.getText());
			writer.close();
			nansrii.main(null);
			Frame_GUI.setVisible(false);
		}

	}
}




