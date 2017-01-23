package task5;


public enum Disciplines {
    ЮРИСПРУДЕНЦИЯ(true), МАТЕМАТИКА(true), ФИЗИКА(true), ЛИНГВИСТИКА(false), ЛИТЕРАТУРА(false), ЭКОНОМИКА(true);

    public boolean isInteger;

    Disciplines(boolean isInteger)
    {
        this.isInteger = isInteger;
    }

}
