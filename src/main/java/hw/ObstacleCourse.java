package hw;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleCourse {
    static final Integer WALL_MAX_HEIGHT = 350;
    static final Integer TRACK_MAX_LENGTH = 100;
    static final Integer STAIRS_UP_MAX_LENGTH = 100;
    static final Integer STAIRS_DOWN_MAX_LENGTH = 100;
    private ArrayList<Obstacle> obstacleCourse = new ArrayList<>();

    public ObstacleCourse(Integer numberOfObstacles) {
        for (int i = 0; i < numberOfObstacles; i++) {
            Obstacle temp = new Obstacle();
            if (i > 0) {
                while (temp.type.equals(obstacleCourse.get(i - 1).type)) {
                    temp = new Obstacle();
                }
            }
            this.obstacleCourse.add(temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("ObstacleCourse {\n");
        for (Obstacle obstacle : this.obstacleCourse) {
            str.append((obstacleCourse.indexOf(obstacle)+1)+". ");
            str.append( obstacle+"\n");
        }
        str.append("}\n{");
        for (Obstacle obstacle : this.obstacleCourse) {
            switch (obstacle.type.toString()) {
                case "WALL" -> {
                    str.append('|');
                }
                case "TRACK" -> {
                    str.append('_');
                }
                case "STAIRS_UP" -> {
                    str.append('/');
                }
                case "STAIRS_DOWN" -> {
                    str.append('\\');
                }
                default -> {
                    str.append(' ');
                    System.out.println("ObstacleCourse -> toString() problem " + obstacle.type.toString());
                }
            }
        }
        str.append('}');
        return str.toString();
    }

    public ArrayList<Obstacle> getObstacleCourse() {
        return obstacleCourse;
    }

    class Obstacle {
        private Integer length;
        private obstacleType type;

        public Obstacle() {
            Random r = new Random();
            switch (r.nextInt(1, obstacleType.values().length + 1)) {
                case 1 -> {
                    this.type = obstacleType.WALL;
                    this.length = r.nextInt(WALL_MAX_HEIGHT);
                }
                case 2 -> {
                    this.type = obstacleType.TRACK;
                    this.length = r.nextInt(TRACK_MAX_LENGTH);
                }
                case 3 -> {
                    this.type = obstacleType.STAIRS_UP;
                    this.length = r.nextInt(STAIRS_UP_MAX_LENGTH);
                }
                case 4 -> {
                    this.type = obstacleType.STAIRS_DOWN;
                    this.length = r.nextInt(STAIRS_DOWN_MAX_LENGTH);
                }
                default -> {
                    System.out.println("ObstacleCourse -> Obstacle() -> switch problem");
                }
            }

        }

        public Integer getLength() {
            return length;
        }

        public obstacleType getType() {
            return type;
        }

        @Override
        public String toString() {
            return "{" + type +
                    ", length=" + length +
                    '}';
        }


        enum obstacleType {
            WALL, TRACK, STAIRS_UP, STAIRS_DOWN;
        }
    }
}
