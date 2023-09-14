/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quicsort2;

import java.util.Arrays;

/**
 *
 * @author ckodda
 */
public class Ordenamiento implements InterfazOrdenamiento{

    public Ordenamiento(int arreglo[]) {
        this.arreglo = arreglo;
    }
    
    private int arreglo[];
    private String actualPuntero = "derecha";
    public int[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public void ordenar() {
        int punteroIz = 0;
        int punteroDer = this.arreglo.length - 1;
        this.arreglo = this.bucle(punteroIz,punteroDer,this.arreglo);
        System.out.println(this.arreglo);
    }

    public int[] bucle(int punteroIz, int punteroDer, int[] currentArray){

        int pivote = currentArray[punteroIz];
        int tmp;
        int currentPunteroIz = punteroIz;
        int currentPunteroDer = punteroDer;
        
        
        while (currentPunteroIz < currentPunteroDer) {
            

            while(currentArray[currentPunteroIz]<=pivote && currentPunteroIz < currentPunteroDer){
                currentPunteroIz++;
            }

            while(currentArray[currentPunteroDer]> pivote){
                currentPunteroDer--;
            }

            if(currentPunteroIz<currentPunteroDer){
                tmp = currentArray[currentPunteroIz];
                currentArray[currentPunteroIz] = currentArray[currentPunteroDer];
                currentArray[currentPunteroDer] = tmp;
            }
        }

        currentArray[punteroIz] = currentArray[currentPunteroDer];
        currentArray[currentPunteroDer] = pivote;

        if(punteroIz < currentPunteroDer - 1){
            this.bucle(punteroIz, currentPunteroDer - 1, currentArray);
        }

        if(currentPunteroDer+1<punteroDer){
            this.bucle(currentPunteroDer+1, punteroDer, currentArray);
        }

        return currentArray;
    }
    @Override
    public String getArrayStr() {
        return Arrays.toString(this.arreglo);
    }
    
    
}
