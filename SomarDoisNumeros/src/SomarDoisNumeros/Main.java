package SomarDoisNumeros;

import java.util.Scanner;
class SomarDoisNumeros {
    public static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {
    //Declarar variaveis
    int num1, num2, soma;
    //Ler primeiro numero
    System.out.println ("Digite um numero:");
    num1 = sc.nextInt();

    //ler segundo numero
    System.out.println ("Digite outro numero:");
    num2 = sc.nextInt();

    //Somar
    soma = num1 + num2;
    //Imprimir a resposta
    System.out.println ("Soma:" +soma);
    }
}