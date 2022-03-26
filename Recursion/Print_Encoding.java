package Recursion;

public class Print_Encoding {
    public static void main(String[] args) {
        String str = "123";
        printEncoding(str,"");
    }

    private static void printEncoding(String str, String out) {
        if(str.length() == 0){
            System.out.println(out);
            return;
        }
        if(str.length() == 1){
            char ch = str.charAt(0);
            int in = ch-'0';
            out += (char)('a'+in-1);
            System.out.println(out);
            return;
        }

        printEncoding(str.substring(1),out+(char)('a'+(int)(str.charAt(0)-'0')-1));
        printEncoding(str.substring(2), out+(char)(Integer.parseInt(str.substring(0,2))+'a'-1));
    }
}
