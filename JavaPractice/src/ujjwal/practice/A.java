package ujjwal.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class A {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String commandToExecute = "/usr/bin/python /Users/ujjsingh/TopController/ujjwal-top-controller/tools/upgradeScripts/phone_details_from_switch.py -ip 10.15.254.166 -username ujjsingh -password QmFsZW5vMjM1JA== -action generate";

        Runtime cmdRunTime = Runtime.getRuntime();
        Process proc = cmdRunTime.exec(commandToExecute);
        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            if (line.indexOf("SWITCH DATA:") != -1) {
                String jsonArr = line.substring("SWITCH DATA:->".length());
                System.out.println("Ujjwal JSON Array is ");
                System.out.println(jsonArr.trim());

                try {
                    org.json.simple.JSONArray arr1 = (org.json.simple.JSONArray) JSONValue
                            .parseWithException(jsonArr.trim());
                    System.out.println("The array is-------");
                    System.out.println(arr1);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }

        BufferedReader err = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
        while ((line = err.readLine()) != null) {
            System.out.println(line);
        }

    }

}