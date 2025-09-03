
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    /* Attributi */
    private String titolo;
    private LocalDate data;
    private final int postiTotali;
    private int postiPrenotati;

    /* Costruttore */
    public Evento(String titolo, LocalDate data, int postiTotali) {
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data è già passata");
        }
        if(postiTotali <= 0){
            throw new IllegalArgumentException("Il numero totale dei posti deve essere positivo");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }
    /* Getter/Setter */

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data è già passata");
        }
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati(){
        return postiPrenotati;
    }


    /* Metodi pubblici */
    
    public void prenota(){
        if(data.isBefore(LocalDate.now())){
            throw new IllegalStateException("La data non può essere già passata");
        }
        if(postiPrenotati >= postiTotali){
            throw new IllegalStateException("Impossibile prenotare, tutti i posti sono stati prenotati");
        }
        postiPrenotati++;
    }

    public void disdici(){
        if(data.isBefore(LocalDate.now())){
            throw new IllegalStateException("La data non può essere già passata");
        }
        if(postiPrenotati <= 0){
            throw new IllegalStateException("Impossibile disdire, nessuna prenotazione effettuata");
        }
        postiPrenotati--;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }
}
