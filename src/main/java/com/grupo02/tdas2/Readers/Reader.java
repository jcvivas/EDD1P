/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.tdas2.Readers;

import com.grupo02.TDAs.DoublyCircularLinkedList;
import com.grupo02.TDAs.LinkedList;
import com.grupo02.videogamestore.App;
import com.grupo02.videogamestore.modelo.Juego;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author robes
 */
public class Reader {

    /**
     * Este método es un lector genérico de archivos.
     *
     * @param archivo
     * @return Retorna todas un ArrayList con todas las lineas del archivo dado
     * como parámetro.
     */
    private static LinkedList<String> leerDatos(String archivo) {
        LinkedList<String> lineas = new LinkedList();
        try ( BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            String linea = bf.readLine();
            int cont = 0;
            while ((linea = bf.readLine()) != null) {
                lineas.addLast(linea);
                cont++;
                if (cont == 25) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Captura de error incompleto");
        }
        return lineas;
    }
    
    public static DoublyCircularLinkedList<Juego> cargarJuegos(String archivo){
        DoublyCircularLinkedList<Juego> juego = null;
        try ( ObjectInputStream oos = new ObjectInputStream(new FileInputStream(App.filePath+archivo))) {
            juego = (DoublyCircularLinkedList<Juego>) oos.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return juego;
    }
    
    public static ImageView obtenerImagen(String dir, int h, int w) {//LUIS
        ImageView imgview = null;
        try ( FileInputStream input = new FileInputStream(App.fileImage + dir)) {
            imgview = new ImageView();
            Image img = new Image(input);
            imgview.setImage(img);
            imgview.setFitHeight(h);
            imgview.setFitWidth(w);
        } catch (IOException ex) {
            System.out.println("Error imagen 1");
        }
        return imgview;
    }
    
    private static String cargarImagen(String URL, String id) {
        InputStream fl = null;
        java.awt.Image img = null;
        URL url = null;
        String name = null;
        Random rd = new Random();
        try {
            url = new URL(URL);

            // read an image from url
            java.awt.image.BufferedImage image = javax.imageio.ImageIO.read(url);

            // resize image to 300x150
            java.awt.Image scaledImage = image.getScaledInstance(840, 300,java.awt.Image.SCALE_DEFAULT);

            name = id+rd.nextInt(25650)+".png";
            // save the resize image aka thumbnail
            javax.imageio.ImageIO.write(
                    convertToBufferedImage(scaledImage),
                    "png",
                    new File(App.fileImage+name));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
        
        
        return name;
    }
    
    public static java.awt.image.BufferedImage convertToBufferedImage(java.awt.Image img) {

        if (img instanceof java.awt.image.BufferedImage) {
            return (java.awt.image.BufferedImage) img;
        }

        // Create a buffered image with transparency
        java.awt.image.BufferedImage bi = new java.awt.image.BufferedImage(
                img.getWidth(null), img.getHeight(null),
                java.awt.image.BufferedImage.TYPE_INT_ARGB);

        java.awt.Graphics2D graphics2D = bi.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();

        return bi;
    }
    
    public static void leerJuegos(String archivo) {
        LinkedList<String> lineas = leerDatos(App.filePath+archivo);
        DoublyCircularLinkedList<Juego> juegos = new DoublyCircularLinkedList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String l : lineas) {
            String[] p = l.split("\\|");
            String header = cargarImagen(p[6],p[0]);
            if (header != null) {
                Juego juego = new Juego(p[1], p[8], header);
                String[] s = p[7].split("\\;");
                for (String i : s) {
                    String imgs = cargarImagen(i,p[0]);
                    if (imgs != null) {
                        juego.getCapturas().addLast(imgs);
                    }
                }
                try {
                    Date lanzamiento = sdf.parse(p[2]);
                    juego.setLanzamiento(lanzamiento);
                    juegos.addLast(juego);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
               
            }

        }
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(App.filePath+"games_data.bin"))) {
            oos.writeObject(juegos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static DoublyCircularLinkedList<Juego> inicializarLista(DoublyCircularLinkedList<Juego> juegos, int valor){
        if (juegos.size()<valor) {
            return juegos.subList(juegos.size());
        }
        return juegos.subList(valor);
    }
}
