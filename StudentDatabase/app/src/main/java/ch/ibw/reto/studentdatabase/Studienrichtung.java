package ch.ibw.reto.studentdatabase;

import java.util.HashMap;

/**
 * Created by user on 23.04.2017.
 */

public enum Studienrichtung {
    Applikationsentwicklung, Architektur, Friseurwesen, Jura;

    public Integer getId(){
        //
        HashMap<Studienrichtung, Integer> hm = new HashMap<Studienrichtung, Integer>();
        hm.put(Studienrichtung.Applikationsentwicklung, 1);
        hm.put(Studienrichtung.Architektur, 2);
        hm.put(Studienrichtung.Friseurwesen, 3);
        hm.put(Studienrichtung.Jura, 4);
        return hm.get(this);
    }

    // TODO doppelte logik, aber erstmal egal
    public static Studienrichtung findStudienrichtungById(int studienrichtungId) {
        if (studienrichtungId == 1)  return Studienrichtung.Applikationsentwicklung;
        else if (studienrichtungId == 2)  return Studienrichtung.Architektur;
        else if (studienrichtungId == 3)  return Studienrichtung.Friseurwesen;
        else if (studienrichtungId == 4)  return Studienrichtung.Jura;
        return null;
    }

}
