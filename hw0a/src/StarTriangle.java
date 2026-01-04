public class StarTriangle {

    public static void printStars(int size){
        int row = 0;
        while(row < size){
            int col = 0;
            while(col <= row){
                System.out.print("* ");
                col++;

            }
            System.out.println();
            row++;
        }

    }

    public static void main(String[]args){
        printStars(5);
    }
}
