public class MessageStack{

    Message[] stack = null;
    int capacity = 0;
    int size = 0;
    int top = -1;    

    MessageStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Message[capacity];
    }

    public boolean contains(Message element){
        for (int i = 0; i < size; i++) {
            if(stack[i] == element)
                return true;
        }
        return false;
    }

    public void push(Message element){
        if(size == capacity)
            throw new IndexOutOfBoundsException("Stack is full");
        top++;
        stack[top] = element;
        size++;
        
    }

    public void push(int n, Message[] elements){
        if(n > 0 && elements.length > 0){
            if(n > capacity-size)
                throw new IndexOutOfBoundsException("Stack will be full, needs atleast " + (n-capacity-size) + " more spots..");
            for (int i = 0; i < n; i++) {
                push(elements[i]);
            }
        }
    }

    public Message pop(){
        Message retval;
        if(size == 0)
            throw new IndexOutOfBoundsException("Stack is empty");
        
        retval = stack[top];
        stack[top] = null;
        top--;
        size--; 
        return retval;
    }
    public Message[] pop(int n){
        if(n > size)
            throw new IndexOutOfBoundsException("Stack has fewer elements than " + n);

        Message tempList[] = new Message[n];

        for(int i = 0; i<n; i++)
        {
            tempList[i] = pop();
        }
        return tempList;
    }
    

    public static void main(String args[]) {
        MessageStack stack = new MessageStack(15);
        String s ="";

        for (int i = 0; i < 10; i++) {
                
            stack.push(new Message(s+i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

        Message elements[] = new Message[15];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Message(s+i);
        }
        stack.push(15, elements);
        elements = stack.pop(15);

    }

}