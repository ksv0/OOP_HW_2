package hw;

public class Cat extends AbstractEntity {
    private final static double STAMINA_DRAIN_MODIFIER = 0.5;
    private final static double MAX_JUMP_MODIFIER = 10.0;
    private final static double CLIMB_MOD = 1.2;

    public Cat(String name, Integer agile, Integer height) throws Exception {
        super(name, agile, height);
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
    protected boolean canJumpOver(Integer height) {
        double temp = 1.0;
        if (height > this.height * MAX_JUMP_MODIFIER) {
            temp = CLIMB_MOD;
        }
        return !(STAMINA_DRAIN_MODIFIER * (this.height * MAX_JUMP_MODIFIER / height) * temp > this.stamina);
    }

    @Override
    protected void jump(Integer length) {
        double temp = 1.0;
        if (height > this.height * MAX_JUMP_MODIFIER) {
            temp = CLIMB_MOD;
        }
        super.stamina -= STAMINA_DRAIN_MODIFIER * (this.height * MAX_JUMP_MODIFIER / height) * temp;
    }
    @Override
    protected void die(ObstacleCourse.Obstacle currentObstacle) {
        this.stamina = 0.0;
        System.out.println(this.name + " не смог преодолеть "+currentObstacle+ " устал, упал, уснул");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", stamina=" + stamina +
                ", agile=" + agile +
                ", height=" + height +
                '}';
    }
}
