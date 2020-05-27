package arrayPractice;

public class TestArray {
    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int[] a;
//        int i = 0;
//        if(scan.hasNext()){
//            int b = scan.nextInt();
//
//        }

//        for(int i =0;i<args.length;i++){
//            System.out.println(args[i]+" ");
//        }

        /*
        Double d1 = Double.parseDouble("3.14");
        System.out.println(d1);
        Integer i1 = Integer.parseInt("3");
        System.out.println(i1);
        Long l1 = Long.parseLong("8888888888");
        System.out.println(l1);
        Boolean b1 = Boolean.parseBoolean("true");
        System.out.println(b1);
        Short s1 = Short.parseShort("3");
        System.out.println(s1);
        Byte bt1 = Byte.parseByte("127");
        System.out.println(bt1);
        Float f1 = Float.parseFloat("3.14");
        System.out.println(f1);

         */

        float[] farray =new float[args.length];
        if(args != null && args.length!=0){

            for(int i =0;i<args.length;i++){
                farray[i]=Float.parseFloat(args[i]);
            }
        }
        for(int i =0;i<args.length;i++){
            System.out.println(farray[i]);
        }
    }
}
