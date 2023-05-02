package br.com.olympiadativides.service;

import java.util.Comparator;
import br.com.olympiadativides.entites.Participant;

public class ComparetorPoints implements Comparator<Participant>{

    @Override
    public int compare(Participant o1, Participant o2) {
        return o1.getPoints() - o2.getPoints(); 
    }
    
}
