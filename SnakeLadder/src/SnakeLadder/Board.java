package SnakeLadder;

public class Board {
	int board[] =
	    {
	     100, 99, 98, 97, 96, 95, 94, 93, 92, 91,
	      81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
	      80, 79, 78, 77, 76, 75, 74, 73, 72, 71,
	      61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
	      60, 59, 58, 57, 56, 55, 54, 53, 52, 51,
	      41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
	      40, 39, 38, 37, 36, 35, 34, 33, 32, 31,
	      21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
	      20, 19, 18, 17, 16, 15, 14, 13, 12, 11,
	       1,  2,  3,  4,  5,  6,  7,  8,  9, 10
	    };
	
	int snake[] =
	    {
	      0, -50,  2,  3,  4,  5,  6,  7,  8,  9,
	      10, 11, 12, 13, 14, 15, 16, 17, 18, -48,
	      20, 21, 22, 23, 24, 25, -55, 27, 28, 29,
	      30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
	      40, 41, 42, 43, -63, 45, 46, 47, 48, 49,
	      50, 51, 52, 53, 54, 55, -78, 57, 58, 59,
	      60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
	     -91, 71, 72, 73, 74, 75, -85, 77, 78, 79,
	      80, 81, 82, 83, 84, 85, 86, 87, 88, 89,
	      90, 91, 92, 93, 94, 95, 96, 97, 98, 99
	    };
	
	int ladder[] = 
			{
		     -0, -1, -2, -3, -4, -5, -6, -7, -8, -9,
		    -10, -11, -12, -13, -14, -15, -16, -17, -18, -19,
		    -20, -21, -22, -23, -24, 4, -26, -27, -28, -29,
		    21, -31, -32, -33, 13, -35, -36, -37, -38, -39,
		    -40, -41, -42, -43, -44, -45, -46, -47, -48, -49,
		    -50, -51, -52, -53, -54, -55, -56, -57, -58, -59,
		    -60, -61, -62, -63, -64, -65, -66, -67, 49, -69,
		    -70, -71, 51, -73, -74, -75, -76, -77, -78, -79,
		    -80, -81, -82, -83, -84, -85, -86, -87, -88, -89,
		    -90, -91, -92, -93, -94, -95, -96, -97, -98, -99
		    };
}