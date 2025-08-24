package POTD;
public class Maximum_69_Number_1323{

    // Logic 1]
    public static int maximum69Number(int num){
        String s = Integer.toString(num);
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '6'){
                s = s.substring(0, i) + '9' + s.substring((i + 1), s.length());
                break;
            }
        }
        return Integer.parseInt(s);
    }



    // Logic 2
    // public static int maximum69Number(int num){
    //     String s = Integer.toString(num);
    //     s = s.replaceFirst("6", "9");
    //     return Integer.parseInt(s);
    // }


    public static void main(String[] args) {
        System.out.println(maximum69Number (9669));
    }
}
