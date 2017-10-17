package lab3.zad5;

public class EmailTest {
    public static void main(String[] args)  {
        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("camisalo94@gmail.com")
                .addTo("camisalo94@gmail.com")
                .addSubject("Mail testowy")
                .addContent("Jakaś tam treść.")
                .build();

        wiadomosc.send();
    }
}
