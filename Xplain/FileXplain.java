import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class FileXplain implements Xplain{
    
        @Override
        public String explain(Exception exception){
                 
                 String error = exception.toString();
                 int indexof = error.indexOf(":");
                 String cause = error.substring(0, indexof);
                  //explaination cotains complete explaination for the exception thrwon   
                 String explaination = null;
            
            
            try {
                explaination = explainFromFile(cause);
                } catch (FileNotFoundException ex) {
                      System.out.println(ex.toString());
                } catch (IOException ex) {
                 System.out.println(ex.toString());
                } catch (ParseException ex) {
               System.out.println(ex.toString());
                }
                 
                 
                 return explaination; 
    }
    
    
        public String explainFromFile(String cause)  throws FileNotFoundException, IOException, ParseException{
          
          
               String explain  = null;
               String solution = null ;
               String result = null;
               
               JSONParser parser = new JSONParser();
               //reads the Json file from the path specifed
               Object obj =  parser.parse(new FileReader("C:\\Users\\Sumanth Jois\\Documents\\NetBeansProjects\\Xplain\\src\\xplain\\FileError.json"));
               JSONObject object = (JSONObject) obj;
               JSONArray jarray = (JSONArray) object.get(cause);
            
               for(int i =0; i < 1;i++){
               
               JSONObject jsonObject = (JSONObject) jarray.get(i);
               explain =  (String) jsonObject.get("Xplain");
               solution = (String) jsonObject.get("Solution");
               result = explain + "\n" +solution ;
              
              }
            
            return result;
        }
        
  }
