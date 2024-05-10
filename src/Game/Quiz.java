package Game;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Quiz implements ActionListener {
	public static String[] questions = {
			//1
			"ข้อใดคืออาณาเขตติดต่อของจังหวัดน่านด้านทิศเหนือ?",
			//2
			"ข้อใดคืออาณาเขตติดต่อของจังหวัดน่านด้านทิศใต้",
			//3
			"ข้อใดคืออาณาเขตติดต่อของจังหวัดน่านด้านทิศตะวันออก",
			//4
			"ข้อใดคืออาณาเขตติดต่อของจังหวัดน่านด้านทิศตะวันตก",
			//5
			"ข้อใดต่อไปนี้คือส่วนหนึ่งของคำขวัญของจังหวัดน่าน",
			//6
			"ข้อใดต่อไปนี้คือส่วนหนึ่งของคำขวัญของจังหวัดน่าน",
			//7
			"จังหวัดน่านตั้งอยู่ที่ภาคอะไร",
			//8
			"ดอกไม้ประจำจังหวัดน่านคือดอกอะไร",
			//9
			"ต้นไม้ประจำจังหวัดน่านคือต้นอะไร",
			//10
			"สถานที่ท่องเทียวไหน เป็นสถานที่ท่องเที่ยวของจัดหวัดน่าน",
			//11
			"อุทยานแห่งชาติแม่จริมมีกิจกรรมอะไรที่แนะนำ",
			//12
			"ข้อใดเป็นชื่ออุทยานแห่งชาติในจังหวัดน่าน",
			//13
			"วัดมิ่งเมืองตั้งอยู่ที่อำเภออะไร",
			//14
			"ข้อใดไม่ใช่สถานที่ท่องเที่ยวในจังหวัดน่าน",
			//15
			"การขนส่งในข้อใด ที่จังหวัดน่านไม่มี",
			//16
			"ผู้ว่าราชการจังหวัดน่านคนที่ 55 คือใคร",
			//17
			"จังหวัดน่านมีกี่อำเภอ",
			//18
			"ข้อใดต่อไปนี้เป็นส่วนหนึ่งของคำขวัญของอำเภอเมืองน่าน",
			//19
			"วัดพระธาตุช้างค้ำวรวิหาร มีอะไรโดดเด่น",
			//20
			"หอแสดงงานศิลปะขนาดใหญ่ ก่อตั้งและดำเนินการโดยศิลปินชาวน่าน วินัย ปราบริปู มีชื่อว่าอะไร",
			//21
			"ข้อใดต่อไปนี้เป็นส่วนหนึ่งของคำขวัญของอำเภอเมืองน่าน",
			//22
			"งานแข่งเรือประเพณีฉลองงาช้างดำจังหวัดน่านมีจุดเด่นคืออะไร",
			//23
			"งานแข่งเรือมีกี่ประเภทอะไรบ้าง",
			//24
			"งานเทศกาลส้มสีทองและงานกาชาดจังหวัดน่านเป็นเทศกาลที่จัดขึ้นเพื่ออะไร",
			//25
			"เทศกาลผ่อดอกชมพูภูคาเป็นเทศกาลที่มีข้อมูลเกี่ยวกับอะไร",
		
		};
	String	[][] options = 	{
			//1
			{"ติดกับจังหวัดเลย","ติดต่อกับประเทศพม่า","ติดต่อกับประเทศลาว","ติดกับจังหวัดอ่างทอง"},
			//2
			{"ติดกับจังหวัดพิษณุโลก","ติดต่อกับประเทศลาว","ติดกับจังหวัดสุโขทัย","ติดกับจังหวัดอุตรดิตถ์"},
			//3
			{"ติดกับจังหวัดเลย","ติดต่อกับประเทศลาว","ติดกับจังหวัดสกลนคร","ติดกับจังหวัดสมุทรปราการ"},
			//4
			{"ติดกับจังหวัดพะเยา","ติดกับจังหวัดอุบลราชธานี","ติดกับจังหวัดเชียงใหม่","ติดต่อกับประเทศพม่า"},
			//5
			{"แข่งเรือลือเลื่อง เมืองงาช้างเผือก จิตรกรรมวัดภูมินทร์","แข่งรถลือเลื่อง เมืองงาช้างดำ จิตรกรรมวัดภูมินทร์","แข่งเรือลือเลื่อง เมืองงาช้างดำ จิตรกรรมวัดภูมินทร์","แข่งเรือลือเลื่อง เมืองงาช้างเผือก จิตรกรรมวัดภูมินโฮ"},
			//6
			{"ดินแดนส้มสีทอง เรืองรองพระธาตุแช่แห้ง","แดนดินส้มสีทอง เรืองรองพระธาตุแช่แห้ง","แดนดินส้มสีทอง รองเรืองพระธาตุแช่แห้ง","ดินแดนส้มสีทอง รองเรืองพระธาตุแช่แห้ง"},
			//7
			{"ภาคเหนือ","ภาคตะวันตกเฉียงใต้","ภาคตะวันออกเฉียงเหนือ","ภาคกลาง"},
			//8
			{"ดอกทิวลิป","ดอกสารภี","ดอกสุพรรณิการ์","ดอกเสี้ยวดอกขาว"},
			//9
			{"ต้นกะซะลองคำ","ต้นโมกมัน","ต้นกำลังเสือโคร่ง","ต้นกัลปพฤกษ์"},
			//10
			{"ดอยเสมอดาว","ดอยภูคา","ดอยภูแว","ถูกทุกข้อ"},
			//11
			{"ล่องเรือใบลำน้ำว้า","ปีนเขา","ล่องแก่งลำน้ำว้า","ดำน้ำดูปะการัง"},
			//12
			{"อุทยานแห่งชาติขุนน่าน","อุทยานแห่งชาติเขาค้อ","อุทยานแห่งชาติขุนแผน","อุทยานแห่งชาติเมืองน่าน"},
			//13
			{"อำเภอปัว","อำเภอเวียงสา","อำเภอสองแคว","อำเภอเมืองน่าน"},
			//14
			{"วัดภูเก็ต","บ้านแม่กำปอง","วัดพระธาตุแช่แห้ง","ตลาดชายแดนบ้านห้วยโก๋น"},
			//15
			{"เครื่องบิน","รถยนต์ส่วนตัว","รถประจำทาง","รถไฟ"},
			//16
			{"นายวรกิตติ ศรีทิพากร","นายศุภกรณ์ วิมลรัตน์","นายสุวัฒน์ พรมสุวรรณ","นายอุกริช พึ่งโสภา"},
			//17
			{"15 อำเภอ และ 2 กิ่งอำเภอ","14 อำเภอ และ 1 กิ่งอำเภอ","13 อำเภอ และ 2 กิ่งอำเภอ","12 อำเภอ และ 1 กิ่งอำเภอ"},
			//18
			{"นมัสการพระธาตุเขาน้อย  แอ่วดอยภูพาน","นมัสการพระธาตุเขาใหญ่  แอ่วดอยภูพาน","นมัสการพระธาตุเขาน้อย  แอ่วดอยภูหลวง","นมัสการพระธาตุเขาใหญ่  แอ่วดอยภูหลวง"},
			//19
			{"พระธาตุขนาดใหญ่","รูปปั้นช้าง","เจดีย์ช้างค้ำ","รูปวาดภายในวัดเป็นรูปช้างเผือก"},
			//20
			{"หอศิลป์ริมน่าน","หอศิลป์เมืองน่าน","หอนาฬิกา","หอศิลป์ ณ น่าน"},
			//21
			{"บวงสรวงเสาหลักเมือง  ศิลปกรรมรุ่งเรืองตำนานเมืองน่าน","บวงสรวงเสาหลักเมือง  ศิลปกรรมรุ่งเรืองตำนานวัดเมืองน่าน","บวงสรวงเสาหลักเมือง  ศิลปกรรมรุ่งเรืองตำนานนครวัด","บวงสรวงเสาหลักเมือง  ศิลปกรรมรุ่งเรืองตำนานนครวัดเมืองน่าน"},
			//22
			{"เกิดขึ้นในงานตานก๋วยสลากและมีการทอดกฐินสามัคคี","เป็นงานเทพเจ้าช้างดำเพื่อเสริมสิริมงคล","เกิดขึ้นในงานทอดกฐิน","ไม่มีข้อถูก"},
			//23
			{"2 ประเภท เรือสวยงามและเรือเร็ว","2 ประเภท เรือเร็วและเรือขนส่ง","3 ประเภท เรือตกแต่ง เรือสวยงามและเรือเร็ว","3 ประเภท เรือขนส่ง เรือตกแต่งและเรือสวยงาม"},
			//24
			{"เป็นการอวดส้มสีทองของดีประจำจังหวัด","กล่าวถึงสรรพคุณของดินที่ทำให้ส้มเป็นสีทองสวยงาม","สารคาร์ทีนอยพิคเมนท์ในส้มเปลี่ยนไปในทางที่ดี","ถูกทุกข้อ"},
			//25
			{"จัดขึ้นที่วัดแช่แห้ง","จัดทำเพื่อให้ผู้คนสัมผัสวัฒนธรรมไทยลื้อ","เป็นเทศกาลที่จัดเพื่ออวดของดีของขึ้นชืื่อจังหวัดน่าน","จัดขึ้นช่วงปีใหม่"}
			
		
		};
	char[] answers = 		{
			//1
			'ค',
			//2
			'ง',
			//3
			'ข',
			//4
			'ก',
			//5
			'ค',
			//6
			'ข',
			//7
			'ก',
			//8
			'ง',
			//9
			'ค',
			//10
			'ง',
			//11
			'ค',
			//12
			'ก',
			//13
			'ง',
			//14
			'ข',
			//15
			'ง',
			//16
			'ก',
			//17
			'ข',
			//18
			'ค',
			//19
			'ค',
			//20
			'ก',
			//21
			'ข',
			//22
			'ก',
			//23
			'ก',
			//24
			'ง',
			//25
			'ข'
		};
	char guess;
	char answer;
	int index;
	int correct_guesses =0;
	int total_questions = questions.length;
	int result;
	int seconds=20;
	int count=0;
	int full=0;
	int round=2;

	ArrayList<Integer> remove = new ArrayList<Integer>();
	JFrame frame = new JFrame();								//ตรงนี้
	JTextField textfield = new JTextField();
	JTextField timeleftfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JButton buttonE = new JButton("TRY AGAIN");
	JButton buttonF = new JButton("EXIT");
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel lblNewLabel = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JLabel show_score,BG_frame;
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	Timer timer = new Timer(1300, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
				count++;
			}
			}
		});
	
	
	public Quiz()  {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(350,50,650,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,645,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Angsana New",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		timeleftfield.setBounds(511,0,134,50);
		timeleftfield.setBackground(new Color(25,25,25));
		timeleftfield.setForeground(new Color(25,255,0));
		timeleftfield.setFont(new Font("Angsana New",Font.BOLD,30));
		timeleftfield.setBorder(BorderFactory.createBevelBorder(1));
		timeleftfield.setHorizontalAlignment(JTextField.CENTER);
		timeleftfield.setEditable(false);
		
		textarea.setBounds(0,48,645,69);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("Angsana New",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		buttonA.setBackground(new Color(255, 255, 204));
		
		buttonA.setBounds(12,141,75,75);
		buttonA.setFont(new Font("Angsana New",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("ก");
		
		buttonB.setBackground(new Color(255, 255, 204));		
		buttonB.setBounds(12,241,75,75);
		buttonB.setFont(new Font("Angsana New",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("ข");
	
		buttonC.setBackground(new Color(255, 255, 204));		
		buttonC.setBounds(12,343,75,75);
		buttonC.setFont(new Font("Angsana New",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("ค");
	
		buttonD.setBackground(new Color(255, 255, 204));		
		buttonD.setBounds(12,449,75,75);
		buttonD.setFont(new Font("Angsana New",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("ง");
		
		answer_labelA.setBounds(105,141,500,75);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("Angsana New",Font.PLAIN,25));
		
		answer_labelB.setBounds(105,241,500,75);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("Angsana New",Font.PLAIN,25));

		answer_labelC.setBounds(105,341,500,75);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("Angsana New",Font.PLAIN,25));
		
		answer_labelD.setBounds(105,441,500,75);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("Angsana New",Font.PLAIN,25));
		
		seconds_left.setBounds(545,534,100,75);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Angsana New",Font.BOLD,50));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		
		time_label.setBounds(545, 634, 10, 10);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("Angsana New",Font.PLAIN,25));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("เวลาที่เหลือ");
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Angsana New",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Angsana New",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.getContentPane().add(time_label);
		frame.getContentPane().add(seconds_left);
		frame.getContentPane().add(answer_labelA);
		frame.getContentPane().add(answer_labelB);
		frame.getContentPane().add(answer_labelC);
		frame.getContentPane().add(answer_labelD);
		frame.getContentPane().add(buttonA);
		frame.getContentPane().add(buttonB);
		frame.getContentPane().add(buttonC);
		frame.getContentPane().add(buttonD);
		frame.getContentPane().add(textarea);
		frame.getContentPane().add(textfield);
		frame.getContentPane().add(timeleftfield);
		frame.setVisible(true);
		
		nextQuestion();
	}	
	public void nextQuestion() {
		
		Random random = new Random();
		while(true) {
			index = random.nextInt(24);
			if (!remove.contains(index)) {
                remove.add(index);
                break;				
			}
		}
		
		if(count>=5) {
			
			results();
		}
		else {
			
			textfield.setText("ข้อที่ "+(count+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}	
	
	
	public void fullTime1() {
		full++;
		if(full>3) {
			buttonE.setVisible(false);
			
		}else {
			count = 0;
			correct_guesses = 0;
			buttonE.setVisible(false);
			buttonF.setVisible(false);
			buttonA.setVisible(true);
			buttonB.setVisible(true);
			buttonC.setVisible(true);
			buttonD.setVisible(true);
			buttonA.setEnabled(true);
			buttonB.setEnabled(true);
			buttonC.setEnabled(true);
			buttonD.setEnabled(true);
			number_right.setVisible(false);
			percentage.setVisible(false);
			seconds_left.setVisible(true);
			time_label.setVisible(true);
			nextQuestion();
			
			
			}
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		count += 1;
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer= 'ก';
				displayAnswer();
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'ข';
				displayAnswer();
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'ค';
				displayAnswer();
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'ง';
				displayAnswer();
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			
			if(e.getSource()==buttonE) {				
				fullTime1();
			}
			
			if(e.getSource()==buttonF) {
				System.exit(1);
			}
		
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'ก')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'ข')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'ค')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'ง')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(1300, new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds=20;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){
		
		timeleftfield.setText("รอบที่เหลือ "+(round--));
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		buttonE.addActionListener(this);
		buttonF.addActionListener(this);
		buttonE.setVisible(true);
		buttonF.setVisible(true);
		result = (int)((correct_guesses/(double)5)*100);
		
		show_score = new JLabel(textfield.getText()+" : "+correct_guesses);
		show_score.setFont(new Font("Angsana New",Font.BOLD,35));
		show_score.setBounds(400,500,100,80);
		//show_score.setBackground(new Color(25,25,25));
		//show_score.setForeground(new Color(25,255,0));
		
		buttonE.setBackground(new Color(255, 255, 204));
		buttonE.setBounds(150,500,190,80);
		buttonE.setFont(new Font("Angsana New",Font.PLAIN,35));
		buttonE.setFocusable(false);
		
		buttonF.setBackground(new Color(255, 255, 204));
		buttonF.setBounds(400,500,100,80);
		buttonF.setFont(new Font("Angsana New",Font.PLAIN,35));
		buttonF.setFocusable(false);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		buttonA.setVisible(false);
		buttonB.setVisible(false);
		buttonC.setVisible(false);
		buttonD.setVisible(false);
		seconds_left.setVisible(false);
		time_label.setVisible(false);

		
		
		number_right.setText("("+correct_guesses+"/"+5+")");
		percentage.setText(result+"%");
		number_right.setVisible(true);
		percentage.setVisible(true);
		
		frame.getContentPane().add(number_right);
		frame.getContentPane().add(percentage);
		frame.getContentPane().add(buttonE);
		frame.getContentPane().add(buttonF);
		
	}
}
	