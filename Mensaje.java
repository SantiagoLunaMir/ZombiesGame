import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mensaje1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mensaje extends Actor
{
    private int tiempoVisible = 450; // 15 segundos (300 ciclos por segundo)

    public Mensaje(String texto) {
        GreenfootImage imagen = new GreenfootImage(texto, 24, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(imagen);
    }

    public void act() {
        if (tiempoVisible > 0) {
            tiempoVisible--;
        } else {
            getWorld().removeObject(this);
        }
    }
}
