package model;

public class LIFO extends Stack{

	/*
	 * Constructor 
	 */
    public LIFO(int s) {
        super(s); 
    }
    
    /*
	 *  Return the head of the stack
	 */
    @Override
    public int head() throws IllegalStateException {
    	if(this.getNumberOfElements()>0)
    		return this.head; 
    	else
    		throw new IllegalStateException("Stack is empty");
    }
    
    /*
	 * Push an element into the stack
	 * --> if the stack is full, it's not possible to push 
	 */
    @Override
    public void push(int x) throws IllegalStateException {
        if(isFull()) { 
            System.out.println("[PUSH/LIFO] Cannot PUSH '" + x + "', Stack full");
            throw new IllegalStateException("Stack is full");
        }
        else {
            this.stack[numberElements] = x;
            this.numberElements++;
            this.head = x;
        }
    }
    
    /*
	 * Pop the last element from the stack
	 * --> if the stack is empty, it's not possible to pop (it returns -1) 
	 */
    @Override
    public int pop() throws IllegalStateException{
        int x = -1;
    	if(this.isEmpty()) {
            System.out.println("[POP/LIFO] : Cannot POP, Stack empty!");
            throw new IllegalStateException("Stack is empty");
        }
        else {
        	this.numberElements--;
        	x = this.stack[numberElements];
            this.stack[numberElements] = -1;
            
            if(this.numberElements>0) {
				int y = this.numberElements-1;
				this.head = this.stack[y];
			}
			else
				this.head = -1;
        }
        return x;
    };
}
