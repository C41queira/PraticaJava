package br.com.postBuilder.entite;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private String title;
    private String content; 
    private Date moment; 
    private int likes; 

    List<Coment> coments; 

    public Post(){}

    public Post(String title, String content, int likes){
        this.title = title;
        this.content = content;
        this.moment = new Date();
        this.likes = likes; 
        coments = new ArrayList<>(); 
    }

    public List<Coment> getComents() {
        return coments;
    }
    public void setComents(List<Coment> coments) {
        this.coments = coments;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getMoment() {
        return moment;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    

    public void addComent(Coment c){
        coments.add(c);
    }

    public Coment Coments(){
        Coment c = new Coment(); 
        for (Coment coment : coments) {
           c = coment;  
        }
        return c; 
    }

    //StringBuilder para manipular as Strings as juntando da forma que você desejar 
    //Append para colocar a string desejada no StringBuilder e toString para dar todo o retorno
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title + "\n");
        sb.append(sdf.format(moment) + "\n");
        sb.append(content + "\n");
        sb.append(likes + " Likes" + "\n");
        sb.append("Coments:" + "\n");
        for (Coment coment : coments) {
            sb.append(coment);
        } 
        return sb.toString();
    }
    
}
