package tubes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class operator {
    public static float [][] keyboardSPL()
    {
        //membaca masukan banyak persamaan dan peubah dari keyboard 
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan banyak persamaan (m) : ");
        int m = userInput.nextInt();
        System.out.print("Masukkan banyak peubah (n) : ");
        int n = userInput.nextInt();

        //melakukan inisiasi array
        float [][] A= new float[m][n];
        float [] B= new float[m];
	float [][] Matriks = new float [m][n+1];

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
	userInput.close();

	//mengembalikan matriks berupa matriks augmented
        return Matriks;
    }
    
    public static float [][] keyboardDetBalikan()
    {
        //membaca masukan ukuran matriks dari keyboard
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan ukuran matriks (n) : ");
        int n = userInput.nextInt();
       
        //melakukan inisiasi array
        float [][] Matriks= new float[n][n];
        
        //menerima masukan koefisien a[i][j]
	System.out.println("Masukkan koefisien A[i][j] : ");
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.print("A["+(i+1)+"]["+(j+1)+"] = ");
                Matriks[i][j]  = userInput.nextFloat();
            }
        }
        userInput.close();
	
	//mengembalikan matriks
        return Matriks;
    }

    public static float pangkat (float a, int b)
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

    public static float [][] keyboardInterpolasi()
    {
	//membaca masukan banyak titik dari keyboard
	Scanner userInput = new Scanner(System.in);
	System.out.print("Masukkan banyak titik (n) :");
        int n = userInput.nextInt();
        
	//melakukan inisiasi array
        float [][] Titik= new float[n][2];
	float [][] Matriks = new float [n][n+1];
        
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
        
        //membuat masukan titik yang ada menjadi persamaan dan mengubahnya menjadi matriks augmented
        for (int k=0; k<n;k++ )
        {
        	int m=0;
        	for (int l=0; l<n;l++)
        	{
        		Matriks [k][l] = pangkat(Titik [k][0], l); 
        		m = m+1;
        	}
        	if (m==n)
        	{
        		Matriks [k][m] = Titik [k][1];
        	}
        }
	userInput.close();

	//mengembalikan matriks berupa matriks augmented
        return Matriks;
    }

    public static void tukarBaris(float[][] Matriks, int i, int j)
    {
        //tukar elemen baris i dengan baris j
        int N = Matriks.length;
        for (int k=0; k<=N; k++)
        {
            float Temp = Matriks[i][k];
            Matriks[i][k] = Matriks[j][k];
            Matriks[j][k] = Temp;
        }
    }

    public static void bacaSPL()
    {
        //kamus
        int baris=0, kolom=0;
        float[][]Matriks;

        //membaca masukan dari file text berbentuk matriks augmented
        Scanner userInput = new Scanner(System.in);
        String namafile = userInput.nextLine();
        try
        {
            // membaca file
            File myFile = new File(namafile);
            Scanner fileReader = new Scanner(myFile);

            // menentukan banyak baris/kolom
            while(fileReader.hasNextLine())
            {
                baris++;
                Scanner Kolom = new Scanner(fileReader.nextLine());
                {
                    while(Kolom.hasNextFloat())
                    {
                        kolom++;
                    }
                }

            }
            Matriks = new float [baris][kolom];
            fileReader.close();
            Matriks = bacaMatriks(namafile,baris,kolom);
        }

        catch (FileNotFoundException e)
        {
            // apabila file tidak ditemukan
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
        userInput.close();
    }
    public static float[][] bacaMatriks (String myFile, int brs, int klm) throws FileNotFoundException
    {
        float [][]Matriks = new float[brs][klm];

        Scanner fileReader = new Scanner(myFile);
        for (int a=0; a<brs;a++)
        {
            for (int b=0; b<klm;b++)
            {
                if(fileReader.hasNextFloat())
                {
                    Matriks[a][b]=fileReader.nextFloat();
                }
            }
        }
        fileReader.close();
        return Matriks;
    }
    public static float DeterminanKofaktor(float[][] matriks ) {
        float det = 0;
        if ((matriks.length == 2) && (matriks[0].length == 2)){
            det =(matriks[0][0]*matriks[1][1]) - (matriks[0][1]*matriks[1][0]);
            return det;
        }
        else{
            int i,j,k;
            float[][] Mtemp = new float[(matriks.length)-1][(matriks[0].length)-1];
            for (k = 0; k < matriks[0].length; k++){
                for (i=1; i < matriks.length; i++){
                    for(j=0; j < matriks[0].length; j++){
                        if (j>k){
                            Mtemp[i-1][j-1] = matriks[i][j];
                        }
                        else{
                            if (j==k){continue;}
                            else {
                                Mtemp[i - 1][j] = matriks[i][j];
                            }
                        }
                    }
                }
                if (k%2 == 0){
                    det += matriks[0][k]*DeterminanKofaktor(Mtemp);
                }
                else{
                    det -= matriks[0][k]*DeterminanKofaktor(Mtemp);
                }
            }
            return det;

        }
    }
    public static float DeterminanReduksiBaris(float[][] matriks) {
        float representation1,representation2 ;

        for (int i = 1; i < matriks.length; i++) {
            for (int j = 0; j < i ; j++) {
                representation1 = matriks[i-1][j] ;
                representation2 = matriks[i][j] ;
                for (int k = j; k < matriks[0].length ; k++) {
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
    static float[][] SPLGauss(float[][] matriks) {

        float representation1,representation2 ;
        for (int i = 1; i < matriks.length; i++) {
            for (int j = 0; j < i ; j++) {
                representation1 = matriks[i-1][j] ;
                representation2 = matriks[i][j] ;
                for (int k = j; k < matriks[0].length ; k++) {
                    matriks[i][k] = matriks[i][k]-(matriks[i-1][k]/representation1)*representation2 ;
                }

            }
        }
        for (int l = 0; l < matriks.length; l++) {
            int indeksFound = -1;
            int i = 0 ;
            while(i < matriks[l].length && indeksFound == -1){
                if (matriks[l][i] != 0){
                    indeksFound = i ;
                }
                i++ ;
            }
            float temp = matriks[l][indeksFound] ;
            for (int m = i; m < matriks[l].length; m++) {

                matriks[l][m] = matriks[l][m]/temp ;
            }

        }
        return matriks ;
    }

    public static float[][] SPLGaussJordan(float[][] matriksinput) {
        float[][] matriks = SPLGauss(matriksinput) ;
        for (int i = matriks.length-1; i >= 1 ; i--) {
            int indeksFound = -1;
            int l = 0 ;
            while(l < matriks[i].length && indeksFound == -1){
                if (matriks[i][l] != 0){
                    indeksFound = l ;
                }
                l++ ;
            }
            float rep1 = matriks[i][indeksFound] ;
            if (l != matriks[i].length) {
                for (int j = i-1; j >= 0; j--) {
                    float rep2 = matriks[j][indeksFound] ;
                    for (int k = 0; k < matriks[j].length; k++) {
                        matriks[j][k] = matriks[j][k] - (matriks[i][k]/rep1)*rep2 ;
                    }
                }
            }
        }
        return matriks ;
    }
    public static float [] Cramer(float matriks [][])
    {
        /* I.S : persamaan dengan n peubah n persamaan
                 input berupa matriks augmented */
        /* F.S : menghasilkan array yang berisikan nilai peubah */

        // memisahkan matriks augmented menjadi 2 matriks biasa
        int i,j,k;
        int m = matriks.length;

        float [][]A = new float [m][m];
        float []B = new float [m];
        float []res = new float[m];
        for (i=0; i<m; i++){
            for (j=0; j<m; j++){
                A[i][j] = matriks[i][j];
            }
        }
        for (i=0; i<m; i++){
            B[i] = matriks[i][matriks[0].length-1];
        }
        // mencari determinan matriks
        float detA = DeterminanKofaktor(A);
        // mencari determinan peubah (Dx, Dy, dst..)
        for (k =0; k<m; k++){
            // mengembalikan  matriks A
            for (i=0; i<m; i++){
                for (j=0; j<m; j++){
                    A[i][j] = matriks[i][j];
                }
            }
            for (i=0; i<m; i++){
                A[i][k] = B[i];
            }
            float Dx = DeterminanKofaktor(A);
            res[k] = Dx/detA;
        }

        return res;
    }
    public static float [][] Transpose ( float[][] Matriks)
    {
        int i,j;
        int baris = Matriks.length;
        int kolom = Matriks[0].length;
        float [][] Mtrans = new float [kolom][baris];
        for (i=0; i<kolom; i++){
            for (j=0; j<baris; j++){
                Mtrans[i][j] = Matriks[j][i];
            }
        }
        return Mtrans;
    }

    public static float [][] Adjoint ( float [][] Matriks)
    {
        // I.S  : Matriks yang di input merupakan matriks bujursangkar
        // F.S  : Mengembalikan matriks adjoint matriks inputan

        int i,j,k,l;
        int len = Matriks.length;

        float[][] Mtemp = new float[len-1][len-1];
        float[][] Adj = new float [len][len];

        if (len==2){
            Adj[0][0] = Matriks[1][1];
            Adj[0][1] = -Matriks[1][0];
            Adj[1][0] = -Matriks[0][1];
            Adj[1][1] = Matriks[0][0];
        }
        else {
            for (k = 0; k < len; k++) {
                for (l = 0; l < len; l++) {
                    for (i = 0; i < len; i++) {
                        for (j = 0; j < len; j++) {
                            if (i == k) {
                                continue;
                            } else {
                                if (j == l) {
                                    continue;
                                } else {
                                    if ((i > k) && (j > l)) {
                                        Mtemp[i - 1][j - 1] = Matriks[i][j];
                                    } else if ((i > k) && (j < l)) {
                                        Mtemp[i - 1][j] = Matriks[i][j];
                                    } else if ((i < k) && (j > l)) {
                                        Mtemp[i][j - 1] = Matriks[i][j];
                                    } else {
                                        Mtemp[i][j] = Matriks[i][j];
                                    }
                                }
                            }
                        }
                    }
                    if ((k + l) % 2 == 0) {
                        Adj[k][l] = DeterminanKofaktor(Mtemp);
                    } else {
                        Adj[k][l] = -DeterminanKofaktor(Mtemp);
                    }
                }
            }
            // Mentranspose kofaktor matriks (Adj)
            Adj = Transpose(Adj);
        }
        return Adj;
    }
    public static float [][] MatriksInvers (float [][] Matriks)
    {
        // I.S      : Matriks masukan merupakan matriks persegi
        // F.S      : mengembalikan matriks invers dari matriks masukan

        int i,j;
        int len = Matriks.length;
        float [][] Adj;
        float [][] MInvers = new float[len][len];
        float faktor;
        faktor = 1/DeterminanKofaktor(Matriks);
        Adj = Adjoint(Matriks);

        for (i=0; i<len; i++){
            for (j=0; j<len; j++){
                MInvers[i][j] = faktor*Adj[i][j];
            }
        }
        return MInvers;
    }
    public static void TulisMatriks(float [][] Matriks)
    {
        // Prosedur mencetak matriks
        int i,j;
        int baris = Matriks.length;
        int kolom = Matriks[0].length;

        for (i=0; i<baris; i++){
            for (j=0; j<kolom; j++){
                if (j==kolom-1){
                    System.out.println(Matriks[i][j]);
                }
                else {
                    System.out.print(Matriks[i][j]+" ");
                }
            }
        }
    }
}
