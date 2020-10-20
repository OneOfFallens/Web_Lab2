package beans;

public class TableRow {
    private int x;
    private double y;
    private double r;
    private String result;
    private String startTime;
    private String workTime;

    public TableRow(int x, double y, double r, String result, String startTime, String workTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.startTime = startTime;
        this.workTime = workTime;
    }

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public String getResult() {
        return result;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getWorkTime() {
        return workTime;
    }

    @Override
    public String toString() {
        return "TableRow{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result='" + result + '\'' +
                ", startTime='" + startTime + '\'' +
                ", workTime='" + workTime + '\'' +
                '}';
    }
}
