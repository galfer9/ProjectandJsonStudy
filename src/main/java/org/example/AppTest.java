package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppTest {
    public static void main(String[] args) throws Exception {
        //공공데이터 불러오기
        /* 공공데이터 회원가입>json타입 api 선택하고 활용신청함> 마이페이지>개인인증키 디코딩된 것을 활용신청한 것 인증키 활용에 넣고 api
         * 리퀘스트 url 넣고 가장 중요한 게 서비스키*/
        StringBuilder urlString = new StringBuilder("https://api.odcloud.kr/api/15077586/v1/centers");

        urlString.append("?" + "serviceKey" + "=71PAaK3PAAHZzgU5%2B9eZmbCpa3uTQBhRm%2Fg8VByJomOg4Hsovkw5eIOq9SZKC0LCAc9ft%2FrUxav%2BQ5xa43cwNQ%3D%3D");
        //옵션의 시작은 ?로 시작함. 두번째는 &로 시작. url주소는 띄어쓰기도 한 철자로 인식 정확히 해야함. 그래서 url주소는 인코딩해서 넣는 것임.
        urlString.append("&" + "page=1");
        urlString.append("&" + "perPage=10");
        System.out.println(urlString);

        URL url = new URL(urlString.toString());  //toString매서드는 항상 완전한 풀네임 url주소를 반환한다.

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");  //http메소드 GET,POST 등 중에 하나인 url요청에 대한 매소드 설정. 기본값은 get
        conn.setRequestProperty("Content-Type", "application/json"); //컨텐츠타입이 제이슨이다. 첫매개변수가 key값, 키가 있는 속성이 이미 있는 경우 이전값을 새값으로 적용
        System.out.println("Response Code:" + conn.getResponseCode());
        System.out.println(conn);

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
        JSONArray arr = (JSONArray) jsonObject.get("data"); //웹으로 보면 count는 필요없고 data만 필요하니깐
        //System.out.println(arr);
        for (Object o : arr) {
            JSONObject obj = (JSONObject) o;
            System.out.print(obj.get("id") + "\t");
            System.out.print(obj.get("facilityName") + "\t");
            System.out.print(obj.get("address") + "\t");
            System.out.print(obj.get("org") + "\t");
            System.out.print(obj.get("createdAt") + "\t");
            System.out.println(obj.get("phoneNumber"));
    }
    }
}
