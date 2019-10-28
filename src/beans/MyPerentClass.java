package beans;

import java.util.ArrayList;
import java.util.Random;

public class MyPerentClass {
    private int Id;

    MyPerentClass(){}

    MyPerentClass(int id){
        Id = id;
    }
    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public static int getUniqId(ArrayList<MyPerentClass> ClassList)
    {
        Random random = new Random(System.currentTimeMillis());
        boolean isUniq;
        int uniqId;
        do {
            isUniq = true;
            uniqId = random.nextInt();
            for (MyPerentClass identifier : ClassList) {
                if (identifier.getId() == uniqId)
                    isUniq = false;
            }
        }while (!isUniq || (uniqId == 0));
        return uniqId;
    }

    public String StringView() {

        return String.format("id: %-20d", this.getId());
    }
}
