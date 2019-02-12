import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class GmailList {

 public static void main(String[] args) {
  GmailList gmail = new GmailList();
  gmail.read();
 }

 public void read() {
  Properties props = new Properties();
  props.setProperty("mail.imap.ssl.enable", "true");
  props.put("mail.imap.auth.login.disable", "true");
  props.put("mail.imap.port", "993");
  try {
//   props.load(new FileInputStream(new File("")));
	 Session session = Session.getInstance(props);

   Store store = session.getStore("imaps");
   store.connect("imap.gmail.com", "XXX@gmail.com","xxx");

   Folder inbox = store.getFolder("inbox");
   inbox.open(Folder.READ_ONLY);
   int messageCount = inbox.getMessageCount();

   System.out.println("Total Messages:- " + messageCount);

   Message[] messages = inbox.getMessages();
   System.out.println("------------------------------");
   for (int i = 0; i < 10; i++) {
      System.out.println("Mail Subject:- " + messages[i].getSubject());      
   }
   inbox.close(true);
   store.close();

  } catch (Exception e) {
   e.printStackTrace();
  }
 }

}