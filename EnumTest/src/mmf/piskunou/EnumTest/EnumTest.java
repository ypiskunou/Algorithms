package mmf.piskunou.EnumTest;

public class EnumTest {
    public static void main(String args[]){
        HeadDirection headDirection = HeadDirection.Right;
        System.out.println(headDirection.ordinal());
        System.out.println(HeadDirection.values()[2]);
    }
}
