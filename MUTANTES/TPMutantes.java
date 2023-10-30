import java.util.Scanner;

public class TPMutantes{
    public static boolean esMutante(char[][] matriz) {
        
        int n = matriz.length;
        int contador = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 3; j++) {
                // Se verifica si hay una secuencia HORIZONTAL de 4 letras iguales
                if (matriz[i][j] == matriz[i][j + 1] && matriz[i][j] == matriz[i][j + 2] && matriz[i][j] == matriz[i][j + 3]) {
                    contador++;
                }
                // Se verifica si hay una secuencia VERTICAL de 4 letras iguales
                if (matriz[j][i] == matriz[j + 1][i] && matriz[j][i] == matriz[j + 2][i] && matriz[j][i] == matriz[j + 3][i]) {
                    contador++;
                }
                // Se verifica si hay una secuencia DIAGONAL DESCENDENTE de 4 letras iguales
                if (i < n - 3 && matriz[i][j] == matriz[i + 1][j + 1] && matriz[i][j] == matriz[i + 2][j + 2] && matriz[i][j] == matriz[i + 3][j + 3]) {
                    contador++;
                }
                // Se verifica si hay una secuencia DIAGONAL ASCENDENTE de 4 letras iguales
                if (i > 2 && matriz[i][j] == matriz[i - 1][j + 1] && matriz[i][j] == matriz[i - 2][j + 2] && matriz[i][j] == matriz[i - 3][j + 3]) {
                    contador++;
                }
            }
        }
        // Se retorna verdadero si el contador es mayor o igual a 2, falso en caso contrario
        return contador >= 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Ingrese el número de filas de la matriz: "); 
        int filas = sc.nextInt(); 
        char[][] matriz = new char[filas][filas]; 
        System.out.println("Ingrese los elementos de la matriz: "); 

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                System.out.println("Ingrese el elemento [" + i + "][" + j + "]: ");
                char elemento = sc.next().charAt(0); 
                matriz[i][j] = elemento; 
            }
        }
        boolean resultado = esMutante(matriz); 
        System.out.println("El resultado de la verificación es: " + resultado); 
    }
}