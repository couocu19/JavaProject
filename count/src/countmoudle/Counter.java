package countmoudle;

import java.util.*;

import java.util.regex.Pattern;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {

        Scanner w = new Scanner(System.in);
        List<Object> ll = new ArrayList<>();
        String a = w.next();
        System.out.println(suffixString(a));
       // countNum(suffixString(a));
       System.out.println(countNum(suffixString(a)));

    }

    //将中缀表达式转为后缀表达式
   static List suffixString(String s){
        // 每个运算符对应的优先级大于等于自身的运算符
        //加号
        List<Character> l1 = new ArrayList<>();
       // l1.add('#');
        l1.add('+');
        l1.add('-');
        l1.add('*');
        l1.add('/');
        //减号
        List<Character> l2 = new ArrayList<>();
        //l2.add('#');
        l2.add('+');
        l2.add('-');
        l2.add('*');
        l2.add('/');
        //乘号
        List<Character> l3 = new ArrayList<>();
        //l3.add('#');
        l3.add('*');
        l3.add('/');
        //除号
        List<Character> l4 = new ArrayList<>();
        //l4.add('#');
        l4.add('*');
        l4.add('/');

        Map<Character,List> m = new HashMap<>();
        m.put('+',l1);
        m.put('-',l2);
        m.put('*',l3);
        m.put('/',l4);

        //存放运算符的栈
        Stack<Character> s1 = new Stack<>();
        //存放后缀表达式的栈
        List<Object> s2 = new ArrayList<>();

        s1.push('#');
        for(int i = 0;i<s.length();i++) {
            int t ;
            t = i;
            Character c = s.charAt(i);
            //System.out.println(s1.peek());
            //System.out.println(m.get(c).contains(s1.peek()));

            if (i != s.length()-1) {
                if (c == '(') {
                    s1.push(c);
                } else if (Character.isDigit(c)) {
                    //处理当出现的数字不是一位 的情况
                     if(!Character.isDigit(s.charAt(i+1))){
                         s2.add(c);
                     }else{
                         while(Character.isDigit(s.charAt(i+1))){
                             i++;
                         }
                         s2.add(s.substring(t,i+1));

                    }

                } else if (c == ')') {
                    while (s1.peek() != '(') {
                        s2.add(s1.pop());
                    }
                    s1.pop();
                }else if(i-1 == -1 && c == '-'){
                    while(Character.isDigit(s.charAt(i+1))){
                        i++;
                    }
                    s2.add(s.substring(t,i+1));

                }
                else if (c == '-'&& s.charAt(i-1)=='('){
                            while(Character.isDigit(s.charAt(i+1))){
                                i++;
                            }
                            s2.add(s.substring(t,i+1));

//                        }

                }
                else {
                    if(s1.peek()=='#'){
                        s1.push(c);
                    }else {
                        boolean temp = true;
                        while (!s1.isEmpty()) {
                            if (s1.peek()=='#'|| s1.peek()=='(')
                                 break;
                            Character top = s1.peek();
                           // System.out.println(top);
                            //判断此时的栈顶元素是否有优先级大于等于当前运算符
                            if(m.get(c).contains(top)) {
                                s2.add(s1.pop());
                            }else{
                                temp = false;
                                s1.push(c);
                                break;
                            }
                        }
                        if(temp) {
                            s1.push(c);
                        }
                    }
                }
            }else{
                //最后一个字符可能是右括号也可能是数字
                if(Character.isDigit(c)) {
                    s2.add(c);
                }else{
                    while (s1.peek() != '(') {
                        s2.add(s1.pop());
                    }
                    s1.pop();
                }
                //System.out.println(s1.peek());
                while(s1.peek()!='#'){
                    s2.add(s1.pop());
                }
            }

        }

       //System.out.println(s1);

//        StringBuilder sb = new StringBuilder();
//        for(Object temp :s2){
//            sb.append(temp);
//        }
        return s2;
       //return sb.toString();
    }

    //计算结果



   static int countNum(List s1) {
       int ans = 0; //用来存放和
       int flag = 0;
       for (int i = 0; i < s1.size(); i++) {

           String a = s1.get(i)+"";
           //System.out.println(a);
           //System.out.println(isNumeric(a));
           String b;
           String c;
           int num1, num2;
            if(!isNumeric(a)){
                b = s1.get(i-1)+"";
                c = s1.get(i-2)+"";
                num1 = Integer.parseInt(b);
                num2 = Integer.parseInt(c);
               // System.out.println(num1);
                //System.out.println(num2);
                if(a.equals("+")){
                    //System.out.println("!!");
                    flag = num1+num2;
                }else if(a.equals("-")){
                    flag = num2-num1;
                }else if(a.equals("*")){
                    flag = num1*num2;
                }else if(a.equals("/")){
                    flag = num2/num1;
                }
                for(int j = 0;j<3;j++){
                    int t = i-2;
                    s1.remove(s1.get(t));
                }
                i = i-2;
                s1.add(i,flag);

            }
            //System.out.println(flag);
        }

           return flag;
       }

       //判断传入的字符串是否可以转为整数
       //是整数返回true，否则返回false
//       static boolean isInteger (String str){
//           Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
//           return pattern.matcher(str).matches();
//
//       }
       static boolean isNumeric(String str) {
           boolean flag = true;
           if (str.length() == 1) {
               if (!Character.isDigit(str.charAt(0))) {
                   // flag = false;
                   return false;
               } else {
                   return true;
               }
           } else {
               for (int i = str.length(); --i > 0; ) {
                   if (!Character.isDigit(str.charAt(i))) {
                       // flag = false;
                       return false;
                   }
               }
               return true;
           }
       }
   }



