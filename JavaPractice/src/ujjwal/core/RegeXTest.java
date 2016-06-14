package ujjwal.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegeXTest {

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("/tmp/input.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                inputList.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (String line : inputList) {
            if (line.trim().matches("^-?\\d+$")) {
                System.out.println(line + " is an integer");
            } else {
                System.out.println(line + " is NOT an integer");
            }

        }
    }

}
