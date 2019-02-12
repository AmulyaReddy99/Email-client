import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame; 

import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*;

public class SendMail extends JFrame implements ActionListener{
	TextField to, from, subject; TextArea message; Button send;
//	String password="xxx";
	public SendMail(){
		// TODO Auto-generated constructor stub
		setVisible(true);
		setSize(480,480);
		setLayout(new FlowLayout()); //FlowLayout.LEADING
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		to = new TextField(50); 
		from = new TextField(50);
		subject = new TextField(50);
		message = new TextArea(15,55);
		send = new Button("Send");
		
		Label toLabel = new Label("To: ");
		Label fromLabel = new Label("From: ");
		Label subjectLabel = new Label("Subject: ");
		
		add(toLabel); add(to); 
		add(fromLabel); add(from); 
		add(subjectLabel); add(subject);
		add(message);
		add(send);
		
		send.addActionListener(this);
		
//TODO  MENU BAR ---
//		setSize(); setColor(); setBold(); setFont();
//		insertPhoto(); addAttachment();
//		setAlignment(); Bullets();
	}
	public void actionPerformed(ActionEvent e){
//		System.out.println(to.getText());
//		System.out.println(from.getText());
//		System.out.println(subject.getText());
//		System.out.println(message.getText());
		String host = "localhost";
		Properties properties = System.getProperties(); 
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.port", 3000);
		Session session = Session.getInstance(properties); 
		try{
			MimeMessage mime_message = new MimeMessage(session);
			mime_message.setFrom(new InternetAddress(from.getText()));
			mime_message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.getText()));
			mime_message.setSubject(subject.getText());
            mime_message.setText(message.getText());
            Transport.send(mime_message); 
            System.out.println("Yo it has been sent..");
		}
		catch (MessagingException mex){
			mex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendMail m=new SendMail();
	}

}
