package hw1;

import hw1.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> list;

    public Box(T[] arr) {
        this.list = new ArrayList<>(Arrays.asList(arr));
    }

    public Box() {
        this.list = new ArrayList<>();
    }


    public void add(T fruit) {
        list.add(fruit);
    }

    public float getWeight(){
        return list.size() * list.get(0).getWeight();
    }

    public boolean compare(Box<?> anotherBox){

        return Math.abs(getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void sprinkleTo(Box<T> anotherBox) {
        for (int i = 0; i <list.size() ; i++) {
            anotherBox.add(list.get(i));
            list.set(i, null);
        }
    }

}

