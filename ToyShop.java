import java.io.*;
import java.util.*;

public class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizeQueue;

    public ToyShop() {
        toys = new ArrayList<>();
        prizeQueue = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateFrequency(int toyId, double frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(frequency);
                return;
            }
        }
    }

    public void organizePrizeDraw() {
        Random rand = new Random();
        for (Toy toy : toys) {
            int numDraws = (int) (toy.getFrequency() * 100);
            for (int i = 0; i < numDraws; i++) {
                prizeQueue.add(toy);
            }
        }
        Collections.shuffle(prizeQueue, rand);
    }

    public Toy getPrizeToy() {
        if (!prizeQueue.isEmpty()) {
            Toy prizeToy = prizeQueue.remove(0);
            prizeToy.decreaseQuantity();
            return prizeToy;
        }
        return null;
    }

    public void savePrizeToyToFile(Toy toy, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Prize Toy - ID: " + toy.getId() + ", Name: " + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        // Добавление игрушек
        toyShop.addToy(new Toy(1, "Toy A", 10, 0.3));
        toyShop.addToy(new Toy(2, "Toy B", 8, 0.2));
        toyShop.addToy(new Toy(3, "Toy C", 5, 0.1));

        // Обновление частоты игрушек
        toyShop.updateFrequency(1, 0.4);

        // Организация розыгрыша призов
        toyShop.organizePrizeDraw();

        // Получение и сохранение призовой игрушки
        Toy prizeToy = toyShop.getPrizeToy();
        if (prizeToy != null) {
            toyShop.savePrizeToyToFile(prizeToy, "prize_toys.txt");
        }
    }
}



  