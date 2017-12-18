package com.packt.legacy;

import javax.swing.JOptionPane;

public class BookingErrorController implements ErrorMessageDisplayer {

    @Override
    public void showMessage(String title, String message, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);

    }

    @Override
    public boolean showConfirmMessage(String title, String message) {
        int output = JOptionPane.showConfirmDialog(null,
                                                   message, title, JOptionPane.YES_NO_OPTION);
        return output == JOptionPane.YES_OPTION;
    }

    public static void createAndShowTicketNotAvailableError() {
        JOptionPane.showMessageDialog(null,
                                      "Ticket is not available","Booking message",
                                      JOptionPane.WARNING_MESSAGE);
    }
    public static void createAndShowDatabaseSaveError() {
        JOptionPane.showMessageDialog(null,
                                      "Could not book ticket", "Booking Error",
                                      JOptionPane.ERROR_MESSAGE);
    }
    public static void createAndShowBookedMsg(String seats) {
        JOptionPane.showMessageDialog(null,
                                      "Following tickets" + seats+ " Booked",
                                      "Booking Info", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean createAndShowAdjacentSeatsNotAvaialble() {
        return true;
    }
}
