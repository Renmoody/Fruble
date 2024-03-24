import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class Email extends Authenticator {

    private String email;
    private String message;

    public Email(Contact contact, Message message) {
        this.email = contact.getEmail();
        this.message = message.getMessage();
    }

    public static void send() {
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "fubleproject@gmail.com";
        String password = "FubleProjectEmail";
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Import Session from javax.mail package and use it
        Session session = Session.getInstance(props, new Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                char[] passwordChars = password.toCharArray();
                return new javax.mail.PasswordAuthentication(username, new String(passwordChars));
            }
        });
    }
}