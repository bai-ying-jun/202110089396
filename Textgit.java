import java.util.Scanner;

public class Textgit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolSystem scl=new SchoolSystem();
        int[] count = new int[3];
        System.out.print("依次输入大、中、小班剩余录入名额：");
        for (int i = 0; i < count.length; i++) {
            count[i] = KB.input1();
        }
        scl.setBig(count[0]);
        scl.setMedium(count[1]);
        scl.setSmall(count[2]);
        SchoolSystem schoolSystem = new SchoolSystem(scl.getBig(),
                scl.getMedium(), scl.getSmall());
        System.out.println("输入需要入取到的班级：（1--大班 2--中班  3--小班）");
        int[] tupy = new int[4];
        for (int i = 0; i < tupy.length; i++) {
            tupy[i] = KB.input();
        }
        System.out.print(scl.addStudent(tupy[0]) + " ");
        System.out.print(scl.addStudent(tupy[1]) + " ");
        System.out.print(scl.addStudent(tupy[2]) + " ");
        System.out.print(scl.addStudent(tupy[3]) + " ");
    }
}
class SchoolSystem implements ISignup,IParams{
    int big;
    int medium;
    int small;

    public SchoolSystem() {
    }

    SchoolSystem(int big, int medium, int small){
        this.big=big;
        this.medium=medium;
        this.small=small;
    }
    public void setBig(int big) {
        this.big = big;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public void setSmall(int small) {
        this.small = small;
    }

    public int getBig() {
        return big;
    }

    public int getMedium() {
        return medium;
    }

    public int getSmall() {
        return small;
    }

    @Override
    public void print() {
    }
    public Boolean addStudent(int stuType){
        if(stuType==1){
            if(big-1>=0){
                big=big-1;
                return true ;
            }else
                return false ;
        }
        if(stuType==2){
            if(medium-1>=0){
                medium=medium-1;
                return true ;
            }else
                return false ;
        }
        if(stuType==3){
            if(small-1>=0){
                small=small-1;
                return true ;
            }else
                return false;
        }
        return false;
    }
}
interface ISignup{
    public void print();
    Boolean addStudent(int stuType);
}
interface IParams{
    public int getBig();
    public int getMedium();
    public int getSmall();
}
class KB {
    static Scanner sc = new Scanner(System.in);
    public static int input() {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(sc.next());
                if (num >= 1&& num <=3)
                    break;
                else{
                    System.out.print("输入错误重新输入：");
                }
            } catch (NumberFormatException e) {
                System.out.print("输入错误，重新输入：");
            }
        }
        return num;
    }
    public static int input1(){
        int num;
        while (true) {
            try {
                num = sc.nextInt();
                if (num >= 0)
                    break;
                else{
                    System.out.print("输入错误重新输入：");
                }
            } catch (NumberFormatException e) {
                System.out.print("不得输入负数，重新输入：");
            }
        }
        return num;
    }
}