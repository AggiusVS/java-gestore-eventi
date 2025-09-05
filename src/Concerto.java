
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
    private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }


    /* Getter e setter */
    
    public LocalTime getOra() {
        return ora;
    }
    public void setOra(LocalTime ora){
        this.ora = ora;
    }


    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /* Metodi formattati */

    public String getDataOraFormattata(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
        return getData().format(df) + " " + ora.format(tf);
    }

    public String getPrezzoFormattato(){
        DecimalFormat formato = new DecimalFormat("##,##0.00");
        return formato.format(prezzo);
    }

    @Override
    public String toString(){
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}
