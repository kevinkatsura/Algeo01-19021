package tubes;

import java.io.*;
import java.util.*;

public class MATRIKS {
	//atribut matriks
	protected float[][] Tab = new float [100][100];
    protected int NBrsEff;
    protected int NKolEff;
    
    public MATRIKS ()
    {
    	this.NBrsEff = 0;
    	this.NKolEff = 0;
    }
    
    public void KeyboardSPL(int m, int n)
    {
    	Scanner userInput = new Scanner(System.in);
    	
    	float [][] A= new float[m][n];
    	float [] B= new float[m];
        
        this.NBrsEff = m;
        this.NKolEff = n+1;
        
    	//menerima masukan koefisien a[i][j]
        System.out.println("Masukkan koefisien A[i][j] : ");
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.print("A["+(i+1)+"]["+(j+1)+"] = ");
                A[i][j]  = userInput.nextFloat();
            }
        }

        //menerima masukan koefisien b[i]
        System.out.println("Masukkan B[i] : ");
        for(int k = 0; k<m; k++)
        {
            System.out.print("B["+ (k+1) +"] = ");
            B[k]  = userInput.nextFloat();
        }

        //membentuk matriks augmented dari masukan yang ada
        for(int i = 0; i<this.NBrsEff; i++)
        {
            for(int j = 0; j<this.NKolEff-1; j++)
            {
                this.Tab[i][j]  = A[i][j];
            }
        }

        for (int k=0;k<this.NBrsEff;k++)
        {
            this.Tab[k][n]  = B[k];
        }
        userInput.close();
    }
    
    public void KeyboardDetBalikan (int n)
    {
    	Scanner userInput = new Scanner(System.in);
    	//menerima masukan koefisien a[i][j]
        
    	this.NBrsEff = n;
        this.NKolEff = n;
        
    	System.out.println("Masukkan koefisien A[i][j] : ");
        for(int i = 0; i<this.NBrsEff; i++)
        {
            for(int j = 0; j<this.NKolEff; j++)
            {
                System.out.print("A["+(i+1)+"]["+(j+1)+"] = ");
                this.Tab[i][j]  = userInput.nextFloat();
            }
        }
        userInput.close();
    }

    public void KeyboardInterpolasi (int n)
    {
    	Scanner userInput = new Scanner(System.in);
	
    	//melakukan inisiasi array
    	float [][] Titik= new float[n][2];
    
    	//menerima masukan koordinat x dan y sebanyak n titik
    	System.out.println("Masukkan titik : ");
    	for(int i = 0; i<n; i++)
    	{
    		System.out.print("Titik ke-"+(i+1)+" = ");
    		for(int j = 0; j<=1; j++)
    		{	
    			Titik[i][j]  = userInput.nextFloat();
    		}
    	}
    	
    	this.NBrsEff = n;
    	this.NKolEff = n+1;
    	//membuat masukan titik yang ada menjadi persamaan dan mengubahnya menjadi matriks augmented
    	for (int k=0; k<this.NBrsEff;k++ )
    	{
    		int m=0;
    		for (int l=0; l<this.NKolEff-1;l++)
    		{
    			this.Tab [k][l] = pangkat(Titik [k][0], l); 
    			m = m+1;
    		}
    		if (m==n)
    		{
    			this.Tab [k][m] = Titik [k][1];
    		}
    	}
    	userInput.close();
    }
    
    public void KeyboardRegresi (int n)
    {
    	
    }
    public void BacaFileMatriks (String namafile)
    {
    	try
    	{
    		File fileSaya = new File(namafile);
    		Scanner bacaBaris = new Scanner (fileSaya);
    		
    		if(bacaBaris.hasNextLine())
    		{
    			int elemen = 0;
    			String line = bacaBaris.nextLine();
    			line = line.trim();
    			
    			for (int i=0; i<line.length();i++)
				{
					if(line.charAt(i)==' ')
					{
						elemen += 1; 
					}
				}
    			elemen +=1;
    			
    			bacaBaris = new Scanner (fileSaya);
    			
    			int baris = 0, kolom = 0;
    			
    			while (bacaBaris.hasNextDouble())
    			{
    				this.Tab[baris][kolom] = bacaBaris.nextFloat();
    				kolom += 1;
    				if (kolom == elemen)
    				{
    					baris +=1;
    					kolom = 0;
    				}
    			}
    			
    			this.NBrsEff = baris;
    			this.NKolEff = elemen;
    			
    		}
    		else
    		{
    			System.out.println("File Kosong");
    		}
    
    	}
    	catch (FileNotFoundException e)
    	{
    		// apabila file tidak ditemukan
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
            e.printStackTrace();
    	}
    }
    
    public void BacaFileTitikInterpolasi (String namafile)
    {
    	MATRIKS M1 = new MATRIKS();
    	M1.BacaFileMatriks(namafile);
    	
    	MATRIKS MAug = new MATRIKS();
    	
    	int n = M1.NBrsEff;
    	MAug.NBrsEff = n;
    	MAug.NKolEff = n+1;
    	
    	//membuat masukan titik yang ada menjadi persamaan dan mengubahnya menjadi matriks augmented
    	for (int k=0; k<MAug.NBrsEff;k++ )
    	{
    		int m=0;
    		for (int l=0; l<MAug.NKolEff-1;l++)
    		{
    			MAug.Tab [k][l] = pangkat(M1.Tab[k][0], l); 
    			m = m+1;
    		}
    		if (m==n)
    		{
    			MAug.Tab [k][m] = M1.Tab[k][1];
    		}
    	}
    	
    	this.NBrsEff = n;
    	this.NKolEff = n+1;
    	for (int i = 0; i<this.NBrsEff; i++)
    	{
    		for (int j=0; j<this.NKolEff;j++)
    		{
    			this.Tab [i][j] = MAug.Tab[i][j]; 
    		}
    	}
    	
    }
    
    public void BacaFileRegresi (String namafile)
    {
    	
    }
    public float pangkat (float a, int b)
    {
    	//fungsi pangkat (mirip pow tapi untuk tipe float)
    	
    	//inisiasi variabel
    	float hasil = 1;
    	float temp = 0;

    	//penanganan jika pangkat 0 akan menghasilkan nilai 1
    	if (b==0)
    	{
    		hasil = 1;
    	}

    	//penanganan jika pangkat > 0
    	else
    	{
    		for (int i=1; i<=b;i++)
    		{
    			temp = hasil * a;
    			hasil = temp;
    		}
    	}

    	//mengembalikan hasil pangkat
    	return hasil;
    }

    public void TulisMatriks()
    {
        // Prosedur mencetak matriks

        for (int i=0; i<this.NBrsEff; i++)
        {
            for (int j=0; j<this.NKolEff; j++)
            {
            	System.out.print(this.Tab[i][j]+" ");
            }
            System.out.println();
        }
     }

   
}
