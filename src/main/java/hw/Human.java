package hw;

public class Human extends AbstractEntity {
    private final static double STAMINA_DRAIN_MODIFIER = 16.5;
    private final static double MAX_JUMP_MODIFIER = 1.5;

    public Human(String name, Integer agile, Integer height) throws Exception {
        super(name, agile, height);
    }


    @Override
    protected void run(ObstacleCourse.Obstacle currentObstacle) {
        switch (currentObstacle.getType()) {
            case TRACK -> {
                super.stamina -= STAMINA_DRAIN_MODIFIER * currentObstacle.getLength();
            }
            case STAIRS_UP -> {
                super.stamina -= STAMINA_DRAIN_MODIFIER * currentObstacle.getLength() * 1.2;
            }
            case STAIRS_DOWN -> {
                super.stamina -= STAMINA_DRAIN_MODIFIER * currentObstacle.getLength() * 0.8;
            }
        }
    }

    @Override
    protected boolean canRunOver(ObstacleCourse.Obstacle currentObstacle) {
        switch (currentObstacle.getType()) {
            case TRACK -> {
                return super.stamina > STAMINA_DRAIN_MODIFIER * currentObstacle.getLength();
            }
            case STAIRS_UP -> {
                return super.stamina > STAMINA_DRAIN_MODIFIER * currentObstacle.getLength() * 2;
            }
            case STAIRS_DOWN -> {
                return super.stamina > STAMINA_DRAIN_MODIFIER * currentObstacle.getLength() * 0.5;
            }
        }
        return false;
    }

    @Override
    protected boolean canJumpOver(Integer heightt) {
        if (height > this.height * MAX_JUMP_MODIFIER) {
            return false;
        }
        double temp = STAMINA_DRAIN_MODIFIER * (this.height * MAX_JUMP_MODIFIER / height);
        return !(temp > this.stamina);
    }

    @Override
    protected void jump(Integer length) {
        super.stamina -= STAMINA_DRAIN_MODIFIER * (this.height * MAX_JUMP_MODIFIER / length);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", stamina=" + stamina +
                ", agile=" + agile +
                ", height=" + height +
                "} ";
    }
}
