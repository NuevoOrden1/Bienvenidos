/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jesus Diego
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jesus Diego
 */
public class Calendario {
    GregorianCalendar ahora = new GregorianCalendar();
    private int anio = ahora.get(Calendar.YEAR);
    private int mes = ahora.get(Calendar.MONTH) + 1;
    private int dia_mes = ahora.get(Calendar.DAY_OF_MONTH);
    
    /**
     *
     */
    @Override
    public String toString(){
        return this.dia_mes +"/" +this.mes +"/" +this.anio;
    }
}