package com.darksoldier1404.duc.utils;

public record Tuple<A, B>(A a, B b) {

    public static <A, B> Tuple<A, B> of(A a, B b) {
        return new Tuple<>(a, b);
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }
}
