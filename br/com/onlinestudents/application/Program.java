package br.com.onlinestudents.application;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import br.com.onlinestudents.entites.Matter;

public class Program {
    /* Em um portal de cursos online, cada usuário possui um código único, representado por
    um número inteiro.
    Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno pode se
    matricular em quantos cursos quiser. Assim, o número total de alunos de um instrutor não
    é simplesmente a soma dos alunos de todos os cursos que ele possui, pois pode haver
    alunos repetidos em mais de um curso.
    O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.
    Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a
    quantidade total e alunos dele, conforme exemplo. */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int repeat;  

        Matter A = new Matter();
        Matter B = new Matter();
        Matter C = new Matter();

        System.out.println("\nHow many students for course A?");
        repeat = scan.nextInt(); 

        for(int i = 1; i <= repeat; i++){
            System.out.printf("\nRA of the %d studant: ", i);
            A.getStudents().add(scan.nextInt()); 
        }

        System.out.println("\nHow many students for course B?");
        repeat = scan.nextInt(); 

        for(int i = 1; i <= repeat; i++){
            System.out.printf("\nRA of the %d studant: ", i);
            B.getStudents().add(scan.nextInt()); 
        }

        System.out.println("\nHow many students for course C?");
        repeat = scan.nextInt(); 

        for(int i = 1; i <= repeat; i++){
            System.out.printf("\nRA of the %d studant: ", i);
            C.getStudents().add(scan.nextInt()); 
        }

        Set<Integer> studantsTeacher = new TreeSet<>(); 
        studantsTeacher.addAll(A.getStudents()); 
        studantsTeacher.addAll(B.getStudents()); 
        studantsTeacher.addAll(C.getStudents());
        
        System.out.printf("\nTotal students: %d", studantsTeacher.size());

        scan.close();
    }
}
