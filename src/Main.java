
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

            System.out.println("Inserire il numero di prenotazioni da effettuare");
            int prenotazioni = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < prenotazioni; i++) {
                try { 
                    evento.prenota();
                }catch (Exception e) { 
            System.out.println("Errore: " + e.getMessage());  
            }

            } 
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + evento.postiDisponibili());


            /* Disdette */

            System.out.println("Inserire numero posti da disdire: ");
            int disdette = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < disdette; i++) {
                try { 
                    evento.disdici();
                } catch(Exception e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            }
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
            System.out.println("Posti disponibili: " + evento.postiDisponibili());

        } catch (Exception e) { 
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
