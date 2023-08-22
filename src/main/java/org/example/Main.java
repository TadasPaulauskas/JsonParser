package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.wix.com/_serverless/hiring-task-spreadsheet-evaluator/sheets");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            System.out.println(httpURLConnection.getResponseCode());
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            if (httpURLConnection.getResponseCode() == 200) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                }
                bufferedReader.close();
//                System.out.println(stringBuffer.toString());
            }
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());

            JSONArray jsonArray = jsonObject.getJSONArray("sheets");
//            System.out.println(jsonObject.getJSONArray("sheets"));
//            System.out.println(jsonArray);
            System.out.println(jsonArray.length());

            JSONObject jsonObject2 = jsonArray.getJSONObject(4);
            System.out.println(jsonObject2);

            String sheetID = jsonObject2.getString("id");
            System.out.println(sheetID);

            JSONArray jsonArrayData = jsonObject2.getJSONArray("data");
            System.out.println(jsonArrayData);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//                String line = bufferedReader.readLine();
//                while (line != null) {
//                    System.out.println(line);
//                    line = bufferedReader.readLine();
//                }