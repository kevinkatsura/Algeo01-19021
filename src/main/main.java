package main;

import java.util.*;
import java.lang.*;
import tubes.operator;

public class main {
  public static void main(String[] args) {
	    Scanner userInput = new Scanner(System.in);
		
	    //menampilkan menu utama
	    System.out.println("MENU");
	    System.out.println("1. Sistem Persamaaan Linier");
	    System.out.println("2. Determinan");
	    System.out.println("3. Matriks balikan");
	    System.out.println("4. Interpolasi Polinom");
	    System.out.println("5. Regresi linier berganda");
	    System.out.println("6. Keluar");
	    
	    boolean check1 = false;
	    boolean check2 = false;
	    boolean check3 = false;
	    int pil_Masukan, pil_Operasi;
	    
	    //validasi masukan sampai sesuai dengan pilihan yang ada
	    while (!check1)
	    	{
	    		System.out.print("Masukkan pilihan : ");
	    		pil_Operasi = userInput.nextInt();
	    		if (pil_Operasi==1)
	    		{
	    			check1=true;
	    			System.out.println("1. Metode eliminasi Gauss");
	    			System.out.println("2. Metode eliminasi Gauss-Jordan");
	    			System.out.println("3. Metode matriks balikan");
	    			System.out.println("4. Kaidah Cramer");
	    			
	    			while (!check2)
	    			{
	    				System.out.print("Masukkan pilihan : ");
	    				int pil_Metode1 = userInput.nextInt();
	        
	    				if (pil_Metode1==1)
	    				{
	    					check2=true;
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    	    				pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    					operator.keyboardSPL();
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else 
	    	    				{
	    	    					System.out.println("Pilihan tidak tersedia");
	    	    	    			check3 = false;
	    	    				}
	    					}
	    				}
	    				else if (pil_Metode1==2)
	    				{
	    					check2=true;
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    						pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else 
	    	    				{
	    	    					System.out.println("Pilihan tidak tersedia");
	    	    	    			check3 = false;
	    	    				}
	    					}
	    				}
	    				else if (pil_Metode1==3)
	    				{
	    					check2=true;
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    						pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else 
	    	    				{
	    	    					System.out.println("Pilihan tidak tersedia");
	    	    	    			check3 = false;
	    	    				}
	    					}
	    				}
	    				else if (pil_Metode1==4)
	    				{
	    					check2=true;
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    						pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else 
	    	    				{
	    	    					System.out.println("Pilihan tidak tersedia");
	    	    	    			check3 = false;
	    	    				}
	    					}
	    				}
	    				else 
	    				{
	    					System.out.println("Pilihan tidak tersedia");
	    					check2=false;
	    				}
	    			}
	    		}
	    	
	    		else if (pil_Operasi==2)
	    		{
	    			
	    			check1=true;
	    			System.out.println("1. Metode reduksi baris");
	    			System.out.println("2. Metode ekspansi kofaktor");
	    	
	    			while(!check2)
	    			{
	    				System.out.print("Masukkan pilihan : ");
	    				int pil_Metode2 = userInput.nextInt();
	        
	    				if (pil_Metode2 == 1)
	    				{
	    					check2 = true;
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    	    				pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else 
	    	    				{
	    	    					System.out.println("Pilihan tidak tersedia");
	    	    	    			check3 = false;
	    	    				}
	    					}
	    				}
	    				else if (pil_Metode2==2)
	    				{
	    					check2 = true;
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    						pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    				}
	    	    				else 
	    	    				{
	    	    					System.out.println("Pilihan tidak tersedia");
	    	    	    			check3 = false;
	    	    				}
	    					}
	    				}
	    				else 
	    				{
	    					System.out.println("Pilihan tidak tersedia");
	    					check2 = false;
	    				}
	    			}
	    		}
	    		else if (pil_Operasi==3)
	    		{
	    			check1=true;
	    			System.out.println("1. Menerima masukan keyboard");
	    			System.out.println("2. Menerima masukan dari file");
					while(!check3)
					{
						System.out.print("Masukkan pilihan : ");
						pil_Masukan = userInput.nextInt();
	    				if(pil_Masukan==1)
	    				{
	    					check3=true;
	    				}
	    				else if (pil_Masukan==2)
	    				{
	    					check3=true;
	    				}
	    				else 
	    				{
	    					System.out.println("Pilihan tidak tersedia");
	    	    			check3 = false;
	    				}
					}
	    		}
	    		else if (pil_Operasi==4)
	    		{
	    			check1=true;
	    			System.out.println("1. Menerima masukan keyboard");
	    			System.out.println("2. Menerima masukan dari file");
					while(!check3)
					{
						System.out.print("Masukkan pilihan : ");
						pil_Masukan = userInput.nextInt();
	    				if(pil_Masukan==1)
	    				{
	    					check3=true;
	    				}
	    				else if (pil_Masukan==2)
	    				{
	    					check3=true;
	    				}
	    				else 
	    				{
	    					System.out.println("Pilihan tidak tersedia");
	    	    			check3 = false;
	    				}
					}
	    		}
	    		else if (pil_Operasi==5)
	    		{
	    			check1=true;
	    			System.out.println("1. Menerima masukan keyboard");
	    			System.out.println("2. Menerima masukan dari file");
					while(!check3)
					{
						System.out.print("Masukkan pilihan : ");
						pil_Masukan = userInput.nextInt();
	    				if(pil_Masukan==1)
	    				{
	    					check3=true;
	    				}
	    				else if (pil_Masukan==2)
	    				{
	    					check3=true;
	    				}
	    				else 
	    				{
	    					System.out.println("Pilihan tidak tersedia");
	    	    			check3 = false;
	    				}
					}
	    		}
	    		else if (pil_Operasi==6)
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
	    userInput.close();    
  }
 
}