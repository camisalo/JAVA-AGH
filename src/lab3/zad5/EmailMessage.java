package lab3.zad5;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;


public class EmailMessage {

    protected String from; //required (must be e-mail)
    protected LinkedList<String> to = new LinkedList<>(); //required at least one (must be e-mail)
    protected String subject = null; //optional
    protected String content = null; //optional
    protected String mimeType = null;  // optional
    protected LinkedList<String> cc = null; //optional
    protected LinkedList<String> bcc = null; // optional
    // ----------------------------------------------------------------------
    protected EmailMessage( String from,
                            LinkedList<String> to,
                            String subject,
                            String content,
                            String mimeType,
                            LinkedList<String> cc,
                            LinkedList<String> bcc){ }
    protected EmailMessage( String from,
                            LinkedList<String> to) {    }

    protected EmailMessage(){    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public void send() {

        final String username = from;
        Scanner in = new Scanner(System.in);
        System.out.print("Hasło: ");
        final String password = in.nextLine();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            for (String t: to) {
                message.addRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(t));
            }
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Send");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Builder {
        private EmailMessage email;

        public Builder() {
            email = new EmailMessage();
        }

        public Builder(String from, LinkedList<String> to) {
            email = new EmailMessage(from, to);
        }

        public Builder addFrom(String from) {
            email.from = from;
            return this;
        }
        public Builder addTo(String to) {
            email.to.add(to);
            return this;
        }
        public Builder addSubject(String subject) {
            email.subject = subject;
            return this;
        }
        public Builder addContent(String content) {
            email.content = content;
            return this;
        }
        public EmailMessage build() {
            return email;
        }
    }
}