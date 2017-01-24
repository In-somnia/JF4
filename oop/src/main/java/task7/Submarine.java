package task7;


@AnnotationForSubmarine(author = "KomarovaJulia", date = "24.01.2017")
public class Submarine {
    private String name;
    protected boolean EngineIsOn;
    private SubmarineEngine engine;
    public Submarine(String name)
    {
        this.name = name;
        this.engine = new SubmarineEngine();
    }

    public void sail()
    {
        engine.startTheEngine();
        System.out.println("Атомная лодка успешно запущена в плавание!");
    }

    private class SubmarineEngine
    {
        void startTheEngine()
        {
            EngineIsOn = true;
            System.out.println("Двигатель запущен.");
        }

    }
}
