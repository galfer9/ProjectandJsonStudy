package org.example.P0;

public class P0_review {

    P0_Social so = new P0_Social();

    String[] question = new String[so.perPageN];
    String[] ans1 = new String[so.perPageN];
    String[] ans2 = new String[so.perPageN];
    String[] ans3 = new String[so.perPageN];
    String[] ans4 = new String[so.perPageN];
    int[] answer = new int[so.perPageN];
    // new int[so.perPageN];

    public P0_review(String[] question, String[] ans1, String[] ans2, String[] ans3, String[] ans4, int[] answer) {
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.answer = answer;
    }


//    public P0_review() {
//        this.question = question;
//        this.ans1 = ans1;
//        this.ans2 = ans2;
//        this.ans3 = ans3;
//        this.ans4 = ans4;
//        this.answer = answer;
//    }

    public P0_review() { };  //기본생성자


    public String[] getQuestion() {
        return question;
    }

    public void setQuestion(String[] question) {
        this.question = question;
    }

    public String[] getAns1() {
        return ans1;
    }

    public void setAns1(String[] ans1) {
        this.ans1 = ans1;
    }

    public String[] getAns2() {
        return ans2;
    }

    public void setAns2(String[] ans2) {
        this.ans2 = ans2;
    }

    public String[] getAns3() {
        return ans3;
    }

    public void setAns3(String[] ans3) {
        this.ans3 = ans3;
    }

    public String[] getAns4() {
        return ans4;
    }

    public void setAns4(String[] ans4) {
        this.ans4 = ans4;
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
}
