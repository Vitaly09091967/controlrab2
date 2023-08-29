public class Main {
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
