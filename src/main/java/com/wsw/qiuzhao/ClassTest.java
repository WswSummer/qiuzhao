package com.wsw.qiuzhao;

import java.lang.reflect.Field;

public class ClassTest {
    private static int[] array = new int[3];
    private static int length = array.length;

    private static Class<One> one = One.class;
    private static Class<Another> another = Another.class;

    public static void main(String[] args) {
        try {
            One oneObject = one.getDeclaredConstructor().newInstance();
            oneObject.call();

            Another anotherObject = another.getDeclaredConstructor().newInstance();
            anotherObject.speak();

            Field privateFieldInOne = one.getDeclaredField("inner");
            privateFieldInOne.setAccessible(true);
            privateFieldInOne.set(oneObject, "word changed.");
            System.out.println(oneObject.getInner());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class One {
    private String inner = "time files.";

    public void call() {
        System.out.println("hello world.");
    }

    public String getInner() {
        return inner;
    }
}

class Another {
    public void speak() {
        System.out.println("easy coding.");
    }
}