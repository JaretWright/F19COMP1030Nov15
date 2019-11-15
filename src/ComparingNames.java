public class ComparingNames {
    public static void main(String[] args)
    {
        String[] friends = new String[6];

        friends[0]="Tobi";
        friends[1]="Gillian";
        friends[2]="Hervis";
        friends[3]="Leo";
        friends[4]="Derek";
        friends[5]="Ty";

        for (int i=0; i<friends.length; i++)
            System.out.println(friends[i]);

        System.out.printf("The shortest name is %s.%n", shortest(friends));
    }


    /**
     * This method receives an array of String objects and returns the shortest one
     * @param names Array of String objects
     * @return the shortest (least characters) String from the array argument
     */
    public static String shortest(String[] names)
    {
        String shortest = names[0];
        for (int i=0; i<names.length; i++)
        {
            if (shortest.length()>names[i].length())
                shortest=names[i];
        }
        return shortest;
    }

    public static String shortestName(String[] names)
    {
        String shortest= names[0];

        for(String name:names)
        {
            if (name.length()<shortest.length())
                shortest= name;
        }
        return shortest;
    }
}
