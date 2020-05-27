package arrayPractice.yasef;

public class Kid3Quit {
    public static void main(String[] args) {
        KidCircle kc = new KidCircle(500);
        int countnum = 0;
        Kid k = kc.first;
        while (kc.count > 1){
            countnum++;
            if (countnum == 8){
                countnum= 0;
                kc.delect(k);
            }
            k= k.right;
        }
        System.out.println(kc.first.getId());
    }
}
class  Kid{
    private int id;
    Kid left;
    Kid right;
    Kid(int id){
        this.id = id;
    }
    int getId(){
        return id;
    }
}

//双向循环链表
class KidCircle{

    int count = 0;
    Kid first;
    Kid last;

    KidCircle(int n){
        for (int i =0;i<n;i++){
            add();
        }
    }
    void add(){
        Kid kid = new Kid(count);
        if(count <= 0){
            first = kid;
            last = kid;
            kid.left = kid;
            kid.right = kid;
        }else{
            last.right = kid;
            first.left = kid;
            kid.left=last;
            kid.right=first;
            last = kid;
        }
        count++;
    }
    void delect(Kid kid){
        if(count == 0){
            return;
        }else if(count == 1){
            last = first =null;
        }else {
            kid.left.right = kid.right;
            kid.right.left = kid.left;

            if(kid == first){
                first = kid.right;
            }else if (kid == last){
                last = kid.left;
            }
        }
        count--;
    }
}
