package org.example.P0;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class P0_Social {
    public int perPageN = 3;

    public P0_Social()  { }

    public void PublicApi(int num) throws IOException, ParseException {

        StringBuilder urlString = new StringBuilder("https://api.odcloud.kr/api/15067117/v1/uddi:33e324cb-fbd3-46e6-8317-a24d3c3cc8eb");
        urlString.append("?" + "page=1");
        urlString.append("&" + "perPage=" + perPageN);
        urlString.append("&" + "serviceKey=" + "71PAaK3PAAHZzgU5%2B9eZmbCpa3uTQBhRm%2Fg8VByJomOg4Hsovkw5eIOq9SZKC0LCAc9ft%2FrUxav%2BQ5xa43cwNQ%3D%3D");


        //System.out.println(urlString);


        URL url = new URL(urlString.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //System.out.println(conn);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        //System.out.println("Response Code:" + conn.getResponseCode());

        BufferedReader br;
        if (conn.getResponseCode() == 200) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }

        String result = br.readLine();

        br.close();  //버퍼드리더 닫기
        conn.disconnect(); //연결객체 닫기

       // System.out.println(result);
        //제이슨 문자열로 결과를 받았음 => 파싱필요
        JSONParser jp = new JSONParser();
        JSONObject jsonObject = (JSONObject) jp.parse(result.toString());  //result 값을 파싱해줘서 제이슨 심플라이브러리의 제이슨오브젝트로 바꿔줌.
        JSONArray arr = (JSONArray) jsonObject.get("data"); //웹으로 보면 count는 필요없고 data만 필요하니깐
        //System.out.println(arr);


            JSONObject obj = (JSONObject) arr.get(num);
            System.out.println(obj.get("바로가기 URL")+"\t");
            System.out.print(obj.get("부제") + "\t");
            System.out.print(obj.get("주제") + "\n");

        /*for (Object o : arr) {
            JSONObject obj = (JSONObject) o;
            System.out.print(obj.get("바로가기 URL") + "\n");
            System.out.print(obj.get("부제") + "\n");
            System.out.print(obj.get("주제") + "\n");

        }*/
    }
}
