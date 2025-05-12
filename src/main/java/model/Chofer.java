package com.example.transporte.model;

public class Chofer {
    private String nombre;
    private double sueldoHora;
    private int[] horasTrabajadas = new int[6]; // lunes a sábado

    // Constructor
    public Chofer(String nombre, double sueldoHora, int[] horasTrabajadas) {
        this.nombre = nombre;
        this.sueldoHora = sueldoHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public int[] getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public int getTotalHoras() {
        int total = 0;
        for (int h : horasTrabajadas) total += h;
        return total;
    }

    public double getSueldoSemanal() {
        return getTotalHoras() * sueldoHora;
    }
}

