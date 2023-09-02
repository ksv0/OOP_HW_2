package hw;

public class Robot extends AbstractEntity{
    private final static double STAMINA_DRAIN_MODIFIER=20.0;
    public Robot(String name) throws Exception {
        super(name, 1, 100);
        super.stamina = 10000.0;
    }

    @Override
    protected void run(ObstacleCourse.Obstacle currentObstacle) {
        super.stamina -= STAMINA_DRAIN_MODIFIER * currentObstacle.getLength();
    }


    @Override
    protected boolean canRunOver(ObstacleCourse.Obstacle currentObstacle) {
        return super.stamina > STAMINA_DRAIN_MODIFIER * currentObstacle.getLength();
    }

    @Override
    protected boolean canJumpOver(Integer length) {
        return true;
    }

    @Override
    protected void jump(Integer length) {
    }

    @Override
    protected void die(ObstacleCourse.Obstacle currentObstacle) {
        this.stamina = 0.0;
        System.out.println(this.name + " не смог преодолеть "+currentObstacle+ " кончился заряд, упал, разбился");
    }
    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", stamina=" + stamina +
                ", agile=" + agile +
                ", height=" + height +
                '}';
    }
}
