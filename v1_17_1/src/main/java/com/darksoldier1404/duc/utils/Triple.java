package com.darksoldier1404.duc.utils;

@SuppressWarnings("all")
public record Triple<A, B, C>(A a, B b, C c) {

    public static <A, B, C> Triple<A, B, C> of(A a, B b, C c) {
        return new Triple<>(a, b, c);
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }
}
