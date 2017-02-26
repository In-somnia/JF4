package TestTask1;

import task1.AuxiliaryClass;
import task1.CrazyLogger;


public class LoggerOutput {

    public static void main(String[] args) {

        AuxiliaryClass object1 = new AuxiliaryClass("object1", 5, 12);
        CrazyLogger.newLog("Создан объект номер 1");
        AuxiliaryClass object2 = new AuxiliaryClass("object2", 6, 10);
        CrazyLogger.newLog("Создан объект номер 2");
        AuxiliaryClass ageWinner = object1.compareAges(object2);
        CrazyLogger.newLog("Идет сравнение объектов по возрасту");
        if (ageWinner.equals(object1))
        {
            CrazyLogger.newLog("Объект номер 1 старше объекта номер 2");
        }
        else
        {
            CrazyLogger.newLog("Объект номер 2 старше объекта номер 1");
        }
        AuxiliaryClass weightWinner = object1.compareWeight(object2);
        CrazyLogger.newLog("Идет сравнение объектов по весу");
        if (weightWinner.equals(object1))
        {
            CrazyLogger.newLog("Объект номер 1 тяжелее объекта номер 2");
        }
        else
        {
            CrazyLogger.newLog("Объект номер 2 тяжелее объекта номер 1");
        }
        CrazyLogger.newLog("Сравнение завершено");
        CrazyLogger.searchInALog();
    }
}
