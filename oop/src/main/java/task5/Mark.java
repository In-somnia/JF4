package task5;


class Mark<T extends Number> {
    private T mark;
    Mark(T value)
    {
        mark = value;
    }

    T getValue()
    {
        return mark;
    }

    public void setValue(T value)
    {
        mark = value;
    }

}
