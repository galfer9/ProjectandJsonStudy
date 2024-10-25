package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();   //외부라이버리 임포트
        Employee emp = new Employee(1234,"길동","gildong@google.com");

        System.out.println(emp.toString());  //자바객체 타입 출력


        String jsonString = gson.toJson(emp);
        System.out.println(jsonString);//자바객체를 제이슨타입으로 변경헤서 자바스크립트에서 쓰게 해줌.

//        제이슨 문자열 데이터를 받아서 자바객체로 변환

        String inputData = "{\"id\":1234,\"name\":\"길동\",\"email\":\"gildong@google.com\"}";  //"" 안에다 제이슨타입데이터 넣으면 자동으로 역슬래시 넣어짐.
        Employee e = gson.fromJson(inputData,Employee.class);  //제이슨 타입 받아서 임플로이객체로 바꿔라.
        System.out.println(e);

        /*자바 리스트를 제이슨 변환*/
        Employee e1 = new Employee(1234,"길동","gildong@google.com");
        Employee e2 = new Employee(1235,"평수","peng@google.com");

        List<Employee> employees = Arrays.asList(e1, e2);
        String jsonData = gson.toJson(employees);
        System.out.println(jsonData);
        /*다시 이것(제이슨데이터를)을 거꾸로 자바객체로 변환해보자*/
        List<Employee> list = gson.fromJson(jsonData,List.class);
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.get(0));

        /* 공공데이터로 실습해보기  공공데이터로 검색해서 데이터찾기>데이터목록>이슈및>저출산고령화>데이터중 json타입찾기 */


    }
}
