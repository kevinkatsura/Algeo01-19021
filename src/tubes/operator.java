package tubes;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class operator {

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
        for (int i = 0; i < matriks.length; i++) {
            boolean swapped = false ;
            int a = matriks.length-1 ;
            while(!swapped && a > i ){
                if (IndeksAwalBaris(i,matriks) > IndeksAwalBaris(a,matriks)) {
                    tukarBaris(matriks,i,a);
                    swapped = true;
                }
                else{
                    a-- ;
                }
            }
        }
        for (int n = 0; n < matriks.length ; n++) {
            for (int i = n + 1; i < matriks.length; i++) {
                float rep = matriks[i][IndeksAwalBaris(i,matriks)];
                if (matriks[i][IndeksAwalBaris(n,matriks)] != 0) {
                    for (int k = IndeksAwalBaris(i, matriks); k < matriks[0].length; k++) {
                        matriks[i][k] = matriks[i][k] - ((matriks[n][k] * rep) / matriks[n][IndeksAwalBaris(n, matriks)]);
                    }
                }
            }
            for (int i = n + 1; i < matriks.length; i++) {
                boolean swapped = false ;
                int a = matriks.length-1 ;
                while(!swapped && a > i ){
                    if (IndeksAwalBaris(i,matriks) > IndeksAwalBaris(a,matriks)) {
                        tukarBaris(matriks,i,a);
                        swapped = true;
                    }
                    else{
                        a-- ;
                    }
                }
            }
        }
        for (int l = 0; l < matriks.length; l++) {
            float rep = matriks[l][IndeksAwalBaris(l,matriks)];
            for (int m = IndeksAwalBaris(l,matriks); m < matriks[l].length; m++) {
                if (rep != 0) {
                    matriks[l][m] = matriks[l][m] / rep;
                }
            }
        }
        return matriks ;
    }

    public static void SwapByIndeksAwal(int i , int j , float[][] matriks) {
        if (IndeksAwalBaris(i,matriks) > IndeksAwalBaris(j,matriks)){
            tukarBaris(matriks,i,j);
        }
    }

    public static float[][] SPLGaussJordan(float[][] matriksinput) {
        float[][] matriks = RemoveZeroRow(SPLGauss(matriksinput)) ;
            for (int i = matriks.length - 1; i >= 1; i--) {
                float rep1 = matriks[i][IndeksAwalBaris(i, matriks)];
                for (int j = i - 1; j >= 0; j--) {
                    float rep2 = matriks[j][IndeksAwalBaris(i,matriks)];
                    for (int k = IndeksAwalBaris(i,matriks); k < matriks[j].length; k++) {
                        matriks[j][k] = matriks[j][k] - (matriks[i][k] / rep1) * rep2;
                    }
                }
            }
        return matriks ;
    }

    public static int IndeksAwalBaris(int i, float[][] matriks){
        boolean indeksfound;
        int k = 0;
        indeksfound = (matriks[i][k] != 0);
        while (!indeksfound && k < matriks[i].length-1) {
            if (matriks[i][k] != 0)
            {
                indeksfound = true;
            }
            else{
                k++;
            }
        }
        return k;
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

    public static void SPLMatriksInvers (float[][] matriks) {
        float [][] B = new float[matriks.length][1] ;
        float [][] A = new float[matriks.length][matriks[0].length-1] ;
        for (int i = 0; i < matriks.length; i++) {
            B[i][0] = matriks[i][matriks[i].length-1] ;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = matriks[i][j] ;
            }
        }
        if (matriks.length == matriks[0].length-1 && (DeterminanKofaktor(A)!= 0)){
            float[][] NewMatrix = MatriksInvers(A) ;
            System.out.println(Arrays.deepToString(NewMatrix));
            float [][] NewestMatrix = KaliMatriks(NewMatrix,B) ;
            System.out.println("");
            System.out.println("Matriks memiliki Solusi");
            System.out.println("Solusi dari SPL Antara Lain : ");
            for (int i = 0; i < NewestMatrix.length; i++) {
                System.out.printf("X%d = %.2f",i+1,NewestMatrix[i][0]);
                System.out.println();
            }
        }
        else{
            if (DeterminanKofaktor(A) == 0){
                System.out.println();
                System.out.println("Maaf, Matriks Tidak Memiliki Solusi");
                System.out.println();
            }
            else {
                System.out.println();
                System.out.println("Maaf, Solusi Tidak dapat dicari dengan Metode Matriks Balikan");
                System.out.println();
            }
        }
    }

    public static boolean IsLastRowZero(int i, float[][] matriks ){
        return (matriks[i][matriks[i].length-1] == 0);
    }

    public static boolean IsNoSolution(float[][] matriks) {
        int i = matriks.length-1 ;
        boolean found = (IndeksAwalBaris(i, matriks) == matriks[i].length-1 && matriks[i][IndeksAwalBaris(i,matriks)] != 0) ;
        while(i >= 0 && !found){
            if (IndeksAwalBaris(i, matriks) == matriks[i].length-1 && matriks[i][IndeksAwalBaris(i,matriks)] != 0){
                found = true ;
            }
            else{
                i--;
            }
        }
        return found ;
    }

    public static float[][] RemoveZeroRow(float[][] matriks) {
        int count = 0 ;
        for (int i = 0; i < matriks.length; i++) {
            if (IndeksAwalBaris(i,matriks) == matriks[i].length-1 && (matriks[i][IndeksAwalBaris(i,matriks)] == 0) ){
                count++ ;
            }
        }
        int Brs = matriks.length-count ;
        float[][] NewMatrix = new float[Brs][matriks[0].length] ;
        for (int j = 0; j < Brs; j++) {
            for (int k = 0; k < matriks[j].length ; k++) {
                NewMatrix[j][k] = matriks[j][k] ;
            }
        }
        return NewMatrix;
    }

    public static boolean IsAllDiagonalOne(float[][] matriks) {
        int a = 0 ;
        boolean IsAllOne ;
        do {
            if (matriks[a][a] != 1){
                IsAllOne = false ;
            }
            else{
                a++ ;
                IsAllOne = true ;
            }
        } while (IsAllOne && a < matriks.length) ;
        return IsAllOne ;
    }

    public static float[][] CopyMatriksDenganJumlahBaris(int i, float[][]matriks) {
        float [][] NewMatrix = new float[i][matriks.length] ;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < matriks[j].length ; k++) {
                NewMatrix[j][k] = matriks[j][k] ;
            }
        }
        return NewMatrix ;
    }


    public static void TulisSolusiBanyakSPL(float[][] matriks) {
        System.out.println();
        System.out.println("Matriks Memiliki Solusi Banyak");
        System.out.println("Solusi Matriks Antara Lain : ");
        for (int i = 0; i < matriks.length ; i++) {
            for (int j = IndeksAwalBaris(i,matriks); j < matriks[i].length-1; j++) {
                if (matriks[i][j] != 0) {
                    if (j == IndeksAwalBaris(i, matriks)) {
                        System.out.printf("Solusi X%d = %.2f", j + 1, matriks[i][matriks[i].length - 1]);
                    } else {
                        System.out.printf(" %+.2f(X%d)", -matriks[i][j], (j + 1));
                    }
                }
            }
            System.out.println();
        }
    }

    public static float[] SubsitusiMundur(float[][] matriks) {
        float [] temp = new float[matriks[0].length-2] ;
        for (int i = matriks.length - 1; i >= 1; i--) {
            float rep1 = matriks[i][IndeksAwalBaris(i, matriks)];
            for (int j = i - 1; j >= 0; j--) {
                float rep2 = matriks[j][IndeksAwalBaris(i,matriks)];
                for (int k = IndeksAwalBaris(i,matriks); k < matriks[j].length; k++) {
                    matriks[j][k] = matriks[j][k] - (matriks[i][k] / rep1) * rep2;
                }
            }
            temp[i] = matriks[i][matriks[i].length-1] ;
            if (i == 1){
                temp[i-1] = matriks[i-1][matriks[i-1].length-1] ;
            }
        }
        return temp;
    }

    public static void MenulisSolusiSPL(float[][] matriks) {
        float[][] NewMatrix = RemoveZeroRow(matriks);
        if (NewMatrix.length == NewMatrix[0].length-1){
            if(IsNoSolution(NewMatrix)){
                System.out.println();
                System.out.println("Matriks Tidak Memiliki Solusi");
            }
            else{
                if (IsAllDiagonalOne(NewMatrix)){
                    System.out.println();
                    System.out.println("Matriks Memiliki Solusi Unik");
                    System.out.println("Solusi Matriks Antara Lain : ");
                    float [] Solusi = SubsitusiMundur(NewMatrix) ;
                    for (int i = 0; i < NewMatrix.length; i++) {
                        System.out.printf("X%d = %.2f\n", (i + 1), Solusi[i]);
                    }
                }
                else{
                    System.out.println();
                    TulisSolusiBanyakSPL(NewMatrix);
                }
                System.out.println();
            }
        }
        else{
            if(IsNoSolution(NewMatrix)){
                System.out.println();
                System.out.println("Matriks Tidak Memiliki Solusi");
                System.out.println();
            }
            else{
                System.out.println();
                TulisSolusiBanyakSPL(NewMatrix);
                System.out.println();
            }
        }
    }

    public static void MenulisSolusiSPLGaussJordan(float[][] matriks) {
        if (matriks.length == matriks[0].length-1){
            for (int i = 0 ; i < matriks.length ; i++) {
                if (matriks[i][i] != 0){
                    System.out.printf("X-%d = %.2f\n",i+1,matriks[i][matriks[i].length-1]);
                }
            }
        }
    }

    public static void Cramer(float matriks [][])
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
        // mengecek jika matriks tidak memiliki determinan
        if (detA == 0){
            System.out.println("Matriks tidak memiliki determinan (determinan = 0)");
        }
        else{
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
            for( i=0; i<m; i++){
                System.out.println("X"+(i+1)+"= "+res[i]);
            }

        }

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
        for (int i = 0; i < Matriks.length; i++) {
            System.out.println(Arrays.toString(Matriks[i]));
        }
    }
}
