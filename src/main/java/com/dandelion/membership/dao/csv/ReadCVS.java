package com.dandelion.membership.dao.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fengxiang on 2014/4/27 0027.
 */

public class ReadCVS {

    public static final String csvFile = "C:\\GitHub\\IndefensibleLauncherWebService\\urlCollection.csv";

    public static void main(String[] args) {

        ReadCVS obj = new ReadCVS();
        obj.read(csvFile);

    }

    public Map<String, String> read(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Map<String, String> map = new HashMap<String, String>();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] strs = line.split(cvsSplitBy);
                map.put(strs[0], strs[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

}