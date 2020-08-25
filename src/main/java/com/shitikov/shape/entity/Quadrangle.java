package com.shitikov.shape.entity;

import com.shitikov.shape.observer.Observable;
import com.shitikov.shape.observer.Observer;
import com.shitikov.shape.observer.QuadrangleEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quadrangle extends Shape implements Observable {
    private List<Point> tops;
    private List<Observer> observers = new ArrayList<>();

    public Quadrangle(List<Point> tops) {
        super();
        this.tops = tops;
    }

    public List<Point> getTops() {
        return Collections.unmodifiableList(tops);
    }

    public Point getTop(int index) {
        return tops.get(index);
    }

    public void setTop(int index, Point point) {
        tops.set(index, point);
        notifyObservers();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Quadrangle other = (Quadrangle) obj;

        return super.equals(other)
                && tops != null ? tops.equals(other.tops) : other.tops == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tops != null ? tops.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quadrangle{");
        sb.append(super.toString());
        sb.append("tops=");
        tops.forEach(top -> sb.append(top.toString()));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.actionPerformed(new QuadrangleEvent(this));
        }
    }
}
