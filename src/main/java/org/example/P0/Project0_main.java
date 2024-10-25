package org.example.P0;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Project0_main {
    public static void main(String[] args) {

        Project0_Problems Pr = new Project0_Problems();
        P0_review Rv = new P0_review();
        P0_Social Social = new P0_Social();

        // int ran = rd.nextInt(Pr.question.length); //나중에 변형을 위해 3이 아닌 길이로 사용
        int Answer = 0;
        int sco = 0;
        boolean bool = true;
        int i = 0;
        int questionN = Pr.question.length;
        int[] odap = new int[questionN];

        //문제 시작
        int j = 0;

        do {

            System.out.println("문제:" + Pr.question[j]);
            System.out.println("1번 " + Pr.ans1[j]);
            System.out.println("2번 " + Pr.ans2[j]);
            System.out.println("3번 " + Pr.ans3[j]);
            System.out.println("4번 " + Pr.ans4[j]);
            try {
                System.out.print("공공데이터학습자료 : ");
                Social.PublicApi(j);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Answer = Pr.answer[j];
            //키보드 입력
            Scanner sc = new Scanner(System.in);
            Integer inputN = sc.nextInt();
            if (inputN == Answer) {
                System.out.println("정답입니다.");
                sco = sco + 10;
            } else {
                System.out.println("오답입니다.");

                Rv.question[j] = Pr.question[j];  //Pr.question[j]
                Rv.ans1[j] = Pr.ans1[j];
                Rv.ans2[j] = Pr.ans2[j];
                Rv.ans3[j] = Pr.ans3[j];
                Rv.ans4[j] = Pr.ans4[j];
                Rv.answer[j] = Pr.answer[j];
                odap[j] = j;
            }

            System.out.println(odap[j]);
            if (j >= questionN - 1) {
                bool = false;
            }
            j++;
        }

        while (bool == true);
        System.out.println("총 획득한 점수는?" + sco);

//        for (int j = 0; j < Rv.question.length; j++) {
//            System.out.println(Rv.question[j]);
//            System.out.println(Rv.ans1[j]);
//            System.out.println(Rv.ans2[j]);
//            System.out.println(Rv.ans3[j]);
//            System.out.println(Rv.ans4[j]);
//            System.out.println(Rv.answer[j]);
//        }

        System.out.println("오답노트로 복습할래요? (Y/N)");
        Scanner sct = new Scanner(System.in);
        if (sct.next().toUpperCase().equals("Y")) {
            System.out.println("복습시작합니다.");

            // int ranR = rd.nextInt(Rv.question.length); //나중에 변형을 위해 3이 아닌 길이로 사용
            int AnswerR = 0;
            int scoR = 0;
            boolean boolR = true;
            int iR = 0;
            int questionNR = Rv.question.length;


            do {
                if (Rv.question[iR] != null) {
                    System.out.println("문제:" + Rv.question[iR]);
                    System.out.println("1번 " + Rv.ans1[iR]);
                    System.out.println("2번 " + Rv.ans2[iR]);
                    System.out.println("3번 " + Rv.ans3[iR]);
                    System.out.println("4번 " + Rv.ans4[iR]);
                    try {
                        System.out.print("공공데이터학습자료 : ");
                        Social.PublicApi(odap[iR]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AnswerR = Rv.answer[iR];

                    //키보드 입력
                    Scanner sc = new Scanner(System.in);
                    Integer inputNR = sc.nextInt();

                    if (inputNR == AnswerR) {
                        System.out.println("정답입니다.");
                        scoR = scoR + 10;
                    } else {
                        System.out.println("오답입니다.");
                    }
                    // iR = rd.nextInt(Rv.answer.length);
                }

                iR++;
                if (iR >= questionNR) {
                    boolR = false;
                }
            }
            while (boolR == true);
            System.out.println("오답노트 끝났습니다. 프로그램 종료시 오답노트 기록을 삭제합니다.");
            Arrays.fill(Rv.question, null);  //초기화는 어떤 값을 넣는다는 뜻 null은 어떤 값으로도 초기화 되지 않았다는 점에서 다른 의미임.
            Arrays.fill(Rv.ans1, null);
            Arrays.fill(Rv.ans2, null);
            Arrays.fill(Rv.ans3, null);
            Arrays.fill(Rv.ans4, null);
            Arrays.fill(Rv.answer, 0);
            System.out.println("오답노트 총 획득한 점수는?" + scoR);
        }

    }
}
