package libs;

/**
 *
 * @author Justinas
 */
public class ArrayHelper {
    
         /**
         * Shuffle an array of type T
         *
         * @param <T> The type contained in the array
         * @param array The array to be shuffled
         */
        public static <T> void shuffle(T[] array) {
                for (int i = array.length; i > 1; i--) {
                        T temp = array[i - 1];
                        int randIx = (int) ( Math.random() * i );
                        array[i - 1] = array[randIx];
                        array[randIx] = temp;
                }
        }
        
        public static boolean isMatrixsEqual( Integer[][] m1,Integer[][] m2 ) {
            
            if( m1.length != m2.length || m1[0].length != m2[0].length )
                return false;
            
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    if( !m1[i][j].equals( m2[i][j] ) ) 
                        return false;
                }
            }
            
            return true;
        }
        
    public static Integer[][] deepCopyIntMatrix(Integer[][] input) {
        if (input == null)
            return null;
        Integer[][] result = new Integer[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }
        
}
