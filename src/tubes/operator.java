package tubes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class operator {
    public static float [][] inputSPL()
    {
        //membaca masukan dari keyboard
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan banyak persamaan (m) : ");
        int m = userInput.nextInt();
        System.out.print("Masukkan banyak peubah (n) :");
        int n = userInput.nextInt();
        //melakukan inisiasi array
        float [][] A= new float[m][n];
        float [] B= new float[m];

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

        float [][] Matriks = new float [m][n+1];

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
            int indeksFound = 0;
            int i = 0 ;
            while(i < matriks[l].length && indeksFound != 0){
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

}
