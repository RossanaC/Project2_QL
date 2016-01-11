package model;

public class FIFO extends Stack {

    private LIFO l1, l2; 
    
    public FIFO(int s) {
        super(s); 
        l1 = new LIFO(s);
        l2 = new LIFO(s); 
    }

    @Override
    public int head() throws IllegalStateException {
    	if(l1.getNumberOfElements()>0)
    		return l1.stack[0];
    	else
    		throw new IllegalStateException();
    }
    
    public int tail() {
    	return l1.head;
    }
    
    @Override
    public int getSize() {
    	return l1.stack.length;
    }

    @Override
    public int getNumberOfElements(){ 
    	return l1.getNumberOfElements();
    }
    
    @Override
    public boolean isFull() { 
    	return (l1.stack.length == l1.getNumberOfElements()) ? true:false;
    }
    
    @Override
    public boolean isEmpty(){ 
    	return (l1.getNumberOfElements() == 0) ? true:false; 
    }
    

    @Override
    public void push(int x) throws IllegalStateException { 
        l1.push(x);
    } 
    
    @Override
    public int pop() throws IllegalStateException {
    	int x = -1;
    	if (l2.isEmpty()){
            //Copy l1 into l2
            l1.copy(l2);
            x = l2.pop();
            l1.initStack();
            //Copy l2 into l1
            l2.copy(l1);
            l2.initStack(); 
        }
    	return x;
    }
}
