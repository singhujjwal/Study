package ujjwal.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @author kodehelp
 *
 */
public class Test2 {

    public static void main(String[] args) throws ParseException {


        String stringToParse = "{\"10\":[\"3843\"],\"17\":[\"3647\"]}";

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(stringToParse);

        System.out.println(json);

        System.out.println(json.keySet());

        Set switchPhoneKeyValueSet = json.entrySet();
        Iterator entryIter = switchPhoneKeyValueSet.iterator();
        while (entryIter.hasNext()) {
            Map.Entry entry = (Map.Entry) entryIter.next();
            Object key = entry.getKey(); // Get the key from the entry.
            JSONArray arr = (JSONArray) entry.getValue(); // Get the value.
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }

        }

        String x = "12313";

    }

}
