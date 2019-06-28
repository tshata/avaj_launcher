package za.co.wethinkcode.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger writefile = null;
    private static BufferedWriter bw = null;
    private static File file = null;
    private static FileWriter fw = null;
    private Logger() {
    }

    public static Logger getWriteFile() {
        if (writefile == null) {
            try{
                writefile = new Logger();
                file = new File("simulation.txt");
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
            } catch (IOException ioe) {}
        }
        return writefile;
    }

    public void	writetofile(String str) {
        try {

            bw.write(str);
            bw.newLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void close() {
        try {
            if ( bw != null)
                bw.close();
        } catch (Exception ex) {
            System.out.println("Error in closing the BufferedWriter"+ex);
        }
    }
}
