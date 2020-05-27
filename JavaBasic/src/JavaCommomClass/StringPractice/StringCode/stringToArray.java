package JavaCommomClass.StringPractice.StringCode;

public class stringToArray {
    public static void main(String[] args) {
        String str = "1,2;3,4,5;6,7,8";

        String[] outlength = str.split(";");
        Double[][] resarray = new Double[outlength.length][];
        for (int i = 0;i < outlength.length;i++){
            String[] instr = outlength[i].split(",");
            int inlength = instr.length;
            resarray[i] = new Double[inlength];
            for (int j=0;j<inlength;j++){
                resarray[i][j] = Double.parseDouble(instr[j]);
            }
        }
        for (int i = 0;i < resarray.length;i++){
            for (int j=0;j<resarray[i].length;j++){
                System.out.print(resarray[i][j]+" ");
            }
            System.out.println();
        }
    }

}
