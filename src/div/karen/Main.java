package div.karen;
public class Main {

	public Main() {

	}

	public static void main(String[] args) {
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                CardLayoutDemo.createAndShowGUI();
	            }
	        });
	}

}
