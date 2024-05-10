package Game;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Quiz implements ActionListener {
	public static String[] questions = {
			//1
			"���㴤���ҳ�ࢵ�Դ��ͧ͢�ѧ��Ѵ��ҹ��ҹ����˹��?",
			//2
			"���㴤���ҳ�ࢵ�Դ��ͧ͢�ѧ��Ѵ��ҹ��ҹ�����",
			//3
			"���㴤���ҳ�ࢵ�Դ��ͧ͢�ѧ��Ѵ��ҹ��ҹ��ȵ��ѹ�͡",
			//4
			"���㴤���ҳ�ࢵ�Դ��ͧ͢�ѧ��Ѵ��ҹ��ҹ��ȵ��ѹ��",
			//5
			"���㴵��仹������ǹ˹�觢ͧ�Ӣ�ѭ�ͧ�ѧ��Ѵ��ҹ",
			//6
			"���㴵��仹������ǹ˹�觢ͧ�Ӣ�ѭ�ͧ�ѧ��Ѵ��ҹ",
			//7
			"�ѧ��Ѵ��ҹ����������Ҥ����",
			//8
			"�͡����ШӨѧ��Ѵ��ҹ��ʹ͡����",
			//9
			"������ШӨѧ��Ѵ��ҹ��͵�����",
			//10
			"ʶҹ����ͧ�����˹ ��ʶҹ����ͧ����Ǣͧ�Ѵ��Ѵ��ҹ",
			//11
			"�ط�ҹ��觪ҵ��������աԨ�������÷���й�",
			//12
			"�����繪����ط�ҹ��觪ҵ�㹨ѧ��Ѵ��ҹ",
			//13
			"�Ѵ������ͧ������������������",
			//14
			"���������ʶҹ����ͧ�����㹨ѧ��Ѵ��ҹ",
			//15
			"��â���㹢��� ���ѧ��Ѵ��ҹ�����",
			//16
			"�������Ҫ��èѧ��Ѵ��ҹ����� 55 �����",
			//17
			"�ѧ��Ѵ��ҹ�ա�������",
			//18
			"���㴵��仹������ǹ˹�觢ͧ�Ӣ�ѭ�ͧ��������ͧ��ҹ",
			//19
			"�Ѵ��иҵت�ҧ���������� ������ⴴ��",
			//20
			"���ʴ��ҹ��ŻТ�Ҵ�˭� ��͵����д��Թ�������ŻԹ��ǹ�ҹ �Թ�� ��Һ�Ի� �ժ����������",
			//21
			"���㴵��仹������ǹ˹�觢ͧ�Ӣ�ѭ�ͧ��������ͧ��ҹ",
			//22
			"�ҹ�����ͻ��ླթ�ͧ�Ҫ�ҧ�Өѧ��Ѵ��ҹ�ըش�蹤������",
			//23
			"�ҹ�������ա����������ú�ҧ",
			//24
			"�ҹ�ȡ������շͧ��Чҹ�ҪҴ�ѧ��Ѵ��ҹ���ȡ�ŷ��Ѵ�����������",
			//25
			"�ȡ�ż�ʹ͡�����٤����ȡ�ŷ���բ���������ǡѺ����",
		
		};
	String	[][] options = 	{
			//1
			{"�Դ�Ѻ�ѧ��Ѵ���","�Դ��͡Ѻ����Ⱦ���","�Դ��͡Ѻ��������","�Դ�Ѻ�ѧ��Ѵ��ҧ�ͧ"},
			//2
			{"�Դ�Ѻ�ѧ��Ѵ��ɳ��š","�Դ��͡Ѻ��������","�Դ�Ѻ�ѧ��Ѵ��⢷��","�Դ�Ѻ�ѧ��Ѵ�صôԵ��"},
			//3
			{"�Դ�Ѻ�ѧ��Ѵ���","�Դ��͡Ѻ��������","�Դ�Ѻ�ѧ��ѴʡŹ��","�Դ�Ѻ�ѧ��Ѵ��طû�ҡ��"},
			//4
			{"�Դ�Ѻ�ѧ��Ѵ�����","�Դ�Ѻ�ѧ��Ѵ�غ��Ҫ�ҹ�","�Դ�Ѻ�ѧ��Ѵ��§����","�Դ��͡Ѻ����Ⱦ���"},
			//5
			{"�������������ͧ ���ͧ�Ҫ�ҧ��͡ �Եá����Ѵ���Թ���","��ö�������ͧ ���ͧ�Ҫ�ҧ�� �Եá����Ѵ���Թ���","�������������ͧ ���ͧ�Ҫ�ҧ�� �Եá����Ѵ���Թ���","�������������ͧ ���ͧ�Ҫ�ҧ��͡ �Եá����Ѵ���Թ��"},
			//6
			{"�Թᴹ����շͧ ���ͧ�ͧ��иҵ������","ᴹ�Թ����շͧ ���ͧ�ͧ��иҵ������","ᴹ�Թ����շͧ �ͧ���ͧ��иҵ������","�Թᴹ����շͧ �ͧ���ͧ��иҵ������"},
			//7
			{"�Ҥ�˹��","�Ҥ���ѹ����§��","�Ҥ���ѹ�͡��§�˹��","�Ҥ��ҧ"},
			//8
			{"�͡����Ի","�͡�����","�͡�ؾ�óԡ���","�͡�����Ǵ͡���"},
			//9
			{"�鹡Ы��ͧ��","������ѹ","�鹡��ѧ�������","�鹡�Ż�ġ��"},
			//10
			{"������ʹ��","����٤�","�������","�١�ء���"},
			//11
			{"��ͧ������ӹ�����","�չ��","��ͧ���ӹ�����","�ӹ�ӴٻС��ѧ"},
			//12
			{"�ط�ҹ��觪ҵԢع��ҹ","�ط�ҹ��觪ҵ��Ҥ��","�ط�ҹ��觪ҵԢعἹ","�ط�ҹ��觪ҵ����ͧ��ҹ"},
			//13
			{"����ͻ��","��������§��","������ͧ��","��������ͧ��ҹ"},
			//14
			{"�Ѵ����","��ҹ���ӻͧ","�Ѵ��иҵ������","��Ҵ���ᴹ��ҹ������"},
			//15
			{"����ͧ�Թ","ö¹����ǹ���","ö��Шӷҧ","ö�"},
			//16
			{"����áԵ�� ��շԾҡ�","�������ó� �����ѵ��","������Ѳ�� �������ó","����ء�Ԫ �������"},
			//17
			{"15 ����� ��� 2 ��������","14 ����� ��� 1 ��������","13 ����� ��� 2 ��������","12 ����� ��� 1 ��������"},
			//18
			{"���ʡ�þ�иҵ��ҹ���  ���Ǵ���پҹ","���ʡ�þ�иҵ����˭�  ���Ǵ���پҹ","���ʡ�þ�иҵ��ҹ���  ���Ǵ������ǧ","���ʡ�þ�иҵ����˭�  ���Ǵ������ǧ"},
			//19
			{"��иҵآ�Ҵ�˭�","�ٻ��鹪�ҧ","਴����ҧ���","�ٻ�Ҵ�����Ѵ���ٻ��ҧ��͡"},
			//20
			{"����Ż������ҹ","����Ż����ͧ��ҹ","�͹��ԡ�","����Ż� � ��ҹ"},
			//21
			{"�ǧ��ǧ�����ѡ���ͧ  ��Ż����������ͧ�ӹҹ���ͧ��ҹ","�ǧ��ǧ�����ѡ���ͧ  ��Ż����������ͧ�ӹҹ�Ѵ���ͧ��ҹ","�ǧ��ǧ�����ѡ���ͧ  ��Ż����������ͧ�ӹҹ����Ѵ","�ǧ��ǧ�����ѡ���ͧ  ��Ż����������ͧ�ӹҹ����Ѵ���ͧ��ҹ"},
			//22
			{"�Դ���㹧ҹ�ҹ������ҡ����ա�÷ʹ��Թ���Ѥ��","�繧ҹ෾��Ҫ�ҧ�������������������","�Դ���㹧ҹ�ʹ��Թ","����բ�Ͷ١"},
			//23
			{"2 ������ ������§�������������","2 ������ ��������������͢���","3 ������ ���͵��� ������§�������������","3 ������ ���͢��� ���͵������������§��"},
			//24
			{"�繡���Ǵ����շͧ�ͧ�ջ�ШӨѧ��Ѵ","����Ƕ֧��þ�س�ͧ�Թ�������������շͧ��§��","��ä���չ�¾Ԥ�������������¹�㹷ҧ����","�١�ء���"},
			//25
			{"�Ѵ��鹷���Ѵ�����","�Ѵ����������餹�������Ѳ�����������","���ȡ�ŷ��Ѵ�����Ǵ�ͧ�բͧ��鹪���ͨѧ��Ѵ��ҹ","�Ѵ��鹪�ǧ������"}
			
		
		};
	char[] answers = 		{
			//1
			'�',
			//2
			'�',
			//3
			'�',
			//4
			'�',
			//5
			'�',
			//6
			'�',
			//7
			'�',
			//8
			'�',
			//9
			'�',
			//10
			'�',
			//11
			'�',
			//12
			'�',
			//13
			'�',
			//14
			'�',
			//15
			'�',
			//16
			'�',
			//17
			'�',
			//18
			'�',
			//19
			'�',
			//20
			'�',
			//21
			'�',
			//22
			'�',
			//23
			'�',
			//24
			'�',
			//25
			'�'
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
	JFrame frame = new JFrame();								//�ç���
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
		buttonA.setText("�");
		
		buttonB.setBackground(new Color(255, 255, 204));		
		buttonB.setBounds(12,241,75,75);
		buttonB.setFont(new Font("Angsana New",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("�");
	
		buttonC.setBackground(new Color(255, 255, 204));		
		buttonC.setBounds(12,343,75,75);
		buttonC.setFont(new Font("Angsana New",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("�");
	
		buttonD.setBackground(new Color(255, 255, 204));		
		buttonD.setBounds(12,449,75,75);
		buttonD.setFont(new Font("Angsana New",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("�");
		
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
		time_label.setText("���ҷ�������");
		
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
			
			textfield.setText("��ͷ�� "+(count+1));
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
				answer= '�';
				displayAnswer();
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= '�';
				displayAnswer();
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= '�';
				displayAnswer();
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= '�';
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
		
		if(answers[index] != '�')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != '�')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != '�')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != '�')
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
		
		timeleftfield.setText("�ͺ�������� "+(round--));
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
	