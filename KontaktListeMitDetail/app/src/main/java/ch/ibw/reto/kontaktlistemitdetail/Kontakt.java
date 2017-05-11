package ch.ibw.reto.kontaktlistemitdetail;

import java.io.InterruptedIOException;
import java.io.Serializable;

/**
 * Created by rk on 11.05.17.
 */

public class Kontakt implements Serializable {
    String name;
    String telefonnummer;
    String webseite;

    public Kontakt(String name, String telefonnummer, String webseite) {
        this.name = name;
        this.telefonnummer = telefonnummer;
        this.webseite = webseite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getWebseite() {
        return webseite;
    }

    public void setWebseite(String webseite) {
        this.webseite = webseite;
    }
}
