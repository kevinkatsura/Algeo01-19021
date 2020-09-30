package tubes;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
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
    
    public static float [][] inputDet()
    {
        //membaca masukan dari keyboard
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan banyak peubah (n) :");
        int n = userInput.nextInt();
        //melakukan inisiasi array
        float [][] A= new float[n][n];
        

        System.out.println("Masukkan koefisien A[i][j] : ");
        //menerima masukan koefisien a[i][j]
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.print("A["+(i+1)+"]["+(j+1)+"] = ");
                A[i][j]  = userInput.nextInt();
            }
        }

        userInput.close();
        return A;
    }

    public static double [][] inputInterpolasi()
    {
	//membaca masukan dari keyboard
	Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan banyak titik (n) :");
        int n = userInput.nextInt();
        //melakukan inisiasi array
        double [][] Titik= new double[1][n];

        System.out.println("Masukkan titik : ");
        //menerima masukan koefisien a[1][n]
        for(int i = 0; i<=n; i++)
        {
        	for(int j = 0; j<=1; j++)
            {	
        		System.out.print("Titik ke-"+i+" = ");
        		Titik[i][j]  = userInput.nextInt();
        
            }
        }
        double [][] Matriks = new double [n][n-1];
        
        
        for (int k=0; k<n;k++ )
        {
        	int m=0;
        	for (int l=0; l<n;l++)
        	{
        		Matriks [k][l] = Math.pow(Titik [k][0], l); 
        		m = m+1;
        	}
        	if (m==n)
        	{
        		Matriks [k][m] = Titik [k][1];
        	}
        }
        userInput.close();
        return Matriks;
    }

    public static void tukarBaris(float[][] Matriks, int i, int j)
    {
        //tukar elemen baris i dengan baris j
        int N = Matriks[i].length-1;
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
        for (int n = 0; n < matriks.length-1 ; n++) {
            for (int i = n+1; i < matriks.length; i++) {
                float rep = matriks[i][n] ;
                for (int k = n; k < matriks[0].length; k++) {
                    matriks[i][k] = matriks[i][k] - ((matriks[n][k] * rep) / matriks[n][n]);
                }
            }
        }
        float det = 1 ;
        for (int i = 0; i < matriks.length; i++) {
            det *= matriks[i][i] ;
        }
        return det ;
    }
    public static float[][] SPLGauss(float[][] matriks) {

        for (int n = 0; n < matriks.length-1 ; n++) {
            for (int i = n+1; i < matriks.length; i++) {
                float rep = matriks[i][n] ;
                for (int k = n; k < matriks[0].length; k++) {
                    matriks[i][k] = matriks[i][k] - ((matriks[n][k] * rep) / matriks[n][n]);
                }
            }
            for (int i = n+1; i < matriks.length; i++) {
                if(matriks[i][n+1] == 0 && i != matriks.length-1){
                    int j = matriks.length-1 ;
                    boolean found = (matriks[j][n+1] != 0) ;
                    while(!found && j > i ){
                        if (matriks[j][n+1] != 0){
                            found = true ;
                        }
                        else{
                            j-- ;
                        }
                    }
                    if (found){
                        tukarBaris(matriks,i,j);
                    }
                }
            }
        }

        for (int l = 0; l < matriks.length; l++) {
            int indeksFound = -1;
            int i = 0 ;
            boolean found = (matriks[l][i] != 0) ;
            while(i < matriks[l].length-1 && !found ){
                if (matriks[l][i] != 0){
                    indeksFound = i ;
                    found = true ;
                }
                i++ ;
            }
            if (indeksFound != -1) {
                float temp = matriks[l][indeksFound];
                for (int m = indeksFound; m < matriks[l].length; m++) {

                    matriks[l][m] = matriks[l][m] / temp;
                }
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

    public static float[][] KaliMatriks(float[][] matriks1, float[][] matriks2) {
        float [][] matriks = new float[matriks1.length][matriks2[0].length] ;
        if (matriks1[0].length == matriks2.length){
            for (int i = 0; i < matriks1.length; i++) {
                for (int j = 0; j < matriks2[0].length ; j++) {
                    int sum = 0 ;
                    for (int k = 0; k < matriks2.length ; k++) {
                        sum += matriks1[i][k]*matriks2[k][j] ;
                    }
                    matriks[i][j] = sum ;
                }
            }
        }
        return matriks ;
    }

    public static void MenulisSolusiSPLGauss(float[][] matriks) {
        if (matriks.length == matriks[0].length-1){
            for (int i = 0 ; i <= matriks.length-2 ; i++) {
                for (int j = i+1; j <= matriks.length-1 ; j++) {
                    for (int k = 0; k < matriks[i].length; k++) {
                        matriks[i][k] = matriks[i][k] - matriks[j-1][j]*matriks[j][k] ;
                    }
                }
            }
            boolean found = false ;
            for (int i = matriks.length-1; i>=0; i--) {
                int k = 0 ;
                while(!found && k < matriks[i].length){
                    if (k == matriks[i].length-1 && matriks[i][k] != 0){
                        found = true ;
                    }
                    else{
                        k++ ;
                    }
                }
                if (found){
                    System.out.println("Matriks Tidak Memiliki Solusi");
                    break ;
                }
            }
            if (!found){
                for (int i = 0 ; i <= matriks.length-2 ; i++) {
                    if (matriks[i][i] != 0 ) {
                        System.out.printf("X%d = %.2f\n", (i + 1), matriks[i][matriks[i].length - 1]);
                        if (i == (matriks.length - 2) && matriks[i+1][i+1] != 0 ) {
                            System.out.printf("X%d = %.2f\n", (i + 2), matriks[i + 1][matriks[i + 1].length - 1]);
                        }
                    }
                }
            }
        }
        else{
            for (int i = 0; i < matriks.length ; i++) {
                int a = 0;
                boolean found = (matriks[i][a] != 0) ;
                while ( !found && a < matriks[i].length){
                    if (matriks[i][a] != 0){
                        found = true ;
                    }
                    else{
                        a++ ;
                    }
                }
                for (int j = matriks[i].length-1; j >= a+1; j--) {
                    if (j == matriks[i].length-1){
                        System.out.printf("Solusi X-%d adalah %.2f",a+1,matriks[i][j]);
                    }
                    else{
                        System.out.printf("%+.2fX%d",-matriks[i][j],(j+1));
                    }
                }
                System.out.println("");
            }
        }
    }

    public static void MenulisSolusiSPLGaussJordan(float[][] matriks) {
        if (matriks.length == matriks[0].length-1){
            for (int i = 0 ; i < matriks.length ; i++) {
                if (matriks[i][i] != 0){
                    System.out.printf("X-%d = %f\n",i+1,matriks[i][matriks[i].length-1]);
                }
            }
        }
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

        for (k = 0; k < len; k++){
            for (l=0; l<len; l++){
                for (i=0; i<len; i++){
                    for (j=0; j<len; j++){
                        if (i==k){continue;}
                        else{
                            if (j==l){continue;}
                            else{
                                if ((i>k)&&(j>l)){
                                    Mtemp[i-1][j-1] = Matriks[i][j];
                                }
                                else if ((i>k)&&(j<l)){
                                    Mtemp[i-1][j]= Matriks[i][j];
                                }
                                else if ((i<k)&&(j>l)){
                                    Mtemp[i][j-1] = Matriks[i][j];
                                }
                                else {
                                    Mtemp[i][j] = Matriks[i][j];
                                }
                            }
                        }
                    }
                }
                if ((k+l)%2 ==0){
                    Adj[k][l] = DeterminanKofaktor(Mtemp);
                }
                else{
                    Adj[k][l] = -DeterminanKofaktor(Mtemp);
                }
            }
        }
        // Mentranspose kofaktor matriks (Adj)
        Adj = Transpose(Adj);
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
