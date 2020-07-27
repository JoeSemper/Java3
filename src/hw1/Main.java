package hw1;

import hw1.fruits.Apple;
import hw1.fruits.Orange;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        // 1 задание
        String[] arr1 = new String[] {"java", "cat", "apple"};
        changeElements(arr1, 0, 2);
        System.out.println(Arrays.asList(arr1));

        //2 задание
        Integer[] arr2 = new Integer[] {1, 5, 6, 7, 8, 2, 9, 12};
        ArrayList<Integer> list = arrayToList(arr2);

        //3 задание
        Apple[] apples = new Apple[10];
        Orange[] oranges = new Orange[10];

        for (int i = 0; i < 10; i++) {
            apples[i] = new Apple();
            oranges[i] = new Orange();
        }

        Box<Apple> box1 = new Box<>(apples);
        Box<Orange> box2 = new Box<>(oranges);

        System.out.println(box1.compare(box2));


        Box<Apple> box3 = new Box<>();
        for (int i = 0; i <5 ; i++) {
            box3.add(new Apple());
        }

        box3.sprinkleTo(box1);

        System.out.println(box1.compare(box2));
    }


    // метод 1 задания
    public static <T> T[] changeElements(T[] arr, int i, int j){

        T tempElem = arr[i];
        arr[i] = arr[j];
        arr[j] = tempElem;

        return arr;
    }

    // метод 2 задания
    public static <T> ArrayList<T> arrayToList (T[] arr){

        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arr));

        return arrayList;
    }
 }
