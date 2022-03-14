package data_structure;
public class demo {
    int a;

    static class pair{
        int x;
        int y;
       
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    void get(){
        System.out.println("abs");
    }

    public static void main(String[] args) {
        demo obj = new demo();
        obj.get();
        pair pa = new pair(4,5);
        System.out.println(pa.x+" "+pa.y);
    }

}

