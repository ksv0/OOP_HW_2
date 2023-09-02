package hw;

import java.util.ArrayList;
import java.util.Random;

/**
 * Кардаполов СВ
 * Разработчик | Программист | будни вечер | 4720 | 13.06.23
 */


public class Main {
    public static void main(String[] args) {
        ArrayList sportsmanList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            try {
                sportsmanList.add(new Cat("Cat" + (i + 1), r.nextInt(40, 60), r.nextInt(15, 35)));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        for (int i = 0; i < 30; i++) {
            try {
                sportsmanList.add(new Human("Human" + (i + 1), r.nextInt(250, 300), r.nextInt(170, 200)));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        try {
            sportsmanList.add(new Robot("Robot"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        for (Object o : sportsmanList) {
            System.out.println(o);
        }

        try {
            ObstacleCourse track1 = new ObstacleCourse(10);

            System.out.println("\n\n");
            for (Object o : sportsmanList) {
                ((AbstractEntity) o).passTheObstacleCourse(track1);
                if (((AbstractEntity) o).getStamina() > 0) {
                    System.out.println(o);
                }
                System.out.println();
            }
            System.out.println(track1);
        } catch (Exception ex) {
            System.out.println(ex);
        }


    }
}

