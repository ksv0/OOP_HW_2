package hw;

public abstract class AbstractEntity {
    protected String name;
    protected Double stamina;
    protected Integer agile;
    protected Integer height;

    public AbstractEntity(String name, Integer agile, Integer height) throws Exception {
        setName(name);
        setAgile(agile);
        setHeight(height);
        setStamina();
    }

    public void passTheObstacleCourse(ObstacleCourse course) {
        for (ObstacleCourse.Obstacle obstacle : course.getObstacleCourse()) {
            if (this.stamina > 0) {
                System.out.println("stamina: "+this.stamina+" "+obstacle);
                passObstacle(obstacle);
            } else {
                break;
            }
        }
    }

    void passObstacle(ObstacleCourse.Obstacle currentObstacle) {
        switch (currentObstacle.getType().toString()) {
            case "WALL" -> {
                if (canJumpOver(currentObstacle.getLength())) {
                    jump(currentObstacle.getLength());
                } else {
                    die(currentObstacle);
                }
            }
            case "TRACK", "STAIRS_UP", "STAIRS_DOWN" -> {
                if (canRunOver(currentObstacle)) {
                    run(currentObstacle);
                } else {
                    die(currentObstacle);
                }
            }
            default -> {
                System.out.println("AbstractEntity -> passObstacle problem " + currentObstacle.getType().toString());
            }
        }

    }

    protected abstract void run(ObstacleCourse.Obstacle currentObstacle);

    protected abstract boolean canRunOver(ObstacleCourse.Obstacle currentObstacle);

    protected abstract boolean canJumpOver(Integer length);

    protected abstract void jump(Integer length);

    protected void die(ObstacleCourse.Obstacle currentObstacle) {
        this.stamina = 0.0;
        System.out.println(this.name + " не смог преодолеть " + currentObstacle + " споткнулся, упал, умер");
    }


    protected void setName(String name) {
        this.name = name;
    }

    protected void setAgile(Integer agile) throws Exception {

        if (agile > 0) {
            this.agile = agile;
        } else {
            System.out.println(agile.toString());
            throw new Exception("agile must be > 0: " + this);
        }
    }

    private void setStamina() {

        this.stamina = agile * (height / 100.0 * 15);
    }

    protected void setHeight(Integer height) throws Exception {

        if (height > 0) {
            this.height = height;
        } else {
            throw new Exception("height must be > 0: " + this);
        }
    }

    public String getName() {
        return name;
    }

    public Double getStamina() {
        return stamina;
    }

    public Integer getAgile() {
        return agile;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "name='" + name + '\'' +
                ", stamina=" + stamina +
                ", agile=" + agile +
                ", height=" + height +
                '}';
    }
}
