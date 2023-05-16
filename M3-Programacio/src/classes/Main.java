package classes;

public class Main {
    public static void main(String[] args) {
        System.out.println("Empieza!");
    }
}

class Ranking extends JFrame {
    private JPanel panel_principal, panel1, panel2;
    private JTextArea ranking;
    private JLabel title;

    public Ranking() {
        panel_principal = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel_principal.setLayout(new BoxLayout(panel_principal, BoxLayout.Y_AXIS));
        ranking = new JTextArea();
        title = new JLabel("<html><u>Ranking</u></html>");
        title.setFont(new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 20));
        ranking.setOpaque(false);
        Query query = new Query();
        ResultSet rs;
        rs = query.makeSelect("select * from players order by global_points desc");

        try {
            int cont = 0;
            String data = "";
            while (rs.next() && cont < 10) {
                data = "ID: " + rs.getInt(1) + " Name: " + rs.getString(2) + " Points: " + rs.getInt(3) + "\n\n";
                ranking.setText(ranking.getText() + data);
                cont++;
            }
            query.closeConnections();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Conexion no creada correctamente");
        }
        panel1.add(title);
        panel2.add(ranking);
        panel_principal.add(panel1);
        panel_principal.add(panel2);
        add(panel_principal, BorderLayout.CENTER);
        setTitle("Ranking");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
