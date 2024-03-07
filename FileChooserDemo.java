import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileChooserDemo extends JFrame {
    private JTextArea textArea;
    private JButton openButton;
    private JFileChooser fileChooser;

    public FileChooserDemo() {
        // Создаем интерфейс
        createGUI();
    }

    private void createGUI() {
        // Устанавливаем параметры окна
        setTitle("Text File Viewer");
        setSize(600, 400);
        setLocationRelativeTo(null); // Центрирование окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаем текстовую область, в которую будем выводить текст файла
        textArea = new JTextArea();
        textArea.setEditable(false); // Только для чтения

        // Создаем и настраиваем JFileChooser
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // Создаем кнопку для открытия файла
        openButton = new JButton("Open File");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        // Упаковываем текстовую область в JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Добавляем компоненты на панель
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(openButton, BorderLayout.SOUTH);
    }

    private void openFile() {
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            readFile(selectedFile);
        }
    }

    private void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.setText(""); // Очищаем текстовую область перед загрузкой файла
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n"); // Добавляем строки файла в текстовую область
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Cannot read file: " + file.getAbsolutePath(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FileChooserDemo demo = new FileChooserDemo();
                demo.setVisible(true);
            }
        });
    }
}
