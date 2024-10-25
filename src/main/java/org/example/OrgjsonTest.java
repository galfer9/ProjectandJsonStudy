package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrgjsonTest {
    public static void main(String[] args) {
        /*제이슨오브젝트*/
        JSONObject jo = new JSONObject();  //라이브러리가 두개뜨는데 우린 orgjson선택 즉 제이슨타입으로 바꾸기 위함.
        jo.put("id", 1234);
        jo.put("name", "길동");
        jo.put("email", "gildong@gmail.com");
        System.out.println(jo.toString());

        Employee employee = new Employee(1234,"길동","gildong@gmail.com");
        JSONObject jo2 = new JSONObject(employee);
        System.out.println(jo2.toString());  //이때는 get set매소드 있어야 출력된다. toString매소드 쓰기 때문

        /*제이슨어레이 배열*/
        Employee e1 = new Employee(1234,"길동","gill@gmail.com");
        Employee e2 = new Employee(1235,"평수","peng@gmail.com");

        JSONObject j1 = new JSONObject(e1);
        JSONObject j2 = new JSONObject(e2);

        JSONArray emps = new JSONArray();
        emps.put(j1);
        emps.put(j2);

        JSONObject obj = new JSONObject();
        obj.put("employees", emps);                   //employees는 제이슨오브젝트객체에 emps라는 배열을 employees라는 이름으로 넣겠다는 뜻.
        System.out.println(obj.toString(2));  //2는 띄어쓰기 정도



    }
}
