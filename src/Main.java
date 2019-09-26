class Main
{
    public static void main(String[] args)
    {
        //checks for proper number of tiles
        if (args.length != 40)
        {
            System.out.println("Incorrect amount of tiles");
            System.exit(1);
        }

        int[] start = new int[20];
        int[] goal = new int[20];

        //arguments are transformed into lists to be passed to boards
        for (int x = 0; x < 20; x++)
        {
            start[x] = Integer.parseInt(args[x]);
        }

        for (int x = 0; x < 20; x++)
        {
            goal[x] = Integer.parseInt(args[20 + x]);
        }

        boolean solved = false;
        Solver s = new Solver(start, goal, 4, 5, "Bfs");

        for (int x = 0; x < 1000000; x++)
        {
            if (s.step())
            {
                s.printPath();
                solved = true;
                //padding
                System.out.println("\n\n\n\n\n\n\n");
                break;
            }
        }

        if (!solved)
        {
            System.out.println("Not able to solve after 50000 iterations");
            //padding
            System.out.println("\n");
        }


        solved = false;
        Solver u = new Solver(start, goal, 4, 5, "A*1");

        for (int x = 0; x < 1000000; x++)
        {
            if (u.step())
            {
                u.printPath();
                solved = true;
                //padding
                System.out.println("\n\n\n\n\n\n\n");

                break;
            }
        }

        if (!solved)
        {
            System.out.println("Not able to solve after 50000 iterations");
            //padding
            System.out.println("\n");
        }


        solved = false;
        Solver v = new Solver(start, goal, 4, 5, "A*2");

        for (int x = 0; x < 300000; x++)
        {
            if (v.step())
            {
                v.printPath();
                solved = true;
                break;
            }
        }

        if (!solved)
        {
            System.out.println("Not able to solve after 50000 iterations");
        }
    }
}
