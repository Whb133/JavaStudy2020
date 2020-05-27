package containerPractice.Container.Map;

import java.io.*;
import java.util.HashMap;

public class NameCount {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            HashMap<String,Integer> map = new HashMap();
            br= new BufferedReader(new FileReader("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\containerPractice\\Container\\Map\\name.txt"));
            String str;
            StringBuffer sb= new StringBuffer();

            flag:while ((str = br.readLine()) != null) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i)!= ' ') {
                        sb.append(str.charAt(i));
                    }else {
                        if (map.containsKey(sb.toString())){
                            map.put(sb.toString(),map.get(sb.toString())+1);
                        }else {
                            map.put(sb.toString(),1);
                        }
                        sb.setLength(0);
                        continue flag;
                    }
                }
            }
            System.out.println(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
