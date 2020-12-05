package Mensch;

import java.util.Objects;

public class Mensch<getClass> {
    private String vorname;
    private String nachname;
    private String geburtsort;
    private String geschlecht;
    private int geburtsjahr;

    public Mensch(String vorname, String nachname, String geburtsort, String geschlecht, int geburtsjahr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsort = geburtsort;
        this.geschlecht = geschlecht;
        this.geburtsjahr = geburtsjahr;
    }

    public Object getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    @Override
    public String toString() {
        return "Mensch{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", geburtsort='" + geburtsort + '\'' +
                ", geschlecht='" + geschlecht + '\'' +
                ", geburtsjahr=" + geburtsjahr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensch<?> mensch = (Mensch<?>) o;
        return geburtsjahr == mensch.geburtsjahr &&
                nachname == mensch.nachname;

    }

}
