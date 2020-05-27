package JavaCommomClass.StringPractice.StringDocs;

public class StringStringBufferStringBuilder {
    public static void main(String[] args) {

        /*
        增： append(...)
        删   delete(int start,int end)\deleteCharAt(int index)
        改   replace(int start,int end,String str),insert(...)
        查   charAt(int index)

        **/
        String s1 = new String();
        String s2 = new String("java");

        StringBuffer sb = new StringBuffer();
        sb.append('a');
        sb.append('b');
        StringBuffer sb2 = new StringBuffer("java");
        sb2.append('a');
    }
}
