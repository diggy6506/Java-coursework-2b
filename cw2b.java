package cw2b;

public class Cw2b extends BaseClass {
    @Override
    public void createAnimals() {
        storeAnimal(new Ant());
        storeAnimal(new Bear());
        storeAnimal(new Bird());
        storeAnimal(new Bird());
        storeAnimal(new Mouse());
        storeAnimal(new Mouse());
    }

    @Override
    public void recordMadeSound(String str) {
        System.out.println(str);
        noises.addLine(str);
    }

    @Override
    public void recordMoved(String str) {
        System.out.println(str);
        movement.addLine(str);
    }

    PGPText movement;
    PGPText noises;

    public Cw2b() {
        movement = new PGPText();
        noises = new PGPText();
    }

    @Override
    public void finish() {
        PGPFile file = new PGPFile();
        file.openWriteFile("output.txt");
        file.writeLine("List of noises made:");
        for (int i = 0; i < noises.getLineCount(); i++) {
            String item = noises.getLine(i);
            file.writeLine(item);
        }

        file.writeLine("List of movement made:");
        for (int i = 0; i < movement.getLineCount(); i++) {
            String item = movement.getLine(i);
            file.writeLine(item);
        }
        file.closeWriteFile();
    }
}
