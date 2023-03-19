import java.util.Scanner;
public class Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comand;
        String[] koloda = new String[] {
            "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10",
            "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10",
            "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10",
            "W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8", "W9", "W10"
        };
        String karta;
        String[] igroki = new String[0];
        int c, n, k;

        while (true) {
            System.out.println("Введите команду (exit для выхода): ");
            comand = scanner.next();
            if (comand.equals("exit")) {
                break;
            } else if (comand.equals("start")) {
                n = scanner.nextInt();
                c = scanner.nextInt();
                if (c * n > koloda.length) {
                    System.out.println("Ошибка: в колоде недостаточно карт для раздачи");
                } else {
                    // Перемешаем как следует колоду
                    for (int i = 0; i < koloda.length; i++) {
                        karta = koloda[i];
                        k = (int) (Math.random() * koloda.length);
                        koloda[i] = koloda[k];
                        koloda[k] = karta;
                    }
                    // Раздадим из перемешанной колоды
                    k = 0;
                    igroki = new String[c];
                    for (int i = 0; i < c; i++) {
                        igroki[i] = "";
                        for (int j = 1; j <= n; j++) {
                            igroki[i] = igroki[i] + " " + koloda[k++];
                        }
                    }
                }
            } else if (comand.equals("get-cards")) {
                c = scanner.nextInt();
                if (c > igroki.length) {
                    System.out.println("Ошибка: номер игрока больше количества игроков");
                } else {
                    System.out.println(c + igroki[c - 1]);
                }
            } else {
                System.out.println("Ошибка: Неизвестная команда");
            }
        }
    }
}
