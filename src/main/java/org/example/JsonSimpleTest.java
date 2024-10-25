package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;   //json.simple에도 에레이매서드 있고, json에도 어레이매서드 있으니, 두 개 라이브러리 혼용해서 쓰면 오류남.
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonSimpleTest {

    public static void main(String[] args) throws IOException, ParseException {

        //공공데이터 불러오기
        /* 공공데이터 회원가입>json타입 api 선택하고 활용신청함> 마이페이지>개인인증키 디코딩된 것을 활용신청한 것 인증키 활용에 넣고 api
         * 리퀘스트 url 넣고 가장 중요한 게 서비스키*/
        StringBuilder urlString = new StringBuilder("https://apis.data.go.kr/1160100/service/GetStocIssuInfoService_V2/getItemBasiInfo_V2");

        urlString.append("?" + "serviceKey" + "=71PAaK3PAAHZzgU5%2B9eZmbCpa3uTQBhRm%2Fg8VByJomOg4Hsovkw5eIOq9SZKC0LCAc9ft%2FrUxav%2BQ5xa43cwNQ%3D%3D&pageNo=1&numOfRows=1&resultType=xml&basDt=20231023&crno=1101114728246&stckIssuCmpyNm=복지유니온");
        //옵션의 시작은 ?로 시작함. 두번째는 &로 시작. url주소는 띄어쓰기도 한 철자로 인식 정확히 해야함. 그래서 url주소는 인코딩해서 넣는 것임.
        urlString.append("&" + "page=1");
        urlString.append("&" + "numOfRows=1");
        //System.out.println(urlString);


        URL url = new URL(urlString.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //  System.out.println(conn);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        System.out.println("Response Code:" + conn.getResponseCode());

        BufferedReader br;
        if (conn.getResponseCode() == 200) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        String result = br.readLine();

        br.close();  //버퍼드리더 닫기
        conn.disconnect(); //연결객체 닫기

        System.out.println(result);
        //제이슨 문자열로 결과를 받았음 => 파싱필요
        JSONParser jp = new JSONParser();
        JSONObject jsonObject = (JSONObject) jp.parse(result);  //result 값을 파싱해줘서 제이슨 심플라이브러리의 제이슨오브젝트로 바꿔줌.
        JSONObject responseBody = (JSONObject) ((JSONObject) jsonObject.get("response")).get("body");
        JSONArray arr = (JSONArray) responseBody.get("items"); //웹으로 보면 count는 필요없고 data만 필요하니깐
        System.out.println(arr);
        for (Object o : arr) {
            JSONObject obj = (JSONObject) o;
            System.out.print(obj.get("basDt") +  "\t");
            System.out.print(obj.get("isinCd") +  "\t");
            System.out.print(obj.get("isinCdNm") +  "\t");
            System.out.print(obj.get("scrsItmsKcd") +  "\t");
            System.out.print(obj.get("scrsItmsKcdNm") +  "\t");
            System.out.println(obj.get("stckParPrc"));
        }
    }
}
