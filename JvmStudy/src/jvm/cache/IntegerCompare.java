package jvm.cache;

public class IntegerCompare {

    public static void main(String[] args) {
        Integer a1 = 1;
        Integer a2 = 1;

        Integer a3 = 128;
        Integer a4 = 128;

        Integer a5 = 256;
        Integer a6 = 256;

        System.out.println(a1 == a2);
        System.out.println(a3 == a4);
        System.out.println(a5 == a6);
        Integer i = 1;
    }
}
