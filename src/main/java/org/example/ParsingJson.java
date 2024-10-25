package org.example;
//참고로 org보다는 gson을 많이 씀 api연동이 더 쉽기 때문 구글에서 만들 었기 때문에
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
//파싱의 뜻은? 데이터 파싱해서 어떻게 한다. 즉 맞게 가공한다는 뜻
public class ParsingJson {
    public static void main(String[] args) {
        InputStream is = ParsingJson.class.getResourceAsStream("/org.example/info.json");  //getResourceAsStream 매소드가
        //리소스에서 불러오기(org.example안에는 자바파일만 있기때문) 때문에 파일 같은 경로명폴더 만들고 제이슨파일 그 안에 넣어줘야 함.
        if(is == null){
            throw new NullPointerException("파일을 찾을 수 없음."); //null일때는 파일찾을 없음 뜨고 종료
        }
        //전체 제이슨 데이터를 파싱할 수 있도록 토크너 객체로 받음. 파일을 가져왔으니까 토크너로 받을 것 그이후 가장 상위클래스인 오브젝트클래스로 받는다.
        //가장 상위클래스가 되었으니 그 이후 배열클래스든 뭐든 받을 수 있다.
        JSONTokener tokener = new JSONTokener(is);
        JSONObject Object = new JSONObject(tokener);
        JSONArray emps = Object.getJSONArray("employees");
        //제이슨 배열안에 있는 모든 제이슨 객체의 정보를 출력
        for (Object emp : emps) {     //제이슨 배열은 오브젝트로 가져올 수는 있는데 쓸때는 제이슨오브젝트로 변환해줘야 한다.
            JSONObject employee = (JSONObject) emp;  //오브젝트는 가장 상위이므로 무슨 클래스로도 받을 수 있다.(즉 다운캐스팅가능
            // 배열을 제이슨오브젝트 객체로 명시적으로 변환해준다. 제이슨오브젝트로 받고나서 배열에도 넣을 수 있고
            System.out.println(employee.get("id")+"\t");
            System.out.println(employee.get("name")+"\t");
            System.out.println(employee.get("email"));
        }


    }
}
