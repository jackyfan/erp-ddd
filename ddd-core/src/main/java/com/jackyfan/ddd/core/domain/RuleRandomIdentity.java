package com.jackyfan.ddd.core.domain;


import java.util.Random;

public class RuleRandomIdentity implements RandomIdentity<String> {
    private String value;
    private String prefix;
    private int seed;
    private String joiner;
    private static final int DEFAULT_SEED = 100_000;
    private static final String DEFAULT_JOINER = "_";
    private static final long serialVersionUID = 1L;

    public RuleRandomIdentity() {
        this("", DEFAULT_SEED, DEFAULT_JOINER);
    }

    public RuleRandomIdentity(int seed) {
        this("", seed, DEFAULT_JOINER);
    }

    public RuleRandomIdentity(String prefix, int seed) {
        this(prefix, seed, DEFAULT_JOINER);
    }

    public RuleRandomIdentity(String prefix, int seed, String joiner) {
        this.prefix = prefix;
        this.seed = seed;
        this.joiner = joiner;
        this.value = compose(prefix, seed, joiner);
    }

    @Override
    public final String value() {
        return this.value;
    }

    @Override
    public final String next() {
        return compose(prefix, seed, joiner);
    }

    private String compose(String prefix, int seed, String joiner) {
        long suffix = new Random(seed).nextLong();
        return String.format("%s%s%s", prefix, joiner, suffix);
    }
}
