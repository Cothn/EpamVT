/*
 * Всеволод Гринчик 751003 (HRYNCHYK USEVALAD)
 * CRUD VT 2019
 */

package beans;

import java.util.ArrayList;
import java.util.Random;

/**
 * Базавый класс для всех обьектов хранящихся в базе данных
 */
public abstract class MyPerentClass {
    /** Идентификатор обьекта */
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

    /**
     * Генерирует уникальный ID
     * @param ClassList массив существующих обьектов
     * @return новый, уникальный идентификатор обьекта
     */
    public static int getUniqId(ArrayList<MyPerentClass> ClassList)
    {
        Random random = new Random(System.currentTimeMillis());
        boolean isUniq;
        int uniqId;
        do {
            isUniq = true;
            uniqId = random.nextInt(999999999);
            for (MyPerentClass identifier : ClassList) {
                if (identifier.getId() == uniqId) {
                    isUniq = false;
                    break;
                }
            }
        }while (!isUniq || (uniqId == 0));
        return uniqId;
    }

    public String stringView() {
        return String.format("id: %-10d", this.getId());
    }
}
