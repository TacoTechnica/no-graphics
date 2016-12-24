import java.io.BufferedReader;
import java.io.InputStreamReader;

// Class that handles executing commands
public class ExecuteShellCommand {
    
    // executes command and returns its output
    public String executeCommand(String... commandLine) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(commandLine);
            p.waitFor();
            BufferedReader reader 
                = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            System.err.println("Error executing command and reading buffer....");
            e.printStackTrace();
        }
        return output.toString();
    }
}
