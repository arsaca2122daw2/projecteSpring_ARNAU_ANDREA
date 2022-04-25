package fje.edu.daw2.Projecte_Spring_ARNAUSALINAS_ANDREASANCHEZ;

import java.io.Serializable;

public class Previsio implements Serializable {
    int id;
    double temperatura;
    String icona, ciutat, dia;


    public Previsio() {
    }

    public Previsio(int id, double temperatura, String icona, String ciutat, String dia) {
        this.id = id;
        this.temperatura = temperatura;
        this.icona = icona;
        this.ciutat = ciutat;
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTemps() {
        return temperatura;
    }

    public void setTemps(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getIcona() {
        return icona;
    }

    public void setIcona(String icona) {
        this.icona = icona;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Previsio{" +
                "id=" + id +
                ", temperatura=" + temperatura +
                ", icona='" + icona + '\'' +
                ", ciutat='" + ciutat + '\'' +
                ", dia='" + dia + '\'' +
                '}';
    }
}
