
package St1;

import java.util.StringTokenizer;

public class Simple {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("I love Coding");
        while(st.hasMoreElements()){
            System.out.println(st.nextToken());
        }
        
    }
}
