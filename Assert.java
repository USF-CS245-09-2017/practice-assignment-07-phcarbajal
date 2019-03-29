public class Assert
{
    public static boolean not_false(boolean cond)
    {
        if (!cond)
        {
            return true;
        }

        throw new ArrayIndexOutOfBoundsException("error");
    }
}