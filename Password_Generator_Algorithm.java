import java.util.*;

class Password_Generator_Algorithm {
    static String Arr[][] = {
        { "a", "b", "c", "d", "e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"},
        { "1", "2", "3", "4","5","6","7","8","9","0" },
        { "A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" },
        { "!", "@", "#", "$","%","^","&","*","(",")","-","=","+","<",">",",",".",";",":","/","?","\\","|","{","}","[","]","~","`","_"} };
    static String passArrF[];
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of your password: ");
        int n = -1;
        while(true){
            String len=sc.next();
            try{
                n=Integer.parseInt(len);
                break;
            }
            catch(Exception e){
                System.out.println("Please Enter a Numeric Value: ");
            }
        }
        strengthPassword(n);
    }
    static void strengthPassword(int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose the Type of Password you want to keep\n\nNORMAL\nSTRONG\nSTRONGEST\nUNBEATABLE\n\nEnter your Choice: ");
        String choice = sc.next().toLowerCase();
        passArrF=new String[n];
        Arrays.fill(passArrF, "-1");
        switch (choice) {
            case "normal":
                normal(n);
                displayPassword(n);
                break;
            case "strong":
                // increase the value of rand1 for each row, use conditional statement, and it'll be done
                strong(n);
                displayPassword(n);
                break;
            case "strongest":
                strongest(n);
                displayPassword(n);
                break;
            case "unbeatable":
                unbeatable(n);
                displayPassword(n);
                break;
            default:
                System.out.println("\n\nCHOICE DOESN'T EXISTS\nPlease Try Again");
                strengthPassword(n);
                break;
        }
    }
    static void displayPassword(int n){
        System.out.print("\nPassword: ");
        for (int i = 0; i < n; i++)
            System.out.print(passArrF[i]);
    }
    static void normal(int n){
	    int j = 0;
        for (int i = 0; i < n; i++) {
            int rand1 = (int) ((Math.random() * 4));
            int rand2 = 0;
            do {
                rand2 = (int) ((Math.random() * n));
            } while (!(passArrF[rand2].equals("-1")));
            passArrF[rand2] = Arr[j][rand1];
            if (++j == 4)
                j = 0;
        }
    }
    static void strong(int n){
        int j = 0,rand1=0;
        for (int i = 0; i < n; i++) {
            if(j==0)
                rand1 = (int) ((Math.random() * 13));
            else if(j==1)
                rand1 = (int) ((Math.random() * 7));
            else if(j==2)
                rand1 = (int) ((Math.random() * 13));
            else
                rand1 = (int) ((Math.random() * 17));
            int rand2 = 0;
            do {
                rand2 = (int) ((Math.random() * n));
            } while (!(passArrF[rand2].equals("-1")));
            passArrF[rand2] = Arr[j][rand1];
            if (++j == 4)
            j = 0;
        }
    }
    static void strongest(int n){
        int j = 0,rand1=0;
        for (int i = 0; i < n; i++) {
            if(j==0)
                rand1 = (int) ((Math.random() * 26));
            else if(j==1)
                rand1 = (int) ((Math.random() * 10));
            else if(j==2)
                rand1 = (int) ((Math.random() * 26));
            else 
                rand1 = (int) ((Math.random() * 30));
            int rand2 = 0;
            do {
                    rand2 = (int) ((Math.random() * n));
            } while (!(passArrF[rand2].equals("-1")));
            passArrF[rand2] = Arr[j][rand1];
            if (++j == 4)
                j = 0;
        }
    }
    static void unbeatable(int n){
        int rand1;
        for(int i=0;i<n;i++){
            do{
                if(i%4==0)
                    rand1=(int)((Math.random()*26));
                else if(i%4==1)
                    rand1=(int)((Math.random()*10));
                else if(i%4==2)
                    rand1=(int)((Math.random()*26));
                else 
                    rand1=(int)((Math.random()*30));
            }while(Arrays.asList(passArrF).contains(Arr[i%4][rand1]));
            int rand2;
            do{
                rand2=(int)(Math.random()*n);
            }while(!(passArrF[rand2].equals("-1")));
            passArrF[rand2]=Arr[i%4][rand1];
        }
    }
}
