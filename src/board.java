public class board {
//    public int[][] arr= {{0,0,0,0,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,0,0}};

    public int[][] arr={
            {3, 0, 6, 5, 0, 8, 4, 0 ,0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}
};


    public void display_board(){

        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){

            System.out.print(arr[i][j]+" ");
                if((j+1) % 3 ==0 && j!=8 ){
                    System.out.print("| ");
                }
       }
            if((i+1)%3 ==0 && i!=8){
                System.out.println();
                for(int b=0;b<=20;b++){
                System.out.print("-");}
            }
            System.out.println();}

    }

    public boolean anscheck(int ans,int row,int col){
        if(issafe(ans,row,col)){
            arr[row][col]=ans;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean solver(){
        int row=-1;
        int col=-1;
        boolean element=true;


        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(arr[i][j]==0){
                   row=i;
                   col=j;
                   element=false;
                   break;
                }
            }
            if(element==false){
                break;
            }
        }
        // sudoko is solved
        if(element==true){
            return true;
        }

        for(int i=1;i<10;i++){
            if(issafe(i,row,col)){
                arr[row][col]=i;
                if(solver()){
                    return true;
                }
                else {
                    arr[row][col]=0;
                }
            }
        }
        return false;
    }
    public boolean issafe(int ans,int row,int col){
        //check the row
        for(int i=0;i<9;i++){
            if(arr[row][i]==ans){
                return false;
            }
        }
        //check the collume
        for(int[] j : arr){
            if(j[col]==ans){
                return false;
            }
        }
        //check in box
        int squr= (int) (Math.sqrt(9));
        int r = row -(row%squr);
        int c = col -(col%squr);
        for(int i=r; i < squr+r ;i++){
            for(int j=c; j<squr+c;j++){
                if(arr[i][j]==ans){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean iscompleted(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(arr[i][j]==0){
                    return true;
                }
            }
        }
        return false;
    }


    public void recorrect(int row,int col){
        arr[row][col]=0;
    }


}
