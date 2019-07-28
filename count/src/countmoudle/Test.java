package countmoudle;

import java.util.Stack;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        String str = "123456789";//字符串长度是9
        String tempStr = str.substring(0, 9);

        System.out.println(tempStr);
        List<Object> l = new ArrayList<>();
        l.add('c');
        l.add("coucou1");
        l.add("coucou2");
        l.add("coucou3");
        l.add("coucou4");
        String m = l.get(0)+"";
        System.out.println(m);
        System.out.println(l);
        l.remove("coucou1");
        System.out.println(l);


        Character s = '2';
        //System.out.println(Character.isDigit(s));
        Stack<Character> a = new Stack<>();
        a.push('a');
        a.push('b');
        a.push('c');
        a.push('d');
//        while(!a.isEmpty()){
//            System.out.println(a.pop());
//        }


        System.out.println(isNumeric("-2000"));
       // System.out.println(isInteger("+"));


    }

    static boolean isInteger(String str){
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();

    }
    //            if(a.length()==1){
//                if(Character.isDigit(a.charAt(0))){
//                   temp = Integer.valueOf(a);
//                }else{
//                    Character b = a.charAt(0);
//                    temp = (Character)b;
//
//                }
//            }else{
//                 temp = Integer.valueOf(a);
//            }


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
