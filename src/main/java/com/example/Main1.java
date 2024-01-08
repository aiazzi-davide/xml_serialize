package com.example;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main1 {
    public static void main(String[] args) {
        Alunno alunno1 = new Alunno("Mario", "Rossi", new Date(2000, 1, 1));
        Alunno alunno2 = new Alunno("Luigi", "Verdi", new Date(2000, 2, 2));
        Alunno alunno3 = new Alunno("Giovanni", "Bianchi", new Date(2000, 3, 3));
        Alunno alunno4 = new Alunno("Paolo", "Neri", new Date(2000, 4, 4));
        ArrayList<Alunno> alunni = new ArrayList<Alunno>();
        alunni.add(alunno1);
        alunni.add(alunno2);
        alunni.add(alunno3);
        alunni.add(alunno4); 
        Classe classe = new Classe(1, "A", "Aula 1", alunni);
        
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String s1 = xmlMapper.writeValueAsString(classe);
            xmlMapper.writeValue(new File("test.xml"), classe);

            Classe classe2 = xmlMapper.readValue(new File("test.xml"), Classe.class);
            System.out.println(classe2.aula);
            System.out.println(classe2.numero);
            System.out.println(classe2.sezione);
            System.out.println(classe2.alunni.get(0).nome);
            System.out.println(classe2.alunni.get(0).cognome);
            System.out.println(classe2.alunni.get(0).dataNascita);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}