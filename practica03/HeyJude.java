public class HeyJude{
	public static String HEY = "Hey Jude ";
	public static String DON = "don't ";
	public static String MAK = "make it bad.";
	public static String BEA = "be afraid.";
	public static String LET = "let me down.";
	public static String TAK = "Take a sad song and make it better.";
	public static String YOW = "You were made to go out and get her.";
	public static String YOH = "You have found her, now go and get her.";
	public static String REM = "Remember to ";
	public static String LEH = "let her into you heart.";
	public static String LES = "let her into your skin.";
	public static String THE = "Then you ";
	public static String CAN = "can start ";
	public static String BEG = "begin ";
	public static String TOM = "to make it better ";
	public static String BET = "better ";
	public static String NA  = "na ";

	public static String AND = "And anytime you feel the pain, hey Jude, refrain,\n"
								+ "Don’t carry the world upon your shoulders.\n"
									+ "For well you know that it’s a fool who plays it cool\n"
								+ "By making his world a little colder.";

	public static String SOL = "So let it out and let it in, hey Jude, begin,\n"
								+ "You’re waiting for someone to perform with.\n"
								+ "And don’t you know that it’s just you, hey jude, you’ll do,\n"
								+ "The movement you need is on your shoulder.";

	public static void main(String[] args){
		int j=0;
		for (int i= 1;i<13;i++){
			System.out.print(HEY+DON);
			switch(i%3){
				case 1: System.out.println(MAK);
					System.out.println(TAK);
					break;
				case 2:System.out.println(BEA+YOW);
					break;
				case 3:System.out.println(LET+YOH);
					break;
			}
			System.out.print(REM);
			if(i%2==0){
				System.out.println(LEH);
			}
			else System.out.println(LES);
			System.out.print(THE);
			if (i%2==0){
				System.out.print(CAN);
			}
			else System.out.print(BEG);
			System.out.println(TOM);
			while(j!=5){
				System.out.print(BET);
				j++;
			}
			System.out.println("waaaaa");
			j=0;
			while(j!=5){
				System.out.print(NA);
				j++;
			}
			System.out.println("");
			j=0;
		}
	}   
}