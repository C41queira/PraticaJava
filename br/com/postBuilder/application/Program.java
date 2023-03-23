package br.com.postBuilder.application;

import br.com.postBuilder.entite.Coment;
import br.com.postBuilder.entite.Post;

public class Program {
   
    public static void main(String[] args) {
        Post p1 = new Post("Momento Babaca", "A viajem à Paris foi maravilhosa, pena que a população é tão rude", 50);

        Coment c1 = new Coment("Esfrega na nossa cara mesmo FDP");
        Coment c2 = new Coment("Sobrinho lindo do meu coração");
        Coment c3 = new Coment("Para viajar tem dinheiro, agora para me pagar");
        Coment c4 = new Coment("Viagem linda amor");

        p1.addComent(c1);
        p1.addComent(c2);
        p1.addComent(c3);
        p1.addComent(c4);

        System.out.println(p1);
    }
}
