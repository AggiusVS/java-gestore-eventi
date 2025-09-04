
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            /* Crea evento */
            System.out.println("Inserisci il titolo dell'evento:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci la data dell'evento (dd/MM/yyyy)");
            String dataInput = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataInput, formatter);

            System.out.println("Inserisci il numero totale di posti:");
            int postiTotali = Integer.parseInt(scanner.nextLine());
            
            Evento evento = new Evento(titolo, data, postiTotali);
            System.out.println("Evento creato: " + evento);

            /* Prenotazioni */


        } catch (Exception e) { 
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
