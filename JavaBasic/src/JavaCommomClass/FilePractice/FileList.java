package JavaCommomClass.FilePractice;

import java.io.File;

public class FileList {
    public static void main(String[] args) {
        File file = new File("E:\\JavaCode\\JavaStudy2020\\JavaBasic\\src\\filePractice\\A");

//        System.out.println(file.getName());
//        treeOne(file,1);

        treeTwo(file,0);

    }
    public static void treeOne(File file,int level){

        String prestr = "";
        for(int i =0;i<level;i++){
            prestr += "    ";
        }

        if(file != null){
            File[] child = file.listFiles();
            level++;
            for (int i =0 ;i<child.length;i++){
                System.out.println(prestr+child[i].getName());
                if (child[i].isDirectory()) {
                    treeOne(child[i],level);
                }
            }
        }
    }

    public static void treeTwo(File file,int level){

        String prestr = "";
        for(int i =0;i<level;i++){
            prestr += "    ";
        }

        if(file != null){
            System.out.println(prestr+file.getName());
            File[] child = file.listFiles();
            level++;
            for (int i =0 ;i<child.length;i++){
                if (child[i].isDirectory()) {
                    treeTwo(child[i],level);
                }else {
                    System.out.println(prestr+"    "+child[i].getName());
                }
            }
        }
    }
}
