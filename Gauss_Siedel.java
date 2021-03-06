import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author OZGUR
 */
public class Gauss_Siedel {

    private double x1, x2, x3;//variables continuation values
    private double td; //tolerance value
    private double x1FirstValue, x2FirstValue, x3FirstValue;// variables first values
    private Scanner scan = new Scanner(System.in);
    private DecimalFormat frm = new DecimalFormat("#.####");

    public Gauss_Siedel(double td, double x1FirstValue, double x2FirstValue, double x3FirstValue) {
        this.td = td;
        this.x1FirstValue = x1FirstValue;
        this.x2FirstValue = x2FirstValue;
        this.x3FirstValue = x3FirstValue;
    }

    double calculateX1(double x1, double x2, double x3) {
        return (1 / 5.0) * (2 + x2 - 2 * x3);
    }

    double calculateX2(double x1, double x2, double x3) {
        return (1 / 5.0) * (-2 + x1 + 2 * x3);
    }

    double calculateX3(double x1, double x2, double x3) {
        return (1 / 4.0) * (4 + 2 * x1 - x2);
    }

    public void calculateGaussSiedel() {
        int i = 1, count = 0;
        while (true) {
            x1 = calculateX1(x1FirstValue, x2FirstValue, x3FirstValue);
            if ((Math.abs(x1 - x1FirstValue)) <= td) {
                count++;
            }
            x1FirstValue = x1;
            x2 = calculateX2(x1FirstValue, x2FirstValue, x3FirstValue);
            if ((Math.abs(x2 - x2FirstValue)) <= td) {
                count++;
            }
            x2FirstValue = x2;
            x3 = calculateX3(x1FirstValue, x2FirstValue, x3FirstValue);
            if ((Math.abs(x3 - x3FirstValue)) <= td) {
                count++;
            }
            x3FirstValue = x3;
            if (count == 3) {
                break;
            } else {
                count = 0;
                System.out.println(i + ".iteration:\n" + "x1: " + frm.format(x1) + "\t\t" + "x2: " + frm.format(x2) + "\t\t" + " x3: " + frm.format(x3));
                i++;
            }

        }
    }

}
