package stack;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {
    private int top = -1;
    private int maxSize = 0;
    private List<T> stackData;

    public CustomStack(int size) {
        this.maxSize = size;
        this.stackData = new ArrayList(size);
        this.top = -1;
    }

    public void push(T num) throws StackFullException {
        if (!isFull()) {
            this.top++;
            this.stackData.add(this.top, num);
        } else {
            throw new StackFullException("Stack Full!!!");
        }
    }

    public T pop() throws StackEmptyException {
        if (!isEmpty()) {
            T data = this.stackData.get(this.top);
            this.stackData.remove(this.top);
            top--;
            return data;
        } else {
            throw new StackEmptyException("Stack Empty!!!");
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "stackData=" + stackData +
                '}';
    }
}