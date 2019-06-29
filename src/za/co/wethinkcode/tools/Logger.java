package za.co.wethinkcode.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger writefile = null;
    private static BufferedWriter _bufferedWriter = null;
    private static File _file = null;
    private static FileWriter _fileWriter = null;
    private Logger() {
    }

    public static Logger getWriteFile() {
        if (writefile == null) {
            try{
                writefile = new Logger();
                _file = new File("simulation.txt");
                _fileWriter = new FileWriter(_file);
                _bufferedWriter = new BufferedWriter(_fileWriter);
            } catch (IOException ioe) {}
        }
        return writefile;
    }

    public void	fileWriter(String str) {
        try {

            _bufferedWriter.write(str);
            _bufferedWriter.newLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void close() {
        try {
            if ( _bufferedWriter != null)
                _bufferedWriter.close();
        } catch (Exception ex) {
            System.out.println("Error in closing the BufferedWriter"+ex);
        }
    }
}
