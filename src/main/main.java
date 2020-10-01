package tubes;

import java.util.*;
import java.io.*;
import java.lang.*;
import tubes.operator;
import tubes.MATRIKS;

public class main {
  public static void main(String[] args) {
	    Scanner userInput = new Scanner(System.in);
		
	    //menampilkan menu utama
	    System.out.println("MENU");
	    System.out.println("==============================================");
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
	    String namaFile;
	    
	    //validasi masukan sampai sesuai dengan pilihan yang ada
	    while (!check1)
	    	{
	    		System.out.print("Masukkan pilihan : ");
	    		pil_Operasi = userInput.nextInt();
	    		if (pil_Operasi==1)
	    		{
	    			check1=true;
	    			System.out.println("==============================================");
	    			System.out.println("1. Metode eliminasi Gauss");
	    			System.out.println("2. Metode eliminasi Gauss-Jordan");
	    			System.out.println("3. Metode matriks balikan");
	    			System.out.println("4. Kaidah Cramer");
	    			System.out.println("5. Keluar");
	    			
	    			while (!check2)
	    			{
	    				System.out.print("Masukkan pilihan : ");
	    				int pil_Metode1 = userInput.nextInt();
	        
	    				if (pil_Metode1==1)
	    				{
	    					check2=true;
	    					System.out.println("==============================================");
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    	    			System.out.println("3. Keluar");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    	    				pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					
	    	    					check3=true;
	    	    					MATRIKS M = new MATRIKS();
	    	    					System.out.print("Masukkan banyak persamaan (m) : ");
	    	    					int m = userInput.nextInt(); //Memasukkan banyak persamaan 
	    	    					System.out.print("Masukkan banyak peubah (n) : ");
	    	    					int n = userInput.nextInt(); //Memasukkan banyak peubah
	    	    					M.KeyboardSPL(m, n);
	    	    					
	    	    					
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    					Scanner file = new Scanner(System.in);
	    	    					MATRIKS M = new MATRIKS();
	    							System.out.print("Masukkan nama file eksternal (.txt): ");
	    							namaFile = file.nextLine(); // Memasukkan nama file eksternal data uji
									M.BacaFileMatriks(namaFile);
									
									
	    	    				}
	    	    				else if (pil_Masukan==3)
	    	    				{
	    	    					break;
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
	    					System.out.println("==============================================");
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    	    			System.out.println("3. Keluar");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    	    				pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    					MATRIKS M = new MATRIKS();
	    	    					System.out.print("Masukkan banyak persamaan (m) : ");
	    	    					int m = userInput.nextInt(); //Memasukkan banyak persamaan 
	    	    					System.out.print("Masukkan banyak peubah (n) : ");
	    	    					int n = userInput.nextInt(); //Memasukkan banyak peubah
	    	    					M.KeyboardSPL(m, n);
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    					Scanner file = new Scanner(System.in);
	    	    					MATRIKS M = new MATRIKS();
	    							System.out.print("Masukkan nama file eksternal (.txt): ");
	    							namaFile = file.nextLine(); // Memasukkan nama file eksternal data uji
									M.BacaFileMatriks(namaFile);
									
	    	    				}
	    	    				else if (pil_Masukan==3)
	    	    				{
	    	    					break;
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
	    					System.out.println("==============================================");
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    	    			System.out.println("3. Keluar");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    	    				pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    					MATRIKS M = new MATRIKS();
	    	    					System.out.print("Masukkan banyak persamaan (m) : ");
	    	    					int m = userInput.nextInt(); //Memasukkan banyak persamaan 
	    	    					System.out.print("Masukkan banyak peubah (n) : ");
	    	    					int n = userInput.nextInt(); //Memasukkan banyak peubah
	    	    					M.KeyboardSPL(m, n);

	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    					Scanner file = new Scanner(System.in);
	    	    					MATRIKS M = new MATRIKS();
	    							System.out.print("Masukkan nama file eksternal (.txt): ");
	    							namaFile = file.nextLine(); // Memasukkan nama file eksternal data uji
									M.BacaFileMatriks(namaFile);
									
	    	    				}
	    	    				else if (pil_Masukan==3)
	    	    				{
	    	    					break;
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
	    					System.out.println("==============================================");
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    	    			System.out.println("3. Keluar");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    	    				pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
	    	    					MATRIKS M = new MATRIKS();
	    	    					System.out.print("Masukkan banyak persamaan (m) : ");
	    	    					int m = userInput.nextInt(); //Memasukkan banyak persamaan 
	    	    					System.out.print("Masukkan banyak peubah (n) : ");
	    	    					int n = userInput.nextInt(); //Memasukkan banyak peubah
	    	    					M.KeyboardSPL(m, n);
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    					Scanner file = new Scanner(System.in);
	    	    					MATRIKS M = new MATRIKS();
	    							System.out.print("Masukkan nama file eksternal (.txt): ");
	    							namaFile = file.nextLine(); // Memasukkan nama file eksternal data uji
									M.BacaFileMatriks(namaFile);
	    	    				}
	    	    				else if (pil_Masukan==3)
	    	    				{
	    	    					break;
	    	    				}
	    	    				else 
	    	    				{
	    	    					System.out.println("Pilihan tidak tersedia");
	    	    	    			check3 = false;
	    	    				}
	    					}
	    				}
	    				else if (pil_Metode1==5)
	    				{
	    					break;
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
	    			System.out.println("==============================================");
	    			System.out.println("1. Metode reduksi baris");
	    			System.out.println("2. Metode ekspansi kofaktor");
	    			System.out.println("3. Keluar");
	    			
	    			while(!check2)
	    			{
	    				System.out.print("Masukkan pilihan : ");
	    				int pil_Metode2 = userInput.nextInt();
	        
	    				if (pil_Metode2 == 1)
	    				{
	    					check2=true;
	    					System.out.println("==============================================");
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    	    			System.out.println("3. Keluar");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    	    				pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;
<<<<<<< HEAD
									float[][] matriks = operator.keyboardDetBalikan();
									System.out.println();
									System.out.println("Mencari nilai Determinan dengan Metode Reduksi Baris");
									System.out.printf("Determinan : %f",operator.DeterminanReduksiBaris(matriks));
									System.out.println();
=======
	    	    					MATRIKS M = new MATRIKS();
	    	    					System.out.print("Masukkan banyak peubah (n) : ");
	    	    					int n = userInput.nextInt(); //Memasukkan banyak peubah
	    	    					M.KeyboardDetBalikan(n);
>>>>>>> 6feb5859c990ec75b000985368d3537878944525
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    					Scanner file = new Scanner(System.in);
	    	    					MATRIKS M = new MATRIKS();
	    							System.out.print("Masukkan nama file eksternal (.txt): ");
	    							namaFile = file.nextLine(); // Memasukkan nama file eksternal data uji
									M.BacaFileMatriks(namaFile);
	    	    				}
	    	    				else if (pil_Masukan==3)
	    	    				{
	    	    					break;
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
	    					check2=true;
	    					System.out.println("==============================================");
	    					System.out.println("1. Menerima masukan keyboard");
	    	    			System.out.println("2. Menerima masukan dari file");
	    	    			System.out.println("3. Keluar");
	    					while(!check3)
	    					{
	    						System.out.print("Masukkan pilihan : ");
	    	    				pil_Masukan = userInput.nextInt();
	    	    				if(pil_Masukan==1)
	    	    				{
	    	    					check3=true;

	    	    					MATRIKS M = new MATRIKS();
	    	    					System.out.print("Masukkan banyak peubah (n) : ");
	    	    					int n = userInput.nextInt(); //Memasukkan banyak peubah
	    	    					M.KeyboardDetBalikan(n);
	    	    				}
	    	    				else if (pil_Masukan==2)
	    	    				{
	    	    					check3=true;
	    	    					Scanner file = new Scanner(System.in);
	    	    					MATRIKS M = new MATRIKS();
	    							System.out.print("Masukkan nama file eksternal (.txt): ");
	    							namaFile = file.nextLine(); // Memasukkan nama file eksternal data uji
									M.BacaFileMatriks(namaFile);
	    	    				}
	    	    				else if (pil_Masukan==3)
	    	    				{
	    	    					break;
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
	    					break;
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
					System.out.println("==============================================");
					System.out.println("1. Menerima masukan keyboard");
	    			System.out.println("2. Menerima masukan dari file");
	    			System.out.println("3. Keluar");
					while(!check3)
					{
						System.out.print("Masukkan pilihan : ");
	    				pil_Masukan = userInput.nextInt();
	    				if(pil_Masukan==1)
	    				{
	    					check3=true;
	    					MATRIKS M = new MATRIKS();
	    					System.out.print("Masukkan banyak peubah (n) : ");
	    					int n = userInput.nextInt(); //Memasukkan banyak peubah
	    					M.KeyboardDetBalikan(n);
	    				}
	    				else if (pil_Masukan==2)
	    				{
	    					check3=true;
	    					Scanner file = new Scanner(System.in);
	    					MATRIKS M = new MATRIKS();
							System.out.print("Masukkan nama file eksternal (.txt): ");
							namaFile = file.nextLine(); // Memasukkan nama file eksternal data uji
							M.BacaFileMatriks(namaFile);
	    				}
	    				else if (pil_Masukan==3)
	    				{
	    					break;
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
					System.out.println("==============================================");
					System.out.println("1. Menerima masukan keyboard");
	    			System.out.println("2. Menerima masukan dari file");
	    			System.out.println("3. Keluar");
					while(!check3)
					{
						System.out.print("Masukkan pilihan : ");
	    				pil_Masukan = userInput.nextInt();
	    				float x;
	    				if(pil_Masukan==1)
	    				{
	    					check3=true;
	    					MATRIKS M = new MATRIKS();
	    					System.out.print("Masukkan banyak titik (n) : ");
	    					int n = userInput.nextInt(); //Memasukkan banyak titik
	    					M.KeyboardInterpolasi(n);
	    					System.out.print("Masukkan nilai yang akan ditaksir (x) : ");
	    					
	    				}
	    				else if (pil_Masukan==2)
	    				{
	    					check3=true;
	    					Scanner file = new Scanner(System.in);
	    					Scanner taksir = new Scanner(System.in);
	    					MATRIKS M = new MATRIKS();
							System.out.print("Masukkan nama file eksternal (.txt): ");
							namaFile = file.nextLine(); // Memasukkan nama file eksternal data uji
							M.BacaFileTitikInterpolasi(namaFile);
							System.out.print("Masukkan nilai yang akan ditaksir (x) : ");
	    					x = taksir.nextFloat(); //Memasukkan nilai yang ingin ditaksir 
	    				}
	    				else if (pil_Masukan==3)
	    				{
	    					break;
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
					System.out.println("==============================================");
					System.out.println("1. Menerima masukan keyboard");
	    			System.out.println("2. Menerima masukan dari file");
	    			System.out.println("3. Keluar");
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
	    				else if (pil_Masukan==3)
	    				{
	    					break;
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
	    			break;
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