package String;


class Main
{
    public static boolean isCircularMove(String str)
    {
        int x = 0, y = 0;
        char dir = 'N';
        for (char ch: str.toCharArray())
        {
            switch (ch)
            {
                case 'M':
                    if (dir == 'N') {
                        y++;
                    } else if (dir == 'S') {
                        y--;
                    } else if (dir == 'E') {
                        x++;
                    } else if (dir == 'W') {
                        x--;
                    } break;
                case 'L':
                    if (dir == 'N') {
                        dir = 'W';
                    } else if (dir == 'W') {
                        dir = 'S';
                    } else if (dir == 'S') {
                        dir = 'E';
                    } else if (dir == 'E') {
                        dir = 'N';
                    } break;
                case 'R':
                    if (dir == 'N') {
                        dir = 'E';
                    } else if (dir == 'E') {
                        dir = 'S';
                    } else if (dir == 'S') {
                        dir = 'W';
                    } else if (dir == 'W') {
                        dir = 'N';
                    }
            }
        }
        return (x == 0 && y == 0);
    }
 
    public static void main(String[] args)
    {
        String str = "MMRMMRMMRMM";
 
        if (isCircularMove(str)) {
            System.out.println("Circular move");
        }
        else {
            System.out.println("Non-circular move");
        }
    }
}
