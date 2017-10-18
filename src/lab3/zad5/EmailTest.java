package lab3.zad5;

public class EmailTest {
    public static void main(String[] args)  {
        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("")
                .addTo("")
                .addSubject("Mail testowy")
                .addContent("Jakaś tam treść.")
                .build();

        wiadomosc.send();
    }
}
