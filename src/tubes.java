package tubes;

import java.util.*;
import java.lang.*;
import java.io.*;

public class tubes {
  static int [][] inputSPL()
  {
	  //membaca masukan dari keyboard
	  Scanner userInput = new Scanner(System.in);
	  System.out.print("Masukkan banyak persamaan (m) : ");
	  int m = userInput.nextInt();
	  System.out.print("Masukkan banyak peubah (n) :");
	  int n = userInput.nextInt();
	  //melakukan inisiasi array
	  int [][] A= new int[m][n];
	  int [] B= new int[m];
	  
	  System.out.println("Masukkan koefisien A[i][j] : ");
	  //menerima masukan koefisien a[i][j]
	  for(int i = 0; i<m; i++)
	  {
		  for(int j = 0; j<n; j++)
		  {
			  System.out.print("A["+(i+1)+"]["+(j+1)+"] = ");
			  A[i][j]  = userInput.nextInt();
		  }
	  }
	  
	  //menerima masukan koefisien b[i]
	  System.out.println("Masukkan B[i] : ");
	  for(int k = 0; k<m; k++)
	  {
		  System.out.print("B["+ (k+1) +"] = ");
		  B[k]  = userInput.nextInt();
	  }
	  
	  int [][] Matriks = new int [m][n+1];

	  //membentuk matriks augmented dari masukan yang ada
	  for(int i = 0; i<m; i++)
	  {
		  for(int j = 0; j<n; j++)
		  {
			  Matriks[i][j]  = A[i][j];
		  }
	  }
	  
	  for (int k=0;k<m;k++)
	  {
		  Matriks[k][n]  = B[k];
	  }
	  return Matriks;
  }

  private static void bacaSPL()
  {
	 //membaca masukan dari file text berbentuk matriks augmented 
	 Scanner userInput = new Scanner(System.in);
	 String namafile = userInput.nextLine();
	 try 
	 {
		 // membaca file
         File myFile = new File(namafile);
         Scanner fileReader = new Scanner(myFile);
         
         // cetak isi file
         while(fileReader.hasNextLine()){
             String data = fileReader.nextLine();
             System.out.println(data);
         }
	 } 
	 catch (FileNotFoundException e) 
	 {
		// apabila file tidak ditemukan
         System.out.println("Terjadi Kesalahan: " + e.getMessage());
         e.printStackTrace();
     }
  }
  
  
 
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
    	    					inputSPL();
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
    }

	public static float DeterminanKofaktor(int[][] matriks ) {
		float det = 0;
		if ((matriks.length == 2) && (matriks[0].length == 2)){
			det =(matriks[0][0]*matriks[1][1]) - (matriks[0][1]*matriks[1][0]);
			return det;
		}
		else{
			int i,j,k;
			int[][] Mtemp = new int[matriks.length-1][matriks[0].length-1];
			for (k = 0; k < matriks[0].length; k++){
				for (i=1; i < matriks.length; i++){
					for(j=0; j < matriks[0].length; j++){
						if (j>k){
							Mtemp[i-1][j-1] = matriks[i][j];
						}
						else{
							Mtemp[i-1][j] = matriks[i][j] ;
						}
					}
				}
				if (k%2 ==0){
					det += matriks[0][k]*DeterminanKofaktor(Mtemp);
				}
				else{
					det -= matriks[0][k]*DeterminanKofaktor(Mtemp);
				}
			}
			return det;

		}
	}

	public static int DeterminanReduksiBaris(int[][] matriks) {
  		int representation ;
		for (int i = 1; i < matriks.length; i++) {
			for (int j = 0; j < i ; j++) {
				representation1 = matriks[i-1][j] ;
				representation2 = matriks[i][j] ;
				for (int k = 0; k < matriks[0].length ; k++) {
					matriks[i][k] = matriks[i][k]-(matriks[i-1][k]/representation1)*representation2 ;
				}

			}
		}
		float det = 1 ;
		for (int i = 0; i < matriks.length; i++) {
			det *= matriks[i][i] ;
		}
		return det ;
	}
}