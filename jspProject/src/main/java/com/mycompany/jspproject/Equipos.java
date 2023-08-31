/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jspproject;

/**
 *
 * @author guime
 */
public class Equipos implements Comparable<Equipos>{
    private String nombre;
    private int puntos;
    
    public Equipos(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPuntos() {
        return puntos;
    }
    
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }
    @Override
    public int compareTo(Equipos o) {
        return o.getPuntos() - this.puntos;
    }
}
