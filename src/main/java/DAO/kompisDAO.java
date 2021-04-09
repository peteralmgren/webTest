package DAO;

import kompis.Kompis;

import java.util.LinkedList;
import java.util.List;

public class kompisDAO {


    public List<Kompis> getAllkompis() {

        List<Kompis> kompisList = new LinkedList<>();
        Kompis k1 = new Kompis(1, "Kalle", "Storgatan 1","0709993333");
        Kompis k2 = new Kompis(2, "Charlie", "Istorget 8", "0734443333");

        kompisList.add(k1);
        kompisList.add(k2);
        return kompisList;
    }
}