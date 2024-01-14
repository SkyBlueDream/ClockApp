
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;



public class ClockUp extends JFrame{
	
	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	
	String time;
	String day;
	String date;
	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	
	Random random = new Random();
	
	JProgressBar bar = new JProgressBar(0,60);
	
	ImageIcon image = new ImageIcon("C:\\Users\\Aoi\\eclipse-workspace\\ClockApp\\src\\neon.jpg");
	Image resizeImage = image.getImage();
	Image newImage = resizeImage.getScaledInstance(1600,320,java.awt.Image.SCALE_SMOOTH);
	
	ImageIcon image2 = new ImageIcon(newImage);
	
	ClockUp(){
		this.setTitle("Clock Active");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500,820);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("MMMMM dd , yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Ink Free",Font.BOLD,150));
		timeLabel.setIcon(image2);
		timeLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		timeLabel.setBackground(Color.black);
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Arial",Font.BOLD,135));
		//dayLabel.setOpaque(true);
		  
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free",Font.BOLD,125));
		//dateLabel.setOpaque(true);
		
		// ******* Progress Bar *******************************************
		
		bar.setValue(0);
		bar.setFont(new Font("Consolas",Font.BOLD,80));
		//bar.setStringPainted(true);
		bar.setPreferredSize(new Dimension(800,100));
		//bar.setBorder(BorderFactory.createBevelBorder(5,Color.blue,Color.GREEN));
		
		bar.setBackground(Color.black);
		
		//label1.setIcon(image);
		label1.setOpaque(true);
		
		this.getContentPane().setBackground(Color.black);;
		//this.add(label1);
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.add(bar);
		this.setVisible(true);
		
		
		
		setTime();
		
		
	}
	
	public void setTime() {
		
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			bar.setValue((int)(System.currentTimeMillis()/1000)%60);
			System.out.println((System.currentTimeMillis()/1000)%60);
			
			bar.setForeground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			//bar.setBackground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			dayLabel.setForeground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			dateLabel.setForeground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	}
	

