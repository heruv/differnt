import java.util.Arrays;

public class Beetle {

    public static double[]current_position;
    public static double[]A;
    public static double[]B;
    public static double[]C;
    public static  double[]next_position;
    public static float[] vector_speed;
    public static float modifier = 2;
    public static float delta_t = 1; //delta t

    public void start(int id)
    {
        int cord = 5; // temp solution - ?
        double[][] possible_position = {{0, 0}, {cord, 0}, {0, cord}};
        A = new double[]{0, cord};
        B = new double[]{0, 0};
        C = new double[]{cord, 0};

        current_position = possible_position[id-1];

        if (id != 3)
        {
            next_position = possible_position[id];
        }
        else next_position = possible_position[0];

        speed_calculation(cord);
        move();
    }

    public void speed_calculation(int cord)
    {
        if (Arrays.equals(current_position, new double[]{0, 0}))
        {
            vector_speed = new float[]{modifier, 0};
        }
        else if (Arrays.equals(current_position, new double[]{cord, 0}))
        {
            vector_speed = new float[]{-modifier, modifier};
        }
        else vector_speed = new float[]{0, -modifier};
    }

    public void move()
    {
        double[] difference = {0, 0};

        for (int i = 0; i < vector_speed.length; i++)
        {
            current_position[i] += vector_speed[i] * delta_t;
        }

        if (current_position[0] > next_position[0])
        {
            for (int i = 0; i < current_position.length; i++)
            {
                difference[i] = next_position[i] - current_position[i];
            }

            next_position = A;
        }
        else if (current_position[1] > next_position[1])
        {
            for (int i = 0; i < current_position.length; i++)
            {
                difference[i] = next_position[i] - current_position[i];
            }

            next_position = B;
        }
        else
        {
            for (int i = 0; i < current_position.length; i++)
            {
                difference[i] = next_position[i] - current_position[i];
            }

            next_position = C;
        }

        rotate(difference);
    }

    public void rotate(double[] difference)
    {
        if (Arrays.equals(next_position, A))
        {
            int angle = 135;
            current_position[0] = current_position[0] * Math.cos(angle) - current_position[1] * Math.sin(angle);
            current_position[1] = current_position[0] * Math.sin(angle) - current_position[1] * Math.cos(angle);
        }
        else if (Arrays.equals(next_position, B))
        {
            int angle = 135;
            current_position[0] = current_position[0] * Math.cos(angle) - current_position[1] * Math.sin(angle);
            current_position[1] = current_position[0] * Math.sin(angle) - current_position[1] * Math.cos(angle);
        }
        else if (Arrays.equals(next_position, C))
        {
            int angle = 90;
            current_position[0] = current_position[0] * Math.cos(angle) - current_position[1] * Math.sin(angle);
            current_position[1] = current_position[0] * Math.sin(angle) - current_position[1] * Math.cos(angle);
        }

        for (int i = 0; i < current_position.length; i++)
        {
            current_position[i] += difference[i];
        }
    }

    public double return_x() {
        return current_position[0];
    }
    public double return_y() {
        return current_position[1];
    }

    public void delete()
    {
        current_position = new double[]{0, 0};
        next_position = new double[]{0,0};
        vector_speed = new float[]{0, 0};
        modifier = 0;
    }

}