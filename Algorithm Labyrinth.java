public class MazeTraversal 
{

    private static final int ROWS = 12;
    private static final int COLS = 12;

    private static char[][] maze = 
    {
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
        {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
        {'#', '#', '#', '.', '#', '.', '.', '.', '#', '.', '#', '#'},
        {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
        {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
        {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
        {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '#'},
        {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    private static final int[] dRow = {1, 0, -1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) 
    {
        traverse(maze, 1, 1, 0);
    }

    public static void traverse(char[][] maze, int x, int y, int direction) 
    {
        maze[x][y] = 'x';
        printMaze(maze);

        if (isSolved(x, y)) 
        {
            System.out.println("You have exited the maze!");
            return;
        }

        if (x == 1 && y == 1 && maze[1][1] == 'x' && direction != 0) 
        {
            System.out.println("No exit found!");
            return;
        }

        for (int i = 0; i < 4; i++) 
        {
            int newDirection = (direction + i) % 4;
            int newX = x + dRow[newDirection];
            int newY = y + dCol[newDirection];

            if (validMove(maze, newX, newY)) 
            {
                traverse(maze, newX, newY, newDirection);
                return;
            }
        }

        maze[x][y] = '.';
    }

    public static boolean validMove(char[][] maze, int x, int y) 
    {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS && maze[x][y] == '.';
    }

    public static void printMaze(char[][] maze) 
    {
        for (int i = 0; i < ROWS; i++) 
        {
            for (int j = 0; j < COLS; j++) 
            {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSolved(int x, int y) 
    {
        return x == ROWS - 2 && y == COLS - 2;
    }
}