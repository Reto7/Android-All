package ch.ibw.reto.studentdatabase;

/**
 * Created by rk on 01.06.17.
 */

public class Student {

    private String name;
    private Studienrichtung studienrichtung;

    public Student(String name, Studienrichtung studienrichtung) {
        this.name = name;
        this.studienrichtung = studienrichtung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Studienrichtung getStudienrichtung() {
        return studienrichtung;
    }

    public void setStudienrichtung(Studienrichtung studienrichtung) {
        this.studienrichtung = studienrichtung;
    }
}
