package com.example.webtest;

import DAO.kompisDAO;
import kompis.Kompis;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KompisController {

    kompisDAO kompisDaoDB = new kompisDAO();
    List<Kompis> kompisList = kompisDaoDB.getAllkompis();

    @RequestMapping("/kompis")
    public List<Kompis> kompis() {
        return kompisList;
    }
    @RequestMapping("/kompis/{id}/delete")
    public String kompisDelete(@PathVariable Kompis id) {
        int kompisToDelete = -1;

        for (int i = 0; i < kompisList.size(); i++){
            if (kompisList.get(i).getId() == id.getId()){
                kompisToDelete = i;
            }
        }

        kompisList.remove(kompisToDelete);


        return "kompis nr: "+ (kompisToDelete+(1)) + " är borttagen";
    }
    @PostMapping("/kompis/add")
    public String addKompis(@RequestBody Kompis b) {

        kompisList.add(b);

        return "Ny kompis tillagd";
    }
    @PostMapping("/kompis/update")
    public String kompisUpdate(@RequestBody Kompis b) {
        int kompisToUpdate = -1;

        for (int i = 0; i < kompisList.size(); i++){
            if (kompisList.get(i).getId() == b.getId()){
                kompisToUpdate = i;
            }
        }
        if (kompisToUpdate == -1){
            kompisList.add(b);
            return "Ny kompis med id: "+ b.getId()+"\nNamn: "+b.getName()+"\nAdress: "+b.getAddress()+"\nTelefon: "+b.getPhone() + "\n är tillagd";
        }else{
            kompisList.set(kompisToUpdate,b);
        }




        return "kompis id: "+ (kompisToUpdate+(1)) + " är uppdaterad";
    }
}