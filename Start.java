package GBTheme6LessonCalc.CalculatorYoutube6Git;

import javax.swing.*;

public class Start{
    //1 создадим пока пустое окно:
    private JFrame window;
    public Start(){//2 инициализируем окно window
        window=new JFrame("Калькулятор");
        window.setSize(257,347);
        window.add(new Panel());//передаем конструктор Panel
        window.setLocationRelativeTo(null);//окно тогда будет в центрк экрана
        window.setResizable(false);//false -размер окна не тогда не изменить
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Start();// все что делает метод это вызывает конструктор
            }
        });
    }
}
