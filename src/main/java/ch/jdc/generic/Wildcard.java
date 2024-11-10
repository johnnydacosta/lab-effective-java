package ch.jdc.generic;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {

    static class BadGenList<E> {
        List<E> list = new ArrayList<>();

        public void add(E e) {
            this.list.add(e);
        }

        public void addAll(List<E> list) {
            this.list.addAll(list);
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }

    static class GenList<E> {
        List<E> list = new ArrayList<>();

        public void add(E e) {
            this.list.add(e);
        }

        public void addAll(List<? extends E> list) {
            this.list.addAll(list);
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }

    public static void main(String[] args) {


        BadGenList<Number> badGenList = new BadGenList<>();
        GenList<Number> genList = new GenList<>();

        Integer i1 = 1;
        Double d1 = 1.0;
        Float f1 = 1.1f;

        List<Integer> listOfInteger = List.of(1,2,3);

        genList.add(i1);
        genList.add(d1);
        genList.add(f1);
        genList.addAll(listOfInteger);
        System.out.println(genList);

        badGenList.add(i1);
        badGenList.add(d1);
        badGenList.add(f1);
        // uncomment will failed the build
        //badGenList.addAll(listOfInteger); /!\ incompatible types with generic /!\
        System.out.println(badGenList);
    }
}
