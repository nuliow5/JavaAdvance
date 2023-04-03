package eu.codeacademy.taskGeneric.service;

import eu.codeacademy.taskGeneric.ListBox;

import java.util.List;

public class MyListBox<T> implements ListBox<T> {
    private List<T> myList;

    public MyListBox(List<T> myList) {
        this.myList = myList;
    }

    @Override
    public void addElements(T[] values) {
        for (int i = 0; i < values.length; i++) {
            myList.add(values[i]);
        }
    }

    @Override
    public void addElement(Object value) {

    }

    @Override
    public List getElements() {
        return null;
    }
}
