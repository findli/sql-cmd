package JSS.w04_p01;

import JSS.w04_p01.om.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomersForm {
    private JPanel contentPane;
    private JTable tableCustomers;
    private JFrame frame;
    private DefaultTableModel model;

    private CustomersFileReader readers[] = new CustomersFileReader[2];
    private Refresher refresher =  null;


    private List<Customer> buffer = new ArrayList<>(100);

    public CustomersForm(JFrame frame) {
        this.frame = frame;
    }
    // Refresher
    class Refresher extends Thread {

        boolean bStop = false;

        public void stopRefreser() {
            bStop = true;
            interrupt();
        }

        @Override
        public void run() {
            super.run();

            synchronized (buffer) {

                while (!bStop) {
                    model.setRowCount(0);

                    //synchronized (buffer) {
                    buffer.forEach((cust) ->
                                    model.addRow(new String[]{
                                            cust.getName(),
                                            cust.getPhone(),
                                            "" + cust.getRating()})
                    );

                    //}

                    try {
                        buffer.wait(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    void init() {
        model = new DefaultTableModel( new String[] {"Name", "Phone", "Rating"}, 0);
        tableCustomers.setModel(model);
        readers[0] = new CustomersFileReader(new File("src\\JSS\\w04_p01\\data\\1.txt"),500,buffer);
        readers[1] = new CustomersFileReader(new File("src\\JSS\\w04_p01\\data\\2.txt"),1000,buffer);

        refresher = new Refresher();
        refresher.start();
    }





    public static void main(String[] args) {
        JFrame frame = new JFrame("CustomersForm");
        CustomersForm form = new CustomersForm(frame);
        frame.setContentPane(form.contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.init();
        frame.pack();
        frame.setVisible(true);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        form.refresher.stopRefreser();
        new CustomersFileReader(new File("d:\\IdeaProjects\\JSS-15-09\\src\\JSS\\w04_p01\\data\\1.txt"),500,form.buffer);
        form.new Refresher().start();


    }
}
