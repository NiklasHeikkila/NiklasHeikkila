// This is a implementation of stack data structure that I did in Data Structures and Algorithms (811312A) 
// course in the fall of 2024.

package oy.interact.tira.student;


import oy.interact.tira.util.StackInterface;


public class StackImplementation<E> implements  StackInterface<E> {
    
    
    private static final int DEFAULT_STACK_SIZE = 20;
    
    private Object [] itemArray;
    private int top;
    

    public StackImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        top = -1;
    }

    public StackImplementation(int size) {
        if (size > 0) {
            itemArray = new Object[size];
            top = -1;
        }
    }


    @Override
    public int capacity() {
        return itemArray.length;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Must not push null to stack!");
        }
        if (top == itemArray.length - 1) {
            reallocate();
        }
        top += 1;
        itemArray[top] = element;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws IllegalStateException {
        E element;
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        element = (E) itemArray[top];
        itemArray[top] = null;
        top -= 1;
        return element;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws IllegalStateException {
        E element;
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        element = (E) itemArray[top];
        return element;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
        
    }

    @Override
    public void clear() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        top = -1;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(size());
        string.append("[");
        for (int i = 0; i < size(); i++) {
            string.append(itemArray[i]);
            if (i < size() - 1) {
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }

    private void reallocate() {
        Object [] tempArray;
        tempArray = itemArray;
        itemArray = new Object[2 * capacity()];
        for (int i = 0; i < size(); i++) {
            itemArray[i] = tempArray[i];
            tempArray[i] = null;
        }

    }
}
