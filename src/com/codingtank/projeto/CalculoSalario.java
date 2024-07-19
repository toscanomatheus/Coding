package com.codingtank.projeto;

import java.util.Scanner;

public class CalculoSalario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] salariosBrutos = new double[5];
        double[] inssDescontos = new double[5];
        double[] impostoRendaDescontos = new double[5];
        double[] salariosLiquidos = new double[5];


        for (int i = 0; i < 5; i++) {
            System.out.println("Informe o salário bruto do colaborador " + (i + 1) + ": ");
            salariosBrutos[i] = sc.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            double salarioBruto = salariosBrutos[i];

            double inss;
            if (salarioBruto <= 1212.00) {
                inss = salarioBruto * 0.075;
            } else if (salarioBruto <= 2427.35) {
                inss = salarioBruto * 0.09;
            } else if (salarioBruto <= 3641.03) {
                inss = salarioBruto * 0.12;
            } else if (salarioBruto >= 3641.03) {
                inss = salarioBruto * 0.14;
            } else {
                inss = 3641.03 * 0.14;
            }
            inssDescontos[i] = inss;

            double salarioBaseIR = salarioBruto - inss;

            double ir;
            if (salarioBaseIR <= 1903.98) {
                ir = 0;
            } else if (salarioBaseIR <= 2826.65) {
                ir = (salarioBaseIR - 1903.98) * 0.075;
            } else if (salarioBaseIR <= 3751.05) {
                ir = (salarioBaseIR - 2826.65) * 0.15 + (2826.65 - 1903.98) * 0.075;
            } else if (salarioBaseIR <= 4664.68) {
                ir = (salarioBaseIR - 3751.05) * 0.225 + (3751.05 - 2826.65) * 0.15 + (2826.65 - 1903.98) * 0.075;
            } else {
                ir = (salarioBaseIR - 4664.68) * 0.275 + (4664.68 - 3751.05) * 0.225 + (3751.05 - 2826.65) * 0.15 + (2826.65 - 1903.98) * 0.075;
            }
            impostoRendaDescontos[i] = ir;

            salariosLiquidos[i] = salarioBruto - inss - ir;
        }

        for (int i = 0; i < 5; i++) {

            System.out.println("Colaborador " + (i + 1) + ":");
            System.out.printf("Salário bruto: R$ %.2f\n", salariosBrutos[i]);
            System.out.printf("Desconto INSS: R$ %.2f\n", inssDescontos[i]);
            System.out.printf("Desconto Imposto de Renda: R$ %.2f\n", impostoRendaDescontos[i]);
            System.out.printf("Salário líquido: R$ %.2f\n", salariosLiquidos[i]);
            System.out.println();
        }

        sc.close();
    }
}