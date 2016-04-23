public class Xplain {
  private static final String FileNotFound= "java.io.FileNotFoundException";
          
     public static String explain(Exception e){
          String message;     
           String solution;
       String result = "";
           String exception = e.toString();
         
            if(exception.contains(FileNotFound)){
                  message = "Mr.JVM says: The file you are trying to open doesn't exist in the path that you have specified \n";
                  solution = "Solution: Try checking the path of your file again , If the file doesn't exist then create a file in the name that you have specified in in your code. This is should do it!";
                result = message + solution;
           }
            
        return result;
    }
    
}
