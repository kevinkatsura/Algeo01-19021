package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import tubes.MATRIKS;

public class operator {

    
    public void tukarBaris(tubes.MATRIKS M, int i, int j)
    {
        //tukar elemen baris i dengan baris j
        for (int k=0; k<M.NBrsEff; k++)
        {
            float Temp = M.Tab[i][k];
            M.Tab[i][k] = M.Tab[j][k];
            M.Tab[j][k] = Temp;
        }
    }

    public float DeterminanKofaktor(tubes.MATRIKS M) {
        float det = 0;
        if ((M.NBrsEff == 2) && (M.NKolEff == 2)){
            det =(M.Tab[0][0]*M.Tab[1][1]) - (M.Tab[0][1]*M.Tab[1][0]);
            return det;
        }
        else{
            int i,j,k;
            tubes.MATRIKS Mtemp = new tubes.MATRIKS();
            Mtemp.NBrsEff = M.NBrsEff-1;
            Mtemp.NKolEff = M.NKolEff-1;
            for (k = 0; k < M.NKolEff; k++){
                for (i=1; i < M.NBrsEff; i++){
                    for(j=0; j < M.NKolEff; j++){
                        if (j>k){
                            Mtemp.Tab[i-1][j-1] = M.Tab[i][j];
                        }
                        else{
                            if (j==k){continue;}
                            else {
                            	Mtemp.Tab[i - 1][j] = M.Tab[i][j];
                            }
                        }
                    }
                }
                if (k%2 == 0){
                    det += M.Tab[0][k]*DeterminanKofaktor(Mtemp);
                }
                else{
                    det -= M.Tab[0][k]*DeterminanKofaktor(Mtemp);
                }
            }
            return det;

        }
    }

    public float DeterminanReduksiBaris(tubes.MATRIKS M) {
        for (int n = 0; n < M.NBrsEff-1 ; n++) {
            for (int i = n+1; i < M.NBrsEff; i++) {
                float rep = M.Tab[i][n] ;
                for (int k = n; k < M.NKolEff; k++) {
                	M.Tab[i][k] = M.Tab[i][k] - ((M.Tab[n][k] * rep) / M.Tab[n][n]);
                }
            }
        }
        float det = 1 ;
        for (int i = 0; i < M.NBrsEff; i++) {
            det *= M.Tab[i][i] ;
        }
        return det ;
    }

    
    public tubes.MATRIKS SPLGauss(tubes.MATRIKS M) {
        for (int i = 0; i < M.NBrsEff; i++) {
            boolean swapped = false ;
            int a = M.NBrsEff-1 ;
            while(!swapped && a > i ){
                if (IndeksAwalBaris(i,M) > IndeksAwalBaris(a,M)) {
                    tukarBaris(M,i,a);
                    swapped = true;
                }
                else{
                    a-- ;
                }
            }
        }
        for (int n = 0; n < M.NBrsEff ; n++) {
            for (int i = n + 1; i < M.NBrsEff; i++) {
                float rep = M.Tab[i][IndeksAwalBaris(i,M)];
                if (M.Tab[i][IndeksAwalBaris(n,M)] != 0) {
                    for (int k = IndeksAwalBaris(i, M); k < M.NKolEff; k++) {
                        M.Tab[i][k] = M.Tab[i][k] - ((M.Tab[n][k] * rep) / M.Tab[n][IndeksAwalBaris(n, M)]);
                    }
                }
            }
            for (int i = n + 1; i < M.NBrsEff; i++) {
                boolean swapped = false ;
                int a = M.NBrsEff-1 ;
                while(!swapped && a > i ){
                    if (IndeksAwalBaris(i,M) > IndeksAwalBaris(a,M)) {
                        tukarBaris(M,i,a);
                        swapped = true;
                    }
                    else{
                        a-- ;
                    }
                }
            }
        }
        for (int l = 0; l < M.NBrsEff; l++) {
            float rep = M.Tab[l][IndeksAwalBaris(l,M)];
            for (int m = IndeksAwalBaris(l,M); m < M.NKolEff; m++) {
                if (rep != 0) {
                    M.Tab[l][m] = M.Tab[l][m] / rep;
                }
            }
        }
        return M;
    }

    public void SwapByIndeksAwal(int i , int j , tubes.MATRIKS M) {
        if (IndeksAwalBaris(i,M) > IndeksAwalBaris(j,M)){
            tukarBaris(M,i,j);
        }
    }

    public tubes.MATRIKS SPLGaussJordan(tubes.MATRIKS matriksinput) {
        tubes.MATRIKS matriks = RemoveZeroRow(SPLGauss(matriksinput)) ;
            for (int i = matriks.NBrsEff - 1; i >= 1; i--) {
                float rep1 = matriks.Tab[i][IndeksAwalBaris(i, matriks)];
                for (int j = i - 1; j >= 0; j--) {
                    float rep2 = matriks.Tab[j][IndeksAwalBaris(i,matriks)];
                    for (int k = IndeksAwalBaris(i,matriks); k < matriks.NKolEff; k++) {
                        matriks.Tab[j][k] = matriks.Tab[j][k] - (matriks.Tab[i][k] / rep1) * rep2;
                    }
                }
            }
        return matriks ;
    }

    public int IndeksAwalBaris(int i, tubes.MATRIKS M){
        boolean indeksfound;
        int k = 0;
        indeksfound = (M.Tab[i][k] != 0);
        while (!indeksfound && k < M.NKolEff-1) {
            if (M.Tab[i][k] != 0)
            {
                indeksfound = true;
            }
            else{
                k++;
            }
        }
        return k;
    }


    public tubes.MATRIKS KaliMatriks(tubes.MATRIKS matriks1, tubes.MATRIKS matriks2) {
        tubes.MATRIKS matriks = new tubes.MATRIKS();
        matriks.NBrsEff = matriks1.NBrsEff;
        matriks.NKolEff = matriks2.NKolEff;
        if (matriks1.NKolEff == matriks2.NBrsEff){
            for (int i = 0; i < matriks1.NBrsEff; i++) {
                for (int j = 0; j < matriks2.NKolEff ; j++) {
                    int sum = 0 ;
                    for (int k = 0; k < matriks2.NBrsEff ; k++) {
                        sum += matriks1.Tab[i][k]*matriks2.Tab[k][j] ;
                    }
                    matriks.Tab[i][j] = sum ;
                }
            }
        }
        return matriks ;
    }

    public void SPLMatriksInvers (tubes.MATRIKS M) {
        tubes.MATRIKS B = new tubes.MATRIKS();
        B.NBrsEff = M.NBrsEff ;
        B.NKolEff = 1 ;
        tubes.MATRIKS A = new tubes.MATRIKS();
        A.NBrsEff = M.NBrsEff ;
        A.NKolEff = M.NKolEff-1 ;
        for (int i = 0; i < M.NBrsEff; i++) {
            B.Tab[i][0] = M.Tab[i][M.NKolEff-1] ;
        }
        for (int i = 0; i < A.NBrsEff; i++) {
            for (int j = 0; j < A.NKolEff; j++) {
                A.Tab[i][j] = M.Tab[i][j] ;
            }
        }
        if (M.NBrsEff == M.NKolEff-1 && (DeterminanKofaktor(A)!= 0)){
            tubes.MATRIKS NewMatrix = new tubes.MATRIKS();
            NewMatrix.NBrsEff = A.NBrsEff;
            NewMatrix.NKolEff = A.NKolEff;
            NewMatrix = MatriksInvers(A) ;
            
            System.out.println(Arrays.deepToString(NewMatrix.Tab));
            tubes.MATRIKS NewestMatrix = new tubes.MATRIKS();
            NewestMatrix.NBrsEff = A.NBrsEff;
            NewestMatrix.NKolEff = A.NKolEff;
            NewestMatrix = KaliMatriks(NewMatrix,B) ;
            
            
            System.out.println("");
            System.out.println("Matriks memiliki Solusi");
            System.out.println("Solusi dari SPL tersebut Antara Lain : ");
            for (int i = 0; i < NewestMatrix.NBrsEff; i++) {
                System.out.printf("X%d = %.2f",i+1,NewestMatrix.Tab[i][0]);
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

    public boolean IsLastRowZero(int i, tubes.MATRIKS M){
        return (M.Tab[i][M.NKolEff-1] == 0);
    }

    public boolean IsNoSolution(tubes.MATRIKS matriks) {
        int i = matriks.NBrsEff-1 ;
        boolean found = (IndeksAwalBaris(i, matriks) == matriks.NKolEff-1 && matriks.Tab[i][IndeksAwalBaris(i,matriks)] != 0) ;
        while(i >= 0 && !found){
            if (IndeksAwalBaris(i, matriks) == matriks.NKolEff-1 && matriks.Tab[i][IndeksAwalBaris(i,matriks)] != 0){
                found = true ;
            }
            else{
                i--;
            }
        }
        return found ;
    }

    public tubes.MATRIKS RemoveZeroRow(tubes.MATRIKS M) {
        int count = 0 ;
        for (int i = 0; i < M.NBrsEff; i++) {
            if (IndeksAwalBaris(i,M) == M.NKolEff-1 && (M.Tab[i][IndeksAwalBaris(i,M)] == 0) ){
                count++ ;
            }
        }
        int Brs = M.NBrsEff-count ;
        tubes.MATRIKS NewMatrix = new tubes.MATRIKS();
        NewMatrix.NBrsEff = Brs;
        NewMatrix.NKolEff = M.NKolEff;
        for (int j = 0; j < Brs; j++) {
            for (int k = 0; k < M.NKolEff ; k++) {
                NewMatrix.Tab[j][k] = M.Tab[j][k] ;
            }
        }
        return NewMatrix;
    }

    public boolean IsAllDiagonalOne(tubes.MATRIKS matriks) {
        int a = 0 ;
        boolean IsAllOne ;
        do {
            if (matriks.Tab[a][a] != 1){
                IsAllOne = false ;
            }
            else{
                a++ ;
                IsAllOne = true ;
            }
        } while (IsAllOne && a < matriks.NBrsEff) ;
        return IsAllOne ;
    }

    public tubes.MATRIKS CopyMatriksDenganJumlahBaris(int i, tubes.MATRIKS matriks) {
        tubes.MATRIKS NewMatrix = new tubes.MATRIKS();
        NewMatrix.NBrsEff = i;
        NewMatrix.NKolEff = matriks.NBrsEff ;
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < matriks.NKolEff ; k++) {
                NewMatrix.Tab[j][k] = matriks.Tab[j][k] ;
            }
        }
        return NewMatrix ;
    }

    public void TulisSolusiBanyakSPL(tubes.MATRIKS matriks) {
        System.out.println();
        System.out.println("Matriks Memiliki Solusi Banyak");
        System.out.println("Solusi Matriks Antara Lain : ");
        for (int i = 0; i < matriks.NBrsEff ; i++) {
            for (int j = IndeksAwalBaris(i,matriks); j < matriks.NKolEff-1; j++) {
                if (matriks.Tab[i][j] != 0) {
                    if (j == IndeksAwalBaris(i, matriks)) {
                        System.out.printf("Solusi X%d = %.2f", j + 1, matriks.Tab[i][matriks.NKolEff - 1]);
                    } else {
                        System.out.printf(" %+.2f(X%d)", -matriks.Tab[i][j], (j + 1));
                    }
                }
            }
            System.out.println();
        }
    }

    public float[] SubsitusiMundur(tubes.MATRIKS matriks) {
        float [] temp = new float[matriks.NKolEff-2] ;
        for (int i = matriks.NBrsEff - 1; i >= 1; i--) {
            float rep1 = matriks.Tab[i][IndeksAwalBaris(i, matriks)];
            for (int j = i - 1; j >= 0; j--) {
                float rep2 = matriks.Tab[j][IndeksAwalBaris(i,matriks)];
                for (int k = IndeksAwalBaris(i,matriks); k < matriks.NKolEff; k++) {
                    matriks.Tab[j][k] = matriks.Tab[j][k] - (matriks.Tab[i][k] / rep1) * rep2;
                }
            }
            temp[i] = matriks.Tab[i][matriks.Tab[i].length-1] ;
            if (i == 1){
                temp[i-1] = matriks.Tab[i-1][matriks.Tab[i-1].length-1] ;
            }
        }
        return temp;
    }

    public void MenulisSolusiSPL(tubes.MATRIKS matriks) {
        tubes.MATRIKS NewMatrix = new tubes.MATRIKS() ;
        NewMatrix.NKolEff = matriks.NKolEff ;
        NewMatrix.NBrsEff = matriks.NBrsEff;
        NewMatrix = RemoveZeroRow(matriks);
        if (NewMatrix.NBrsEff == NewMatrix.NKolEff-1){
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
                    for (int i = 0; i < NewMatrix.NBrsEff; i++) {
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

    public  void MenulisSolusiSPLGaussJordan(MATRIKS matriks) {
        if (matriks.NBrsEff == matriks.NKolEff-1){
            for (int i = 0 ; i < matriks.NBrsEff ; i++) {
                if (matriks.Tab[i][i] != 0){
                    System.out.printf("X-%d = %.2f\n",i+1,matriks.Tab[i][matriks.NKolEff-1]);
                }
            }
        }
    }

    public void Cramer(MATRIKS matriks)
    {
        /* I.S : persamaan dengan n peubah n persamaan
                 input berupa matriks augmented */
        /* F.S : menghasilkan array yang berisikan nilai peubah */

        // memisahkan matriks augmented menjadi 2 matriks biasa
        int i,j,k;
        int m = matriks.NBrsEff;

        MATRIKS A = new MATRIKS();
        A.NBrsEff = m;
        A.NKolEff = m;
        float []B = new float [m];
        float []res = new float[m];
        for (i=0; i<m; i++){
            for (j=0; j<m; j++){
                A.Tab[i][j] = matriks.Tab[i][j];
            }
        }
        for (i=0; i<m; i++){
            B[i] = matriks.Tab[i][matriks.NKolEff-1];
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
                        A.Tab[i][j] = matriks.Tab[i][j];
                    }
                }
                for (i=0; i<m; i++){
                    A.Tab[i][k] = B[i];
                }
                float Dx = DeterminanKofaktor(A);
                res[k] = Dx/detA;
            }
            for( i=0; i<m; i++){
                System.out.println("X"+(i+1)+"= "+res[i]);
            }

        }

    }

    public MATRIKS Transpose ( MATRIKS Matriks)
    {
        int i,j;
        int baris = Matriks.NBrsEff;
        int kolom = Matriks.NKolEff;
        MATRIKS Mtrans = new MATRIKS();
        Mtrans.NBrsEff = kolom;
        Mtrans.NKolEff = baris;
        for (i=0; i<kolom; i++){
            for (j=0; j<baris; j++){
                Mtrans.Tab[i][j] = Matriks.Tab[j][i];
            }
        }
        return Mtrans;
    }

    public MATRIKS Adjoint ( MATRIKS Matriks)
    {
        // I.S  : Matriks yang di input merupakan matriks bujursangkar
        // F.S  : Mengembalikan matriks adjoint matriks inputan

        int i,j,k,l;
        int len = Matriks.NBrsEff;

        MATRIKS Mtemp = new MATRIKS();
        Mtemp.NKolEff = len-1;
        Mtemp.NBrsEff = len-1;
        MATRIKS Adj = new MATRIKS();
        Adj.NBrsEff = len;
        Adj.NKolEff = len;

        if (len==2){
            Adj.Tab[0][0] = Matriks.Tab[1][1];
            Adj.Tab[0][1] = -Matriks.Tab[1][0];
            Adj.Tab[1][0] = -Matriks.Tab[0][1];
            Adj.Tab[1][1] = Matriks.Tab[0][0];
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
                                        Mtemp.Tab[i - 1][j - 1] = Matriks.Tab[i][j];
                                    } else if ((i > k) && (j < l)) {
                                        Mtemp.Tab[i - 1][j] = Matriks.Tab[i][j];
                                    } else if ((i < k) && (j > l)) {
                                        Mtemp.Tab[i][j - 1] = Matriks.Tab[i][j];
                                    } else {
                                        Mtemp.Tab[i][j] = Matriks.Tab[i][j];
                                    }
                                }
                            }
                        }
                    }
                    if ((k + l) % 2 == 0) {
                        Adj.Tab[k][l] = DeterminanKofaktor(Mtemp);
                    } else {
                        Adj.Tab[k][l] = -DeterminanKofaktor(Mtemp);
                    }
                }
            }
            // Mentranspose kofaktor matriks (Adj)
            Adj = Transpose(Adj);
        }
        return Adj;
    }
    public MATRIKS MatriksInvers (MATRIKS Matriks)
    {
        // I.S      : Matriks masukan merupakan matriks persegi
        // F.S      : mengembalikan matriks invers dari matriks masukan

        int i,j;
        int len = Matriks.NBrsEff;
        MATRIKS Adj = new MATRIKS();
        MATRIKS MInvers = new MATRIKS();
        MInvers.NBrsEff = len;
        MInvers.NKolEff = len;
        float faktor;
        float det = DeterminanKofaktor(Matriks);
        if (det == 0){
            System.out.println("Matriks tidak memiliki invers karena determinannya 0");
            return Adj;
        }
        else{
            faktor = 1/det;
            Adj = Adjoint(Matriks);

            for (i=0; i<len; i++){
                for (j=0; j<len; j++){
                    MInvers.Tab[i][j] = faktor*Adj.Tab[i][j];
                }
            }
            return MInvers;
        }
    }
    public static void TulisMatriks(MATRIKS Matriks)
    {
        // Prosedur mencetak matriks
        for (int i = 0; i < Matriks.NBrsEff; i++) {
            System.out.println(Arrays.toString(Matriks.Tab[i]));
        }
    }
}
