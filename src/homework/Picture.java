
package homework;


public class Picture implements Comparable<Picture> {
    private String name;
    private int number;

    public Picture(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public int compareTo(Picture o) {
        if(getNumber()>o.getNumber()){
            return 1;
        }
        else if(this.getNumber()==o.getNumber()){
            return 0;
        }
        else {

            return -1;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}
