package Chapter5_1;
public class Question08 
{

	
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) 
	{
		int offsetStart = x1 % 8;
        int firstByte = offsetStart == 0 ? x1/8 : x1/8 + 1;
        
        int offsetEnd = (x2+1) % 8;
        int lastByte = offsetEnd == 0 ? x2/8 : x2/8 - 1;
        
        // Set full bytes
        for (int i = firstByte; i <= lastByte; ++i) 
        {
            screen[i + width/8*y] = (byte) 0xFF;
        }
        
        // draw start/end of line
        if (x1/8 == x2/8) 
        {
            byte mask = (byte) (0xFF >> offsetStart);
            mask &= (0xFF << 8 - offsetEnd);
            screen[firstByte - 1 + width/8*y] |= mask;
        }
        else 
        {
            if (offsetStart != 0) 
            {
                screen[firstByte - 1 + width/8*y] |= (byte)(0xFF >> offsetStart);
            }
            
            if (offsetEnd != 0) 
            {
                screen[lastByte + 1 + width/8*y] |= (byte)(0xFF << 8 - offsetEnd);
            }
        }
	}

}
