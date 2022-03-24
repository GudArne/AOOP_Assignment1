/** 
    A first-in, first-out bounded collection of messages. 
*/ 
public class MessageQueue 
{ 
   private Message[] elements;
   private int head; 
   private int tail; 
   private int count; 
   /** 
       Constructs an empty message queue. 
       @param capacity the maximum capacity of the queue 
       @precondition capacity > 0
   */ 
   public MessageQueue(int capacity) 
   { 
      if(capacity < 1)
         throw new IllegalArgumentException("Capacity must be greater than 0");

      elements = new Message[capacity]; 
      count = 0; 
      head = 0; 
      tail = 0; 
   } 

   public Message getMessage(int index)
   {
      return elements[index];
   }

   /** 
       Remove message at head. 
       @return the message that has been removed from the queue
       @precondition size() > 0 
   */ 
   public Message remove() 
   { 
      Message r = elements[head]; 
      head = (head + 1) % elements.length; 
      count--; 
      return r; 
   } 

   /** 
       Append a message at tail. 
       @param aMessage the message to be appended 
       @precondition !isFull();
   */ 
   public void add(Message aMessage) 
   {  
      if(count == elements.length)
         increaseCapacity(this);
      if(count!=0)
         tail = (tail + 1) % elements.length;
      elements[tail] = aMessage; 
      count++; 
   } 

   /** 
       Get the total number of messages in the queue. 
       @return the total number of messages in the queue 
   */ 
   public int size() 
   { 
      return count; 
   } 

   /** 
       Checks whether this queue is full
       @return true if the queue is full
   */ 
   public boolean isFull()
   { 
      return count == elements.length; 
   } 

   /** 
       Get message at head. 
       @return the message that is at the head of the queue 
       @precondition size() > 0 
   */ 
   public Message peek() 
   { 
      return elements[head]; 
   }

   /* NOTE: will only be called when the list is full */
   public void increaseCapacity(MessageQueue elements) {
      MessageQueue newQue = new MessageQueue(elements.count*2);
      if(elements.tail < elements.head)
      {
         int helpVar = 0;
         for(int i = 0; i<elements.count*2 ; i++)
         {
            if(i == elements.tail+1)
               {
                  helpVar = i;
                  i += elements.count;
               }
            newQue.elements[i] = elements.getMessage(helpVar);
            helpVar++;    
         }
         elements.head += elements.count;
      }  
      else
      {
         for(int i = 0; i<elements.count; i++)
         {
            newQue.add(elements.getMessage(i));
         }
      }
      this.elements = newQue.elements;
   }

   public static void main(String[] args) {
      MessageQueue msgQ = new MessageQueue(1);
      msgQ.add(new Message("1"));
      msgQ.add(new Message("2"));
      msgQ.remove();
      msgQ.add(new Message("3"));
   }

}
