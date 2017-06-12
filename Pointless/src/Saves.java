import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Saves {
	
	public static void print ()
	{
		try{
			PrintWriter output;
            output = new PrintWriter (new FileWriter ("deadState.txt"));
            // depending on the current map, prints the name of it.
            if (GGTop.mapState == GGTop.STATE.Base)output.println("Base");
            else if (GGTop.mapState == GGTop.STATE.Field)output.println("Field");
            else if (GGTop.mapState == GGTop.STATE.Grass)output.println("Grass");
            else if (GGTop.mapState == GGTop.STATE.Cave)output.println("Cave");
            else if (GGTop.mapState == GGTop.STATE.Stone)output.println("Stone");
            else if (GGTop.mapState == GGTop.STATE.Realm)output.println("Realm");
            output.close();     	
            
		}catch(Exception e){}
	}
	public String read()
	{
		try{
			 String line = "";
			 BufferedReader input;
             input = new BufferedReader (new FileReader ("deadState.txt"));
             line = input.readLine();
             input.close();
             return line;
             
		}catch (Exception e){
			return ("Base");
		}
		
	}

}
