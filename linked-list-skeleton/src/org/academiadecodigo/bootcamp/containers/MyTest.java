package org.academiadecodigo.bootcamp.containers;

public class MyTest {
    public static void main(String[] args) {

        LinkedList<Integer> test = new LinkedList();

        test.add(1);
        test.add(15);
        test.add(30);

        for(Integer i : test){
            System.out.println(i);
        }
    }
}

