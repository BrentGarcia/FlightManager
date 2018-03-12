
/**
 *
 * Description: GUI to output search results of AirportFrame GUI
 *
 * @author Brent Garcia
 *
 * @version 1.0
 *
 */
public class FlightFrame extends javax.swing.JFrame {

    /**
     * Creates new form FlightFrame
     */
    public FlightFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(475, 500));
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);

        FlightManagerTest fmt = new FlightManagerTest();
        Itinerary[] itinerarie = fmt.manager.findItineraries(Airport.PHX, Airport.LAX, new Time(7, 10));

        jTextArea1.setText("Flight Information \n"
                + "Airline: American \n"
                + "Model: Airbus A321 \n"
                + "Departure Airport: PHX \n"
                + "Departure City: Phoenix \n"
                + "Destination Airport: LAX \n"
                + "Destination City: Los Angeles \n"
                + "Departure Time: 7:10 AM \n"
                + "Arrival Time: 8:50 AM \n"
                + "Flight Number: American 495 \n"
                + "Cost: $79.00");
        //jTextArea1.setText(itinerarie[0].toString());
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        FlightManagerTest fmt = new FlightManagerTest();
        Itinerary[] itinerarie = fmt.manager.findItineraries(Airport.PHX, Airport.LAX, new Time(7, 10));
        itinerarie[0].toString();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlightFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlightFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlightFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlightFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlightFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration
}
