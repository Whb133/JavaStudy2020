package arrayPractice.sort;

public class TestDateSort {
    public static void main(String[] args) {
        Date[]  dates = new Date[5];
        dates[0] = new Date(2020,2,17);
        dates[1] = new Date(2019,6,8);
        dates[2] = new Date(1997,10,22);
        dates[3] = new Date(2020,3,17);
        dates[4] = new Date(2020,2,18);
        sortDate(dates);
        for (int i = 0;i<dates.length;i++){
            System.out.println(dates[i].toString());
        }
    }
    public static void sortDate(Date[] date){
        for (int i =date.length-1;i>=1;i--){
            for (int j = 0;j<i;j++){
                if(date[j].Compare(date[j+1]) > 0){
                    Date date_temp = date[j];
                    date[j] = date[j+1];
                    date[j+1] = date_temp;
                }
            }
        }
    }

}
class Date{
    private int year;
    private int month;
    private int day;
    Date(int y,int m,int d){
        this.day = d;
        this.month = m;
        this.year = y;
    }
    public int Compare(Date date){
        return this.year > date.year ? 1
                :this.year < date.year ? -1
                :this.month > date.month ? 1
                :this.month < date.month ?-1
                :this.day > date.day ? 1
                :this.day < date.day ?-1 :0;
    }

    @Override
    public String toString() {
        return this.year+"-"+this.month+"-"+this.day;
    }
}
