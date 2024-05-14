package HW11_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HW11_1 extends JFrame implements ActionListener {

    private JButton[][] buttons;
    private JLabel statusLabel;
    private TicTacToe ticTacToe; // 导入TicTacToe类来处理游戏逻辑

    public HW11_1() {
        setTitle("Tic Tac Toe");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];

        ticTacToe = new TicTacToe(); // 创建一个TicTacToe实例用于处理游戏逻辑

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Player " + ticTacToe.getCurrentPlayer() + "'s turn");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);

        getContentPane().add(boardPanel, BorderLayout.CENTER);
        getContentPane().add(statusLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (!clickedButton.getText().equals("")) {
            return; // 如果按钮已经被点击过，不做任何事情
        }

        // 获取按钮的行和列
        int row = -1, col = -1;
        outerloop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == clickedButton) {
                    row = i;
                    col = j;
                    break outerloop;
                }
            }
        }

        if (ticTacToe.makeMove(row, col)) {
            clickedButton.setText(Character.toString(ticTacToe.getCurrentPlayer()));
            if (ticTacToe.hasWinner()) {
                String winner = "Player " + ticTacToe.getCurrentPlayer();
                JOptionPane.showMessageDialog(this, winner + " wins!");
                disableAllButtons();
            } else if (ticTacToe.isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
            } else {
                ticTacToe.switchPlayer();
                statusLabel.setText("Player " + ticTacToe.getCurrentPlayer() + "'s turn");
            }
        }
    }

    private void disableAllButtons() {
        // 禁用所有按钮
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HW11_1());
    }
}
