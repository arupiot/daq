import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTest {
    String command;
    private boolean foundCredentials;
    ReportHandler reportHandler;

    public RunTest(String command, ReportHandler reportHandler) {
        this.reportHandler = reportHandler;
        this.command = command;
    }

    public void runCommand(String command){
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = input.readLine()) != null){
                System.out.println(line);
                if (validateLine(line)){
                   foundCredentials = true;
                }
            }
            if(foundCredentials){
                reportHandler.addText("security.passwords RESULT fail");
                reportHandler.writeReport();
            }
            else{
                reportHandler.addText("security.passwords RESULT pass");
                reportHandler.writeReport();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }


    public boolean validateLine(String line){
      return line.contains("Discovered credentials");
    }
}
