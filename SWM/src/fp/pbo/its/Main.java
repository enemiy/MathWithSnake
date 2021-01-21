package fp.pbo.its;

public class Main {
	public static void main(String[] args) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Login login = new Login();
						login.setSize(640, 400);
						login.setVisible(true);
						login.setResizable(false);
				        login.setLocationRelativeTo(null);
					}
				});
}
}
