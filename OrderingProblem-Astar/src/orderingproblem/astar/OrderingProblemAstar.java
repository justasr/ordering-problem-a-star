/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderingproblem.astar;

import java.util.Collections;
import java.util.Random;
import libs.Busena;
import libs.Constants;
import libs.Sarasas;

/**
 *
 * @author Justinas
 */
public class OrderingProblemAstar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

            Sarasas busenuSarasas = new Sarasas();

            Random rand = new Random();

            Busena currBusena = new Busena( Constants.shuffleCount );
            busenuSarasas.add( currBusena );

            int it = 0;

           while( !Constants.FinalBusena.equals( currBusena ) ) {
           // for (int ggg = 0; ggg < 100; ggg++) {

                // Nes vektorius prasideda nuo 0
                if( currBusena.canMoveLeft()  ) {
                    Busena tmpBusena = 
                            Busena.makeChild( currBusena, currBusena.moveLeftVector() );

                    if( busenuSarasas.busenaDoesNotExists( tmpBusena ) ) 
                        busenuSarasas.add( tmpBusena );
                }

               if( currBusena.canMoveRight() ) {
                    Busena tmpBusena = 
                            Busena.makeChild( currBusena, currBusena.moveRightVector() );

                    if( busenuSarasas.busenaDoesNotExists( tmpBusena ) ) 
                        busenuSarasas.add( tmpBusena );
                }

               if( currBusena.canMoveDown() ) {
                    Busena tmpBusena = 
                            Busena.makeChild( currBusena, currBusena.moveDownVector() );

                    if( busenuSarasas.busenaDoesNotExists( tmpBusena ) ) 
                        busenuSarasas.add( tmpBusena );
                }

               if( currBusena.canMoveUp() ) {
                    Busena tmpBusena = 
                            Busena.makeChild( currBusena, currBusena.moveUpVector() );

                    if( busenuSarasas.busenaDoesNotExists( tmpBusena ) ) 
                        busenuSarasas.add( tmpBusena );
                }


             //  currBusena = (Busena) Collections.min( busenuSarasas );

   //            if( currBusena.arSkleista ) {
   //               for (Object b : busenuSarasas) {
   //                 System.out.println();
   //                 Busena busena = (Busena) b;
   //
   //                 for (int i = 0; i < busena.matrix.length; i++) {
   //                    System.out.println();
   //                    for (int j = 0; j < busena.matrix[0].length; j++) {
   //                        System.out.print(" " + currBusena.matrix[i][j]);
   //                    }
   //                }
   //                System.out.println("\n fx. " + busena.fx + " gx "+ busena.gx + " euristika "+ busena.euristika +" P.ID " + busena.productID );
   //               }
   //               System.out.println("-------------------------------------");
   //               break;
   //            }


           //    currBusena.arSkleista = true;


   //            for (int i = 0; i < currBusena.matrix.length; i++) {
   //                 System.out.println();
   //                 for (int j = 0; j < currBusena.matrix[0].length; j++) {
   //                     System.out.print(" " + currBusena.matrix[i][j]);
   //                 }
   //             }
   //            System.out.println("\n fx. " + currBusena.fx + " gx "+ currBusena.gx + " euristika "+ currBusena.euristika +" P.ID " + currBusena.productID );
   //            System.out.println();
     //          System.out.println( currBusena.fx );

               Collections.sort( busenuSarasas );


                for (Object b : busenuSarasas) {

                    Busena busena = (Busena) b;

                    if( !busena.arSkleista )
                    {
                        busena.arSkleista = true;
                        currBusena = busena;
                        break;
                    }
                }          

   //             
   //             
   //              for (Object b : busenuSarasas) {
   //                 System.out.println();
   //                 Busena busena = (Busena) b;
   //                 System.out.println( busena.fx );
   //             }
   //             System.out.println(" -------- ");
   //             System.out.println("\n E. " + currBusena.fx + " P.ID " + currBusena.productID );
   //             System.out.println();

            }

           System.out.println("-------------------------------------");

            while( currBusena != null ) {
                for (int i = 0; i < currBusena.matrix.length; i++) {
                    System.out.println();
                    for (int j = 0; j < currBusena.matrix[0].length; j++) {
                        System.out.print(" " + currBusena.matrix[i][j]);
                    }
                }

                System.out.println("\n fx. " + currBusena.fx + " gx "+ currBusena.gx + " euristika "+ currBusena.euristika +" P.ID " + currBusena.productID );
                System.out.println();
                System.out.println();

                currBusena = currBusena.parent;

            } 
       }
    
}
