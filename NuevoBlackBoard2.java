import java.util.*;
/* Constanza Gomez y Katia Bellido
Noviembre 6, 2018
Segundo proyecto mates discretas*/
public class NuevoBlackBoard2{
  public static void main (String[] args){
    Scanner kb = new Scanner (System.in);
    String[] grupo1;
    String[] grupo2;
    String[] sumaGrupo;
    String[] matriculasIguales;
    String[][] matriculasEquipos;
    String[] matriculasOrdenadas;
    int[] matriculasSinA;
    grupo2= new String [100];
    grupo1= new String [100];
    sumaGrupo = new String [200];
    matriculasIguales=new String [200];
    matriculasEquipos= new String [100][100];
    matriculasOrdenadas= new String[100];

    String algo="",sinA="";
    int counter = 0,counter2=0, counter3=0, opcion=0, size1 = 0, size2 = 0, size3=0, size4=0;
    int eleccion5=0, eleccion7=0, integrantes=0, matrisinA=0;
    double sub=0.0;

    while (opcion != 9){
      System.out.println ("---------------------------------------------");
      System.out.println ("Hola, este es el nuevo Blackboard para profesores. Estas son nuestras opciones: (Eliga el número de opción que quieras efectuar)");
      System.out.println ("---------------------------------------------");
      System.out.println ("1. Ingresa matrículas del primer grupo\n2. Ingresa matrículas del segundo grupo\n3. Generar grupo con los dos grupos");
      System.out.println ("4. Generar grupo con los alumnos en ambos grupos\n5. Mostrar todos los equipos posibles en el grupo\n6. Generar todas las parejas de estudio posibles entre ambos grupos");
      System.out.println ("7. Ordenar matrículas de algún grupo de manera ascendente\n8. Revisar si un grupo de matrículas perteneces parcial o por completo a alguno de los dos grupos\n9. Salir del nuevo Blackboard para profesores");
      System.out.println ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
      opcion = kb.nextInt();

      if (opcion==1) {
       System.out.println("¿Cuántos alumnos tienes en tu primer grupo?");
       size1 = kb.nextInt();
       System.out.println ("Ingresa las matrículas del primer grupo");
       for (counter=0; counter < size1; counter++ ) {
         grupo1[counter]= kb.next();
       }//termina for
      System.out.println (" "); //espacio en blanco

       for (counter=0;counter<size1 ;counter++ ) {
         System.out.println("*"+grupo1[counter]);
       }//solo para imprimir
      }//termina if opcion 1

      if (opcion==2) {
        System.out.println("¿Cuántos alumnos tienes en tu segundo grupo?");
        size2 = kb.nextInt();;
        System.out.println ("Ingresa las matrículas del segundo grupo");
        for (counter=0; counter < size2; counter++ ) {
          grupo2[counter]= kb.next();
        }
        System.out.println (" "); //espacio en blanco
        for (counter=0;counter<size2 ;counter++ ) {
          System.out.println("*"+grupo2[counter]);
        }//solo para imprimir
      }//ends else if opcion 2

      if (opcion==3) {

        size3=(size1+size2);
        if (size3==0) {
          System.out.println("Creo que no creaste los grupos :D");
        }
        for (counter=0, counter2=0; counter < size1; counter++ ) {
            sumaGrupo[counter]= grupo1[counter2];
            counter2++;
        }// no se nada :(
        for (counter=size1,counter3=0;counter < size3 ; counter++ ) {
          sumaGrupo[counter]= grupo2[counter3];
          counter3++;
        }//ends for
        for (counter=0;counter<size3 ;counter++ ) {
          System.out.println("-"+sumaGrupo[counter]);
        }
      }// termina opcion3

      if (opcion==4) {
        if (size1>size2) {
        System.out.println (" "); //espacio en blanco
         System.out.println("Estas son las matrículas que aparecen en los dos grupos: ");
          for (counter=0,size4=0;counter<size1 ;counter++ ) {
            for (counter2=0;counter2<size2 ;counter2++ ) {
              if (grupo1[counter].equals(grupo2[counter2])) {
                matriculasIguales[size4]=grupo1[counter];
                System.out.print("^"+matriculasIguales[counter]);
                size4++;
              }//
            }//termina for nested
            if (size4==0) {
              System.out.print("ninguna");
            }
          }
        }//termina if nested
        else if (size2>size1) {  //esta parte esta arriba el primer if todavía nop:D
          System.out.println (" "); //espacio en blanco
          System.out.println("Estas son las matrículas que aparecen en los dos grupos: ");
          for (counter=0,size4=0;counter<size2 ;counter++ ) {
            for (counter2=0;counter2<size1 ;counter2++ ) {
              if (grupo1[counter2].equals(grupo2[counter])) {
                matriculasIguales[size4]=grupo2[counter];
                  System.out.print("^"+matriculasIguales[size4]);
                size4++;
              }//
            }//termina for nested
            if (size4==0) {
              System.out.print("ninguna");
            }
          }//termina for :D
        }//termina else if
        else if (size2==size1) {
            System.out.println("estas son las matrículas que aparecen en los dos grupos: ");
            for (counter=0,size4=0;counter<size2 ;counter++ ) {
              for (counter2=0;counter2<size1 ;counter2++ ) {
                if (grupo1[counter2].equals(grupo2[counter])) {
                  matriculasIguales[size4]=grupo2[counter];
                    System.out.println("^"+matriculasIguales[size4]);
                  size4++;
                }//
              }//termina for nested
              if (size4==0) {
                System.out.print("ninguna");
              }
            }//termina for :D
        }//termina else 2

      }//termina if opcion4

      if (opcion==5){
        System.out.println ("¿De que grupo quieres formar los equipos?");
        eleccion5 = kb.nextInt();
        if (eleccion5==1){
          sub = Math.pow(2, size1) -1;
          System.out.println ("vacío");
          for (counter=1;counter<=size1 ;counter++) {
            Perm2(grupo1, "",counter, size1);
          }

        } //termina if primer grupo
        if (eleccion5==2){
          sub = Math.pow(2, size2-1);
        } //termina if segundo grupo
      } //termina opcion 5

      if (opcion==6){

        if (size1>size2) {
          for (counter=0;counter<size1 ;counter++ ) {
            for (counter2=0;counter2<size2 ;counter2++ ) {
              if (!(grupo1[counter].equals(grupo2[counter2]))) {
                System.out.print(grupo1[counter]);
                System.out.print(grupo2[counter2]);
                System.out.println(" ");
              }//


            }//termina for nested


          }//termina for :D
        }//termina if nested
        else if (size2>size1) {  //esta parte esta arriba el primer if todavía nop:D
          System.out.println("estas son las matrículas que aparecen en los dos grupos: ");
          for (counter=0,size4=0;counter<size2 ;counter++ ) {
            for (counter2=0;counter2<size1 ;counter2++ ) {
              if (!(grupo1[counter2].equals(grupo2[counter]))) {
                System.out.print(grupo1[counter2]);
                System.out.print(grupo2[counter]);
                System.out.println(" ");
              }//

            }//termina for nested

          }//termina for :D
        }//termina else if
        else if (size2==size1) {
            System.out.println("estas son las matrículas que aparecen en los dos grupos: ");
            for (counter=0,size4=0;counter<size2 ;counter++ ) {
              for (counter2=0;counter2<size1 ;counter2++ ) {
                if (!(grupo1[counter2].equals(grupo2[counter]))) {
                  System.out.print(grupo1[counter2]);
                  System.out.print(grupo2[counter]);
                  System.out.println(" ");
                }//
              }//termina for nested

            }//termina for :D
        }//termina else 2

      } //termina opcion 6

      if (opcion==7) {
        String nuevo="";
        matriculasSinA= new int [size1];
        System.out.println("Cual grupo quieres Ordenar?");

        eleccion7= kb.nextInt();
        if (eleccion7==1) {
          for (counter=0;counter<size1; counter++) {
              sinA=grupo1[counter];
              nuevo= sinA.replace("a","1");
              matrisinA= Integer.parseInt(nuevo);
              matriculasSinA[counter]=matrisinA;

          }//termina for
          Arrays.sort(matriculasSinA);
          System.out.println(Arrays.toString(matriculasSinA));
          for (counter=0;counter<size1 ;counter++ ) {
          System.out.println(matriculasSinA[counter]);
          }

        }//termina if
        else if(eleccion7==2) {
          matriculasSinA= new int [size2];
          for (counter=0;counter<size2; counter++) {
              sinA=grupo2[counter];
              nuevo= sinA.replace("a","1");
              matrisinA= Integer.parseInt(nuevo);
              matriculasSinA[counter]=matrisinA;

          }//termina for
          Arrays.sort(matriculasSinA);
          System.out.println(Arrays.toString(matriculasSinA));
          for (counter=0;counter<size2 ;counter++ ) {
          System.out.println(matriculasSinA[counter]);
          }
        }
        else {
          System.out.println("Solo tienes dos grupos, porfa date cuenta");
        }
      }//termina opcion7

    } //fin while
  } //fin main
  public static void Perm2(String[] elem, String act, int n, int r) {
        if (n == 0) {
            System.out.println(act);
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ", ", n - 1, r);
                }
            }
        }
    }
} //fin class
