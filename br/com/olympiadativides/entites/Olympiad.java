package br.com.olympiadativides.entites;

import java.util.ArrayList;
import java.util.List;

import br.com.olympiadativides.exception.ParticipantsException;

public class Olympiad {
    private String name;
    private int limitParticipants; 
    private int rounds;
    
    List<Participant> participants; 

    Integer[][] scorecard;

    public Olympiad(String name, int rounds, int limitParticipants) {
        this.name = name;
        this.rounds = rounds;
        this.limitParticipants = limitParticipants;
        participants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimitParticipants() {
        return limitParticipants;
    }

    public void setLimitParticipants(int limitParticipants) {
        this.limitParticipants = limitParticipants;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public Integer[][] getScorecard() {
        return scorecard;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void addParticipant(Participant participant){
        if (participants.size() <= limitParticipants) {
            participants.add(participant);
            scorecard = new Integer[participants.size()][rounds+1];//Ajeita a tabela de pontuação decorrente do numero de participantes
        }else{
            throw new ParticipantsException("Todas as vagas para a olimpiada preenchidas");
        }
    }
}
