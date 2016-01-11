package model;

public class Hanoi { 
    
    private LIFO s1,s2,s3;

    public Hanoi(int s) { 
        s1 = new LIFO(s);
        s2 = new LIFO(s);
        s3 = new LIFO(s);
        this.fillHanoi(s);
        this.s1.numberElements = s; 
    }

    public void print() { 
        System.out.println("\n\t***HANOI TOWER***");
        for(int i=0;i<this.s1.stack.length;i++){
            System.out.println("|__" + this.s1.stack[i] + "__|  \t|__" + this.s2.stack[i] + "__|  \t|__" + this.s3.stack[i] + "__|  ");
        }
    }
    
    public void move(int number, Stack from, Stack to, Stack via){
        if(number>0){
            move(number-1,from, via, to);
            moveADisk(from, to);
            move(number-1, via, to, from);
        }
    }
    
    public void moveADisk(Stack from, Stack to){
        to.push(from.head());
        from.pop();
        this.print();
    }
    public void fillHanoi(int d){ 
        for (int i = 0; i < d; i++){
            s1.push(i+1);
        }
    }
    
    public void solve(){
        move(s1.getNumberOfElements(), s1, s2, s3); 
    }
}
