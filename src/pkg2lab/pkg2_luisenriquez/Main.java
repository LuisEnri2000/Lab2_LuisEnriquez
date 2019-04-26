
package pkg2lab.pkg2_luisenriquez;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {


    public static void main(String[] args) {
        
        Random r = new Random();
        
        int op = 0; boolean login = false; 
        Scanner lea = new Scanner(System.in);
        ArrayList<empleados> lista = new ArrayList();
        String nom, ape, kol, tit;
        int ed, car; double pes, alt;
        char gen;
        String user, pass;
        int gerentes = 0;
        
        while (op != 8) {
        
            System.out.println();
            System.out.println("PriceSmart!\nMenu:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Despedir empleado");
            System.out.println("3. Log In");
            System.out.println("4. Ascender cajero");
            System.out.println("5. Listar empleados");
            System.out.println("6. Modificar empleado");
            System.out.println("7. Random");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");
            op = lea.nextInt();
            
            if (op == 1) {
                if (login) {
                System.out.print("Bien!\nIngrese su nombre: ");
                nom = lea.next();
                System.out.print("Apellido: ");
                ape = lea.next();
                System.out.print("Color favorito: ");
                kol = lea.next();
                System.out.print("Edad: ");
                ed = lea.nextInt();
                System.out.println("Genero[m/f]: ");
                gen = lea.next().charAt(0);
                System.out.print("Altura (m): ");
                alt = lea.nextDouble();
                System.out.print("Peso (kg): ");
                pes = lea.nextDouble();
                /*
                double alt2 = Math.pow(alt, 2);
                if ( pes / alt2 > 24.99) {
                    System.out.println("Estas gordo!");
                }else{
                    if ( pes / alt2 < 18.5) {
                        System.out.println("Estas demasiado flaco!");
                    }else{
                        System.out.println("Buen peso!");
                    }
                }
                */
                System.out.print("Titulo: ");
                lea.nextLine();
                tit = lea.nextLine();
                
                System.out.println("Cargo: ");
                System.out.println("1. Gerente");
                System.out.println("2. Aseador");
                System.out.println("3. Cajero");
                System.out.println("4. Seguridad");
                System.out.print("Ingrese: ");
                car = lea.nextInt();
                if (car == 1) {
                    if (gerentes > 2) {
                        car = 3;
                        System.out.println("No hay puesto de gerente disponible!");
                        System.out.println("Eres un cajero, espera a ser ascendido!");
                    }else{
                        gerentes++;
                    }
                }
                
                lista.add(new empleados(nom, ape, kol, ed, gen, alt, pes, tit, car));
                }else{
                    System.out.println("Error! Inicia sesion antes!");
                }
            }
            // Despedir
            if (op == 2) {
                if (login) {
                                       
                    for (int i = 0; i < lista.size(); i++) {                      
                        System.out.println(i+". " + lista.get(i).getCargo() + " || " + lista.get(i));                  
                    }
                    System.out.print("Ingrese posicion a despedir: ");
                    int pos = lea.nextInt();
                    
                    if (  lista.get(pos).getCargo() == 1  ) {
                        gerentes--;
                    }

                    if (pos >= 0 && pos < lista.size()) {
                        lista.remove(pos);
                        System.out.println("Removido exitosamente");
                    }
                }else{
                    System.out.println("Debes ingresar sesion primero!");
                }              
            }
            // LogIn
            if (op == 3) {
                if (!login) {
                    System.out.print("Ingrese usuario: ");
                    user = lea.next();
                    System.out.print("Ingrese contrasena: ");
                    pass = lea.next();

                    if (user.equals("leobanegas") && pass.equals("99")) {
                        System.out.println("Sesion iniciada con exito!");
                        login = true;
                    }else{
                        System.out.println("Error! Usuario o contrasena incorrectos.");
                    }
                }else{
                    System.out.println("Error! Ya estas logeado!");
                }
            }
            
            // Ascender
            if (op == 4) {
                if (login) {
                    if (gerentes < 3) {
                        String fin = "";
                        // Cajeros
                        System.out.println("Cajeros");
                        System.out.println("===============");
                        for (int i = 0; i < lista.size(); i++) {  
                            if (lista.get(i).getCargo() == 1) {
                                System.out.println("Pos " + i + " || " + lista.get(i));  
                            }
                        }
                        System.out.print("Posicion del empleado: ");
                        int posi = lea.nextInt();
                        if (posi < lista.size() && posi >= 0 && lista.get(posi).getCargo() == 3){
                            lista.get(posi).setCargo(1);
                        }else{
                            System.out.println("Hubo un error! Intenta de nuevo!");
                        }
                    }
                    
                }else{
                    System.out.println("Error! Inicia sesion primero!");
                }
                
                
                
            }
            // Enlistar
            if (op == 5) {
                if (login) {
                // Gerentes
                System.out.println("Gerentes");
                System.out.println("===============");
                for (empleados t : lista) {
                    if (t.getCargo() == 1) { 
                        System.out.println(t);
                    }
                }
                System.out.println();
                
                // Aseadores
                System.out.println("Aseadores");
                System.out.println("===============");
                for (empleados t : lista) {
                    if (t.getCargo() == 2) { 
                        System.out.println(t);
                    }
                }
                System.out.println();
                
                // Cajeros
                System.out.println("Cajeros");
                System.out.println("===============");
                for (empleados t : lista) {
                    if (t.getCargo() == 3) {                        
                        System.out.println(t);
                    }
                }
                System.out.println();
                
                // Seguridad
                System.out.println("Seguridad");
                System.out.println("===============");
                for (empleados t : lista) {
                    if (t.getCargo() == 4) { 
                        System.out.println(t);
                    }
                }
                
                }else{
                    System.out.println("Error! Inicia sesion primero!");
                }
            }
            // Modificar
            if (op == 6) {
                if (login) {
                    if (lista.size() > 0){
                        for (int i = 0; i < lista.size(); i++) {                      
                            System.out.println(i+". " + lista.get(i).getCargo() + " || " + lista.get(i));                  
                        }
                        System.out.print("Ingrese posicion a modificar: ");
                        int pos = lea.nextInt();
                        if (pos >= 0 && pos < lista.size()) {   
                            System.out.println("Que desea modificar?");
                            System.out.println("1. Nombre");
                            System.out.println("2. Apellido");
                            System.out.println("3. Color");
                            System.out.println("4. Edad");
                            System.out.println("5. Genero");
                            System.out.println("6. Altura");
                            System.out.println("7. Peso");
                            System.out.println("8. Titulo");
                            System.out.println("9. Cargo");
                            System.out.println("10.Sueldo");
                            System.out.print("Ingrese: ");
                            int ops = lea.nextInt();


                            switch (ops) {
                                case 1: 
                                    System.out.println("Bien!");
                                    System.out.print("Bien!\nIngrese su nombre: ");
                                    nom = lea.next();
                                    lista.get(pos).setNombre(nom);
                                    break;

                                case 2:
                                    System.out.print("Apellido: ");
                                    ape = lea.next();
                                    lista.get(pos).setApellido(ape);
                                    break;

                                case 3:
                                    System.out.print("Color favorito: ");
                                    kol = lea.next();
                                    lista.get(pos).setColor(kol);
                                    break;

                                case 4:
                                    System.out.print("Edad: ");
                                    ed = lea.nextInt();
                                    lista.get(pos).setEdad(ed);
                                    break;

                                case 5:
                                    System.out.println("Genero[m/f]: ");
                                    gen = lea.next().charAt(0);
                                    lista.get(pos).setGenero(gen);
                                    break;

                                case 6:
                                    System.out.print("Altura (m): ");
                                    alt = lea.nextDouble();
                                    lista.get(pos).setAltura(alt);
                                    break;

                                case 7:
                                    System.out.print("Peso (kg): ");
                                    pes = lea.nextDouble();
                                    lista.get(pos).setPeso(pes);
                                    break;

                                case 8:
                                    System.out.print("Titulo: ");
                                    lea.nextLine();
                                    tit = lea.nextLine();
                                    lista.get(pos).setTitulo(tit);
                                    break;

                                case 9:
                                    System.out.println("Cargo: ");
                                    System.out.println("1. Gerente");
                                    System.out.println("2. Aseador");
                                    System.out.println("3. Cajero");
                                    System.out.println("4. Seguridad");
                                    System.out.print("Ingrese: ");
                                    car = lea.nextInt();
                                    if (car == 1) {
                                        if (gerentes > 2) {
                                            car = 3;
                                            System.out.println("No hay puesto de gerente disponible!");
                                            System.out.println("Eres un cajero, espera a ser ascendido!");
                                        }else{
                                            gerentes++;
                                        }
                                    }
                                    lista.get(pos).setCargo(car);
                                    break;

                                case 10:
                                    System.out.println("Ingrese el nuevo sueldo:");
                                    double sueldo = lea.nextDouble();
                                    lista.get(pos).setSueldo(sueldo);
                                    break;

                                default: System.out.println("No existe eso!");
                            }

                        }else{
                            System.out.println("No existe esa posicion! Intenta de nuevo");
                        }
                
                    }
                }else{
                    System.out.println("Error! Debes iniciar sesion!");
                }
                
            }
            
            if (op == 7) {
                if (login) {
                    
                    if (lista.size() > 0){
                        int x, c; 

                        for (int i = 0; i < 3; i++) {
                            x = r.nextInt(lista.size());
                            c = r.nextInt(4) + 1;

                            if (c == 1) {
                                if (gerentes < 3) {
                                    lista.get(x).setCargo(c);
                                }else{
                                    lista.get(x).setCargo(3);
                                }
                            }
                        }

                        System.out.println("Listo! Han sido cambiados algunos puestos!");
                        
                    }
                }else{
                    System.out.println("No has iniciado sesion!");
                }
            }
            
        }
        
    }
    
}
