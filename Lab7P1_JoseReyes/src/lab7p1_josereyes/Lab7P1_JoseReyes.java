/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_josereyes;

/**
 *
 * @author josem
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
public class Lab7P1_JoseReyes {
    static Random ran=new Random();
    static Scanner r=new Scanner(System.in);

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int menu=1;
        while(menu==1){
            System.out.println("~~~Bienvenido al menu principal~~~");
            System.out.println("1.Promedios\n2.De landscape a portrait\n3.Highher-order contains\n4.salir");
            System.out.print("Elija su opcion: ");
            int opcion=r.nextInt();
            
            switch(opcion){
                case 1:{
                    String filas = JOptionPane.showInputDialog(null, "Ingrese numero de filas");
                    int fila= Integer.parseInt(filas);
                    
                    String columnas = JOptionPane.showInputDialog(null, "Ingrese numero de columnas");
                    int columna= Integer.parseInt(columnas);
                    
                    int[][] matriz= llenado(fila,columna);
                    String  promedios = JOptionPane.showInputDialog(null, "Matriz generada\n"+imprimir(matriz)+"\nCalcular promedio de \n1.filas\n2.columnas");
                    int promedio=Integer.parseInt(promedios);
                    if(promedio ==1){
                        double[]matriz1=Promediofilas(matriz);
                        JOptionPane.showMessageDialog(null,"La matriz es: \n"+imprimir(matriz)+"\nPromedio de las filas es\n"+imprimir1(matriz1));
                    }else if(promedio==2){
                        double[]matriz2=Promediocolumnas(matriz);
                        JOptionPane.showMessageDialog(null,"La matriz es: \n"+imprimir(matriz)+"\nPromedio de las columnas es\n"+imprimir1(matriz2));
                    }else{
                        JOptionPane.showMessageDialog(null,"Opcion no valida, regresando al menu principal");
                    }
                }break;
                case 2:{
                    String filas = JOptionPane.showInputDialog(null, "Ingrese numero de filas");
                    int fila1= Integer.parseInt(filas);
                    
                    String columnas = JOptionPane.showInputDialog(null, "Ingrese numero de columnas");
                    int columna1= Integer.parseInt(columnas);
                    
                    int[][]matriz2=llenado1(fila1,columna1);
                    int[][]matrizmod=girarderecha(matriz2);
                    JOptionPane.showMessageDialog(null, "Matriz generada\n"+imprimir(matriz2)+"\nRotacion de 90 grados a la derecha de la matriz\n"+imprimir(matrizmod));
                    
                }break;
                case 3:{
                    String filas = JOptionPane.showInputDialog(null, "Ingrese numero de filas");
                    int fila1= Integer.parseInt(filas);
                    
                    String columnas = JOptionPane.showInputDialog(null, "Ingrese numero de columnas");
                    int columna1= Integer.parseInt(columnas);
                    
                    String Arreglo = JOptionPane.showInputDialog(null, "Ingrese el tamaño del arreglo");
                    int array = Integer.parseInt(Arreglo);
                    int[][]matrix=llenado1(fila1,columna1);
                    int[] arr=new int[array];
                    for (int i = 0; i < array; i++) {
                        String nums = JOptionPane.showInputDialog(null,"Matriz generada\n"+imprimir(matrix)+"\n"+imprimir2(arr)+"\nIngrese el elemento{"+i+"]");
                        int num=Integer.parseInt(nums);
                        arr[i]=num;
                    }
                    boolean flag=contener(matrix,arr);
                    if(flag==true){
                        JOptionPane.showMessageDialog(null,"Arreglo\n"+imprimir2(arr)+"\nEsta contenido en la matriz\n"+imprimir(matrix));
                    }else{
                        JOptionPane.showMessageDialog(null,"Arreglo\n"+imprimir2(arr)+"\nNo esta contenido en la matriz\n"+imprimir(matrix));   
                    }
                }break;
                case 4:{
                    menu=0;
                    System.out.println(">>>Programa finalizado<<<");
                }break;
                default:
                    System.out.println("Opcion no valida...");
            }
        }
    }
    public static int [][] llenado(int fil,int col){
        int[][]temp=new int[fil][col];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j]=ran.nextInt(99);
            }
        }
        return temp;
    }   
    public static int [][] llenado1(int fil,int col){
        int[][]temp=new int[fil][col];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j]=ran.nextInt(9);
            }
        }
        return temp;
    }  
    public static String imprimir(int matriz [][]){
        String matri="";
        for (int i = 0; i < matriz.length; i++) {
            for (int j=0;j<matriz[i].length;j++){   
                matri+="["+matriz[i][j]+"]";
            }
            matri+="\n";
        }   
        return matri;
    }    public static String imprimir2(int []matriz){
        String matri="";
        for (int i = 0; i < matriz.length; i++) {
                matri+="["+matriz[i]+"]";
        }
            matri+="\n";
        return matri;
    }
    public static String imprimir1(double []matrizs){
        String matri="";
        for (int i = 0; i < matrizs.length; i++) {  
                matri+="["+matrizs[i]+"]";
            }
            matri+="\n";  
            return matri;  
    }
    public static double[] Promediofilas(int [][]ma1){
        int filas=ma1.length;
        int columnas = ma1[0].length;
        double[] promedio = new double[filas];
        for (int i = 0; i < filas; i++) {
            double sumaFilas=0;
            for (int j = 0; j < columnas; j++) {
                sumaFilas+= ma1[i][j];
            }
            promedio[i]=sumaFilas/columnas;
        }
    return promedio;
    }
    public static double[] Promediocolumnas(int[][]mat2){
   int filas = mat2.length;
    int columnas = mat2[0].length;
    double[] promedios = new double[columnas];
    for (int j = 0; j < columnas; j++) {
        double suma = 0;
        for (int i = 0; i < filas; i++) {
            suma += mat2[i][j];
        }
        promedios[j] = suma / filas;
    }
    return promedios;
    }
    public static int[][]girarderecha(int[][]mat4){
        int filas=mat4.length;
        int columnas=mat4[0].length;
        int [][]girada=new int[columnas][filas];
           for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                girada[j][filas-1-i]=mat4[i][j];
            }
        } 
           return girada;
    }
    public static boolean contener(int[][]mat5,int[]mat6){
 boolean encontrado = true;
        
        for (int i = 0; i < mat6.length; i++) {
            boolean encontradoEnFila = false;
            
            for (int j = 0; j < mat5.length; j++) {
                for (int k = 0; k < mat5[j].length; k++) {
                    if (mat5[j][k] == mat6[i]) {
                        encontradoEnFila = true;
                        break;
                    }
                }
                
                if (encontradoEnFila) {
                    break;
                }
            }
            
            if (!encontradoEnFila) {
                encontrado = false;
                break;
            }
        }
        
        return encontrado;
    }
}
