package InterviewProgram;

public class ObjectSum {
    static void main(String[] args) {
        Object[] number = {
                1,
                2,
                new Object[] {
                        3,
                        new Object[]{
                                4,
                                5
                        }
                }
        };
        System.out.println(sum(number));

    }

    public static int sum(Object[] number) {
        int sum = 0;
        for(Object num : number){
            if(num instanceof Number){
                sum += (int)num;
            } else if(num instanceof Object[]){
                sum += sum((Object[]) num);
            }
        }

        return sum;
    }
}
