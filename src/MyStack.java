public class MyStack {

    int[] stack;
    int top = -1;
    int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity-1;
    }

    public void push(int x) {
        if(isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        top ++;
        stack[top] = x;
    }

    public void pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty, nothing to pop");
        }
        int temp = stack[top];
        top --;
        System.out.println(temp);
    }

    public void peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty, nothing to peek");
        }
        System.out.println(stack[top]);
    }

    public void display() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty, nothing to display");
        }
        int tempTop = top;
        while(tempTop > 0) {
            System.out.print(stack[tempTop] + " ");
            tempTop --;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);
        myStack.push(1);
        myStack.push(2);
        myStack.peek();
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.peek();
        myStack.pop();
        myStack.peek();
        myStack.push(6);
        myStack.display();
    }
}
