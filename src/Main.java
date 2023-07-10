import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome \"***game starts***\"");
        Scanner scan=new Scanner(System.in);
        int r,c,v,life=3;
        board b= new board();
        b.display_board();
        System.out.println("\n");
        //to solve automatically
//        if(b.solver()){
//            b.display_board();
//            System.out.println("solved :)");
//        }
//        else {
//            System.out.println("not able to solve ");
//        }

        while(b.iscompleted()) {
            System.out.println("Enter the r c v :");
            r = scan.nextByte();
            c = scan.nextByte();
            v = scan.nextByte();
            r--;
            c--;

            if (b.arr[r][c] == 0) {
                if (b.issafe(v, r, c)) {
                    b.arr[r][c] = v;
                    b.display_board();
                } else {
                    life--;
                    System.out.println("Wrong answer  * " + life);
                    if (life == 0) {
                        System.out.println("better luck next time ***\nThe answer");
                        if(b.solver()){
                            b.display_board();
                        }
                        break;
                    }
                }

            }
            else{
                System.out.println("It already conatin value :"+b.arr[r][c]);
            }

        }}

}