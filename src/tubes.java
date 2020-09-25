package tubes;

import java.util.*;
import java.lang.*; 

public class main {
  public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	
    System.out.println("MENU");
    System.out.println("1. Sistem Persamaaan Linier");
    System.out.println("2. Determinan");
    System.out.println("3. Matriks balikan");
    System.out.println("4. Interpolasi Polinom");
    System.out.println("5. Regresi linier berganda");
    System.out.println("6. Keluar");
    
    boolean check1 = false;
    boolean check2a = false;
    boolean check2b = false;
    
    while (!check1)
    	{
    		System.out.print("Masukkan pilihan : ");
    		int pil1 = userInput.nextInt();
    		if (pil1==1)
    		{
    			check1=true;
    			System.out.println("1. Metode eliminasi Gauss");
    			System.out.println("2. Metode eliminasi Gauss-Jordan");
    			System.out.println("3. Metode matriks balikan");
    			System.out.println("4. Kaidah Cramer");
    			
    			while (!check2a)
    			{
    				System.out.print("Masukkan pilihan : ");
    				int pil2a = userInput.nextInt();
        
    				if (pil2a==1)
    				{
    					check2a=true;
    				}
    				else if (pil2a==2)
    				{
    					check2a=true;
    				}
    				else if (pil2a==3)
    				{
    					check2a=true;
    				}
    				else if (pil2a==4)
    				{
    					check2a=true;
    				}
    				else 
    				{
    					System.out.println("Pilihan tidak tersedia");
    					check2a=false;
    				}
    			}
    		}
    	
    		else if (pil1==2)
    		{
    			
    			check1=true;
    			System.out.println("1. Metode reduksi baris");
    			System.out.println("2. Metode ekspansi kofaktor");
    	
    			while(!check2b)
    			{
    				System.out.print("Masukkan pilihan : ");
    				int pil2b = userInput.nextInt();
        
    				if (pil2b == 1)
    				{
    					check2b = true;
    				}
    				else if (pil2b==2)
    				{
    					check2b = true;
    				}
    				else 
    				{
    					System.out.println("Pilihan tidak tersedia");
    					check2b = false;
    				}
    			}
    		}
    		else if (pil1==3)
    		{
    			check1=true;
    		}
    		else if (pil1==4)
    		{
    			check1=true;
    		}
    		else if (pil1==5)
    		{
    			check1=true;
    		}
    		else if (pil1==6)
    		{
    			check1=true;
			System.exit(0); 
    		}
    		else 
    		{
    			System.out.println("Pilihan tidak tersedia");
    			check1 = false;
    		}
  
    	}
    }
}
