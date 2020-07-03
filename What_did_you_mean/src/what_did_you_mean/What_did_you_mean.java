/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package what_did_you_mean;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author Lord Cryne
 */
public class What_did_you_mean {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        File f=new File(".\\comandos.xls");
        File f1=new File(".\\Thriller.mp3");
        
        Workbook wb=Workbook.getWorkbook(f);
        Sheet s=wb.getSheet(0);
        Desktop desktop = Desktop.getDesktop(); 
        ArrayList<String> lista0= new ArrayList<String>();
        ArrayList<String> lista1= new ArrayList<String>();
        ArrayList<String> lista2= new ArrayList<String>();
        ArrayList<String> lista3= new ArrayList<String>();
        int size0=Integer.parseInt(s.getCell(0, 0).getContents());       
        int size1=Integer.parseInt(s.getCell(1, 0).getContents()); 
        int size2=Integer.parseInt(s.getCell(2, 0).getContents()); 
        int size3=Integer.parseInt(s.getCell(3, 0).getContents());
        for (int i = 1; i <= size0; i++) {
            Cell c=s.getCell(0, i);
            lista0.add(c.getContents());
        }
        for (int i = 1; i <= size1; i++) {
            Cell c=s.getCell(1, i);
            lista1.add(c.getContents());
        }
        for (int i = 1; i <= size2; i++) {
            Cell c=s.getCell(2, i);
            lista2.add(c.getContents());
        }
        for (int i = 1; i <= size3; i++) {
            Cell c=s.getCell(3, i);
            lista3.add(c.getContents());
        }  
        System.out.println("Opciones de comandos");
        System.out.print(lista0.get(0));
        for (int i = 1; i < lista0.size(); i++) {
            System.out.print(","+lista0.get(i));
        }
        System.out.println("-{abre el archivo mp3 de la cancion Thriller de Michael Jackson}");
        System.out.print(lista1.get(0));
        for (int i = 1; i < lista1.size(); i++) {
            System.out.print(","+lista1.get(i));
        }
        System.out.println("-{Abre la pagina del portal de unitec en su navegador}");
        System.out.print(lista2.get(0));
        for (int i = 1; i < lista2.size(); i++) {
            System.out.print(","+lista2.get(i));
        }
        System.out.println("-{le proporciona una pregunta random al usuario para que pueda filosofar acerca de ella}");
        System.out.println("exit-{salir del programa}");
        String bandera="";
        while(!bandera.equals("exit")){
            Scanner sc=new Scanner(System.in);
            System.out.print("C:>");
            bandera=sc.nextLine().toLowerCase();
            char[] x=bandera.toCharArray();
            int pregunta=0;
            for (int i = 0; i < lista0.size(); i++) {
                if (bandera.equals(lista0.get(i))) {
                    desktop.open(f1);
                    pregunta=1;
                }
            }

            for (int i = 0; i < lista1.size(); i++) {
                if (bandera.equals(lista1.get(i))) {
                    desktop.browse(new URI("https://portal.unitec.edu"));
                    pregunta=1;
                }
            }
            for (int i = 0; i < lista2.size(); i++) {
                if (bandera.equals(lista2.get(i))) {
                    Random rand = new Random();
                    int n = rand.nextInt(21);
                    System.out.println(lista3.get(n));
                    pregunta=1;
                }
            }
            if (pregunta==0) {

                char[] y0=lista0.get(0).toCharArray();
                char[] y1=lista1.get(0).toCharArray();
                char[] y2=lista2.get(0).toCharArray();
                if (x.length<=y0.length+2 && x.length>=y0.length-2) {
                    int margen=0;
                    if (x.length>=y0.length) {
                        for (int i = 0; i < y0.length; i++) {
                            if (y0[i]==x[i]) {
                            margen++;
                            }
                        } 
                    }else{
                        for (int i = 0; i < x.length; i++) {
                            if (y0[i]==x[i]) {
                                margen++;
                            }
                        }
                    }
                    if (margen>=y0.length-2 && x.length<=y0.length || margen==y0.length && x.length<=y0.length+2 ||margen==y0.length-1 && x.length<=y0.length+1) {
                        String respuesta="";
                        System.out.println("Usted intentaba ingresar el comando -thriller-?(si/no)");
                        respuesta=sc.nextLine().toLowerCase();
                        if (respuesta.equals("si")) {
                            System.out.println("desea guardar esta entrada como opcion para llamar al comando -thriller-?(si/no)");
                            respuesta=sc.nextLine().toLowerCase();
                            if (respuesta.equals("si")) {
                                lista0.add(bandera);
                                guardar_opciones(lista0, lista1, lista2, lista3);
                            }
                        }
                    }

                }
                if (x.length<=y1.length+2 && x.length>=y1.length-2) {
                    int margen=0;
                    if (x.length>=y1.length) {
                        for (int i = 0; i < y1.length; i++) {
                            if (y1[i]==x[i]) {
                            margen++;
                            }
                        } 
                    }else{
                        for (int i = 0; i < x.length; i++) {
                            if (y1[i]==x[i]) {
                                margen++;
                            }
                        }
                    }
                    if (margen>=y1.length-2 && x.length<=y1.length || margen==y1.length && x.length<=y1.length+2 ||margen==y1.length-1 && x.length<=y1.length+1) {
                        String respuesta="";
                        System.out.println("Usted intentaba ingresar el comando -portal-?(si/no)");
                        respuesta=sc.nextLine().toLowerCase();
                        if (respuesta.equals("si")) {
                            System.out.println("desea guardar esta entrada como opcion para llamar al comando -portal-?(si/no)");
                            respuesta=sc.nextLine().toLowerCase();
                            if (respuesta.equals("si")) {
                                lista1.add(bandera);
                                guardar_opciones(lista0, lista1, lista2, lista3);
                            }
                        }
                    } 
                
                }
                if (x.length<=y2.length+2 && x.length>=y2.length-2) {
                    int margen=0;
                    if (x.length>=y2.length) {
                        for (int i = 0; i < y2.length; i++) {
                            if (y2[i]==x[i]) {
                            margen++;
                            }
                        } 
                    }else{
                        for (int i = 0; i < x.length; i++) {
                            if (y2[i]==x[i]) {
                                margen++;
                            }
                        }
                    }
                    if (margen>=y2.length-2 && x.length<=y2.length || margen==y2.length && x.length<=y2.length+2 ||margen==y2.length-1 && x.length<=y2.length+1) {
                        String respuesta="";
                        System.out.println("Usted intentaba ingresar el comando -preguntame-?(si/no)");
                        respuesta=sc.nextLine().toLowerCase();
                        if (respuesta.equals("si")) {
                            System.out.println("desea guardar esta entrada como opcion para llamar al comando -preguntame-?(si/no)");
                            respuesta=sc.nextLine().toLowerCase();
                            if (respuesta.equals("si")) {
                                lista2.add(bandera);
                                guardar_opciones(lista0, lista1, lista2, lista3);
                            }
                        }
                    } 
                }   
            }
            
        }
            /*for (int j = 0; j < rows; j++) {
                Cell c0=s.getCell(0, j);
                Cell c1=s.getCell(1, j);
                Cell c2=s.getCell(2, j);
                lista0.add(c0.getContents());
                lista1.add(c1.getContents());
                lista2.add(c2.getContents());
                
            }*/
            
          
        /*    lista0.add("salud");
            lista1.add("preguntame");
            lista2.add("despedido");
        WritableWorkbook wworkbook=Workbook.createWorkbook(f,wb);
        WritableSheet wsheet=wworkbook.getSheet(0);
        for (int i = 0; i < lista0.size(); i++) {
            Label label0 = new Label(0,i,lista0.get(i));
            Label label1 = new Label(1,i,lista1.get(i));
            Label label2 = new Label(2,i,lista2.get(i));
            wsheet.addCell(label0);
            wsheet.addCell(label1);
            wsheet.addCell(label2);
        }
        wworkbook.write();
        wworkbook.close();*/
        
    }
    
    public static void guardar_opciones(ArrayList<String> lista0, ArrayList<String> lista1, ArrayList<String> lista2, ArrayList<String> lista3) throws Exception{
        File f=new File(".\\comandos.xls");
        Workbook wb=Workbook.getWorkbook(f);
        WritableWorkbook wworkbook=Workbook.createWorkbook(f, wb);
        WritableSheet wsheet=wworkbook.getSheet(0);
        String size0=""+lista0.size();
        String size1=""+lista1.size();
        String size2=""+lista2.size();
        String size3=""+lista3.size();
        Label labels0 = new Label(0,0,size0);
        wsheet.addCell(labels0);
        Label labels1 = new Label(1,0,size1);
        wsheet.addCell(labels1);
        Label labels2 = new Label(2,0,size2);
        wsheet.addCell(labels2);
        Label labels3 = new Label(3,0,size3);
        wsheet.addCell(labels3);
        for (int i = 0; i < lista0.size(); i++) {
            Label label0 = new Label(0,i+1,lista0.get(i));
            wsheet.addCell(label0);
        }
        for (int i = 0; i < lista1.size(); i++) {
            Label label1 = new Label(1,i+1,lista1.get(i));
            wsheet.addCell(label1);
        }
        for (int i = 0; i < lista2.size(); i++) {
            Label label2 = new Label(2,i+1,lista2.get(i));
            wsheet.addCell(label2);
        }
        for (int i = 0; i < lista3.size(); i++) {
            Label label4 = new Label(3,i+1,lista3.get(i));
            wsheet.addCell(label4);
        }     
        wworkbook.write();
        wworkbook.close();
    }
    
}
