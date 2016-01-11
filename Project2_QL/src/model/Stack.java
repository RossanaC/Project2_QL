package model;

/*
 * Abstract class Stack used to implement LIFO and FIFO
 */
public abstract class Stack { 
    
    protected int stack []; 
    protected int head;
    protected int numberElements;
    
    /*
	 * Constructor 
	 */
    public Stack(int s) {
        this.stack = new int [s];
        this.initStack();
    }
    
    public void initStack() {
        for (int i=0; i<this.stack.length;i++)
            this.stack[i] = -1;
        
        this.numberElements = 0;
        this.head = -1;
    }
    
    /*
	 * Return the fixed size of the stack 
	 */
    public int getSize() {
    	return stack.length;
    }
    /*
	 * Return the number of the elements inside the stack 
	 */
    public int getNumberOfElements(){ 
    	return numberElements;
    }
    /*
	 * --> return true if the stack is completely full
	 * --> return false if contains less elements than the total dimension of the stack 
	 */
    public boolean isFull() { 
    	return (stack.length == numberElements) ? true:false;
    }
    /*
	 * --> return true if the stack is empty
	 * --> return false if the stack contains at least 1 element 
	 */
    public boolean isEmpty(){ 
    	return (numberElements == 0) ? true:false; 
    }
    
    /*
	 * Push an element on the top of the stack 
	 */
    public abstract void push(int x) throws IllegalStateException;
    
    /*
	 * Return the last element
	 */
    public abstract int head() throws IllegalStateException;
        
    /*
	 * Pop the last element
	 */
    public abstract int pop() throws IllegalStateException;
    
    public void copy(Stack toS) {
        if(toS.isEmpty()){
            for(int i = this.getNumberOfElements(); i >= 1; i--) {
                toS.push(this.stack[i-1]);
            }
            toS.numberElements = this.getNumberOfElements();
        }
        else {
            System.out.println("Cannot copy: destination stack is not empty");
        }
    }
}
