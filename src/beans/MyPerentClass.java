package beans;

import java.util.ArrayList;
import java.util.Random;

public class MyPerentClass {
    private int Id;

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public static int getUniqId(ArrayList<MyPerentClass> CalssList)
    {
        Random random = new Random(System.currentTimeMillis());
        boolean isUniq;
        int uniqId;
        do {
            isUniq = true;
            uniqId = random.nextInt();
            for (MyPerentClass identifier : CalssList) {
                if (identifier.getId() == uniqId)
                    isUniq = false;
            }
        }while (!isUniq);
        return uniqId;
    }
}
