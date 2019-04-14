import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PrintAttendance extends ModuleBase {

	public PrintAttendance(MessageReceivedEvent event) {
		super(event, "");
		
	}

	@Override
	public void process(String s) {
		
		String line;
		String fileName = "AttendanceDatabase";
		
		//reading the file
		try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

				while((line = bufferedReader.readLine()) != null) {
	                new SendMessage(event,line);
	            }   

	            // Always close files.
	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }

	}

}
