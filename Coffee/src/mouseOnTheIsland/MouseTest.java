package mouseOnTheIsland;

public class MouseTest {

    public static void main(String[] args) {
        int numSims = 1000;
        Mouse mouse = new Mouse();
        for(int i = 0; i < numSims; i++) {
            mouse.createIsland();
            mouse.edgeIsland();
            mouse.randomStart();
            mouse.mouseMov();
            if(i < 3) {
                System.out.println(mouse.getAns());
                System.out.print(mouse.printIsland() + "\n---------------------------------------------------------\n\n");
            }
        }

        System.out.println("% of times the mouse escaped: " + mouse.getEscape()+"%");
        System.out.println("% of times the mouse drowned: " + mouse.getDrown()+"%");
        System.out.println("% of times the mouse starved: " + mouse.getStarve()+"%");

    }

}
