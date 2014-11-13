package libs;

import java.util.Random;

/**
 *
 * @author Justinas
 */
public class Busena implements Comparable<Busena> {
    public static int productIDCount = 0; 
    public int productID = 0; 
    public Integer[][] matrix;
    public int euristika;
    public boolean arSkleista = false;
    public Busena parent;
    public Vector vieta;
    public int gx = 0;
    public int fx = 0;
    
    
   public Busena( ) {
   }
   
   /*
    * Pradines busenos formavimas
    */
   public Busena( int shuffleCount ) {
       this.vieta = Constants.FinalBusena.vieta;
       this.generateMatrix( shuffleCount );
       this.euristika();
       this.fx = this.gx + this.euristika;
       
       arSkleista = true;
   }
   
   /*
    * Tikslo Busenos formavimas
    */
   public Busena( Integer[][] matrix ) {
        this.matrix = matrix;
        this.vieta = new Vector(2, 2);
        //this.euristika();
        //this.fx = this.gx + this.euristika;
   }
   
   public static Busena makeChild( Busena b, Vector to) {
       Busena.productIDCount++;
       
       Busena output = new Busena();
       output.parent = b;
       
       output.matrix = ArrayHelper.deepCopyIntMatrix( b.matrix );
       output.walk( b.vieta, to  );
       
       output.gx = b.gx + Constants.KELIO_KAINA;
       output.euristika();
       output.fx = output.gx + output.euristika;
        
       output.productID = Busena.productIDCount;
       output.arSkleista = false;
       
       return output;
   }
   
   public int getX() {
       return this.vieta.x;
   }
   
   public int getY() {
       return this.vieta.y;
   }
    
   private void euristika() {
      this.euristika = 0;
//      for (int i = 0; i < this.matrix.length; i++) {
//           for (int j = 0; j < this.matrix[0].length; j++) { 
//               if( this.matrix[i][j] != Constants.finalMatrix[i][j] ) {
//                   this.euristika++;
//               }
//           }
//       } 
     // Imam kiekviena skaicius is final matricos ir ieskom jo kordinaciu busenos matricoje 
      for (int i = 0; i < Constants.MATRIX_HEIGHT; i++) {
           for (int j = 0; j < Constants.MATRIX_WIDTH; j++) { 
               
               // ieskome busenos matricoje
               for (int k = 0; k < this.matrix.length; k++) {
                   for (int l = 0; l < this.matrix[0].length; l++) {
                       
                       if( Constants.FinalBusena.matrix[i][j].equals( this.matrix[k][l] ) ) 
                           euristika += Math.abs(i - k) + Math.abs(j - l);   
                       
                   }
               } 
           }
       }
      
   }
   
   private void generateMatrix( int movesCount ) {

       this.matrix = ArrayHelper.deepCopyIntMatrix( Constants.finalMatrix );
       
       for (int i = 0; i < movesCount; i++) {
           
           this.randomMove();
       }
              
   }

    @Override
    public int compareTo(Busena b) {        
         return this.fx - b.fx;
    }
    
    @Override
    public boolean equals(Object other) {
       if ( !(other instanceof Busena) )return false;     
       Busena otherBusena = (Busena) other; 
       
       return  ArrayHelper.isMatrixsEqual( this.matrix, otherBusena.matrix );
       
    }   

    private void walk( Vector from, Vector to ) {
        int tmpInt = this.matrix[ from.x ][ from.y ]; 
        this.matrix[ from.x ][ from.y ] = this.matrix[ to.x ][ to.y ];
        this.matrix[ to.x ][ to.y ] = tmpInt;
        
        this.vieta = to;
        
    }

    private void randomMove() {
        
        int max = 3,min = 0;
        
        Random rn = new Random( );
        boolean loop = true;
        while( loop ) {
         
            int move = rn.nextInt(max - min + 1) + min;
                       
           // System.out.println( " " + move + " " + this.vieta.x + " " + this.vieta.y );
            
            switch( move ) {
                case 0:
                      if( this.canMoveRight() ) {
                          this.walk( this.vieta, this.moveRightVector() );
                          loop = false;
                      }
                    break;
                case 1:
                      if( this.canMoveLeft() ) {
                          this.walk( this.vieta, this.moveLeftVector() );
                          loop = false;
                      }
                    break;
                case 2:
                      if( this.canMoveUp() ) {
                          this.walk( this.vieta, this.moveUpVector() );
                          loop = false;
                      }
                    break;
                case 3:
                      if( this.canMoveDown() ) {
                          this.walk( this.vieta,this.moveDownVector() );
                          loop = false;
                      }
                    break;
            }
            
        }
        
    }
    
    
    // Actions conditions
    public boolean canMoveRight() {
        return (this.getX() + 1) < 3;
    }

    public boolean canMoveLeft() {
        return (this.getX() - 1) > -1;
    }
    
    public boolean canMoveUp() {
        return (this.getY() - 1) > -1;
    }
    
    public boolean canMoveDown() {
        return (this.getY() + 1) < 3;
    }
    
    public Vector moveRightVector() {
        return new Vector(this.vieta.x + 1, this.vieta.y);
    }
    public Vector moveLeftVector() {
        return new Vector(this.vieta.x - 1, this.vieta.y);
    }
    public Vector moveUpVector() {
        return new Vector(this.vieta.x, this.vieta.y - 1);
    }
    public Vector moveDownVector() {
        return new Vector(this.vieta.x, this.vieta.y + 1);
    }
    
}
