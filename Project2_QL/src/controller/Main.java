package controller;
import model.*;
import java.util.Scanner;

public class Main { 
    @SuppressWarnings("resource")
	public static void main(String args[]) throws Exception{
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many disks ? ");
        int nb = sc.nextInt();
        if(nb <= 0)
        	throw new Exception();
        
        Hanoi tower = new Hanoi(nb);
        tower.print();
        tower.solve();
    } 
}
