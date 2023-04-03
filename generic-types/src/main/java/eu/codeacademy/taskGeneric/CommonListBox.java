package eu.codeacademy.taskGeneric;

import java.util.List;

public class CommonListBox <E> implements ListBox<E> {

    private List<E> elements;

    public CommonListBox(List<E> myList) {
        this.elements = myList;
    }

    @Override
    public void addElements(E[] values) {
        this.elements.addAll(List.of(values));
    }

    @Override
    public void addElement(E value) {
        elements.add(value);
    }

    @Override
    public List<E> getElements() {
        return elements;
    }
}
