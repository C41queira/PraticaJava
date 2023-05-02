package br.com.olympiadativides.application;

import br.com.olympiadativides.entites.Olympiad;
import br.com.olympiadativides.entites.Participant;
import br.com.olympiadativides.service.UpdateOlympiad;

public class Progam {
    
    public static void main(String[] args) {
        Olympiad olympiad = new Olympiad("Olimpiada brasileira de Geografia", 5, 5);

        Participant p1 = new Participant("Maria", 1); 
        olympiad.addParticipant(p1);

        
        Participant p2 = new Participant("Paulo", 2); 
        olympiad.addParticipant(p2);

        Participant p3 = new Participant("Palmiro", 3); 
        olympiad.addParticipant(p3);

        UpdateOlympiad.update(olympiad);
        UI.printScorecard(olympiad);

    }
}
