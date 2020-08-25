package com.shitikov.shape.observer;

import com.shitikov.shape.entity.Quadrangle;

import java.util.EventObject;

public class QuadrangleEvent extends EventObject {

    public QuadrangleEvent(Object source) {
        super(source);
    }

    @Override
    public Quadrangle getSource() {
        return (Quadrangle)super.getSource();
    }
}
