public class Stack{

    int[] stack = null;
    int capacity = 0;
    int size = 0;

    Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    public boolean contains(int element){
        for (int i = 0; i < size; i++) {
            if(stack[i] == element)
                return true;
        }
        return false;
    }

    public void push(int element){
        if(size == capacity)
            throw new IndexOutOfBoundsException("Stack is full");

        if(size == 0)
            stack[0] = element;

        else{
            for (int i = size; i > 0; i--) {
                stack[i] = stack[i-1];
            }
            stack[0] = element;
        }
        size++;
    }

    public void push(int n, int[] elements){
        if(n > 0 && elements.length > 0){
            if(n > capacity-size)
                throw new IndexOutOfBoundsException("Stack will be full, needs atleast " + (n-capacity-size) + " more spots..");
            for (int i = 0; i < n; i++) {
                push(elements[i]);
            }
        }
    }

    public int pop(){
        int retval;
        if(size == 0)
            throw new IndexOutOfBoundsException("Stack is empty");
        
        retval = stack[0];
        
        for (int i = 0; i < size-1; i++) {
            stack[i] = stack[i+1];
        }
        stack[size-1] = 0;
        size--;

        return retval;
    }
    public int[] pop(int n){
        if(n > size)
            throw new IndexOutOfBoundsException("Stack has fewer elements than " + n);

        int tempList[] = new int[n];

        if(n > 0){
            if(n == 1)
                tempList[0] = pop();
    
            else{
                for (int i = n; i > 0; i--) {
                    tempList[i-1] = pop();
                }
            }
        }
        return tempList;
    }
    

    public static void main(String args[]) {
        Stack stack = new Stack(15);

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

        int elements[] = new int[15];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i;
        }
        stack.push(15, elements);
        elements = stack.pop(15);

    }

}