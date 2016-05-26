package com.goit.collections.set;

import java.util.Set;

public abstract class SetDemo<T extends Set> implements SetExperiment {
    private Set set;

    public SetDemo(Set<Integer> set) {
        this.set = set;
    }

    @Override
    public long addExperiment() {
        return 0;
    }

    @Override
    public long removeExperiment() {
        return 0;
    }

    @Override
    public long containsExperiment() {
        return 0;
    }

    @Override
    public long populateExperiment(int setSize) {
        return 0;
    }
}
