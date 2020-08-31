import java.util.Arrays;

public class Pitch {
    public static void main(String[] args) {
      Cadetes[] cadetes =new Cadetes[5];
      for (int i =0; i < 5; i++) {
        cadetes[i] = new Cadetes(); }

      cadetes[0].setNamePitch("Joao","Eu bim de Braga!");
      cadetes[1].setNamePitch( "Joana","Eu consigo derreter cenas com o olhar");
      cadetes[2].setNamePitch("Antonio","Eu estou aqui mas podía estar noutro lado qualquer");
      cadetes[3].setNamePitch("Sofia","Desculpem lá! Hoje não estou nos meus dias");
      cadetes[4].setNamePitch("Patricia","Eu tenho o poder de ficar visível");

      for (int i= 0; i<5; i++) {
          cadetes[i].startPitch();
      }

    double random = Math.floor(Math.random()*5);
      int value = (int) random;
    cadetes[value].setPitch("Vinha á procura da casa de banho") ;
    cadetes[value].startPitch();

    }

}
