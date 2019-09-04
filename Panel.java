package GBTheme6LessonCalc.CalculatorYoutube6Git;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {
    //4 создадим кнопки через массив
    private JButton[] buttonNum = new JButton[10];
    private Font font = new Font("SANS_SERIF", Font.BOLD, 20);
    // 7 поле текста делаем и затем инит в конструкторе Panel
    private JTextField outPut = new JTextField();
    private JButton backspace=new JButton("<"), equ=new JButton("="),
            plus=new JButton("+"),minus=new JButton("-"),multiply=new JButton("*"),
    divid=new JButton("/"), pow=new JButton("^");//11 объявили backspace и другие кноп
    // делаем интим в конструкторе Panel

    public Panel() {//3 делаем простецкий конструктор
        setLayout(null);//эта команда даст размещать элементы везде
        setFocusable(true);//11 мы позволяем нанели забирать себе фокус
        grabFocus();//11 забираем фокус(запрашиваем)

        equ.setBounds(10,250,50,50);
        equ.setFont(font);
        add(equ);//просто добавляем equ в панель

        plus.setBounds(10,250,50,50);
        plus.setFont(font);
        add(plus);//просто добавляем plus в панель

        minus.setBounds(10,250,50,50);
        minus.setFont(font);
        add(minus);//просто добавляем minus в панель

        multiply.setBounds(10,250,50,50);
        multiply.setFont(font);
        add(multiply);//просто добавляем multiply в панель

        divid.setBounds(10,250,50,50);
        divid.setFont(font);
        add(divid);//просто добавляем divid в панель

        pow.setBounds(10,250,50,50);
        pow.setFont(font);
        add(pow);//просто добавляем pow в панель

        /**
         * после остальных кнопок 0 инициализируем сами
         */
        buttonNum[0] = new JButton("0");//
        buttonNum[0].setBounds(1 * (50 + 10) + 10, 3 * (50 + 10) + 70, 50, 50);//
        buttonNum[0].setFont(font);//задаем шрифт цифрам
        add(buttonNum[0]);// 6 в панель Panel добавили
        // как захочется по любым координатам
        /*JButton button1=new JButton("123");//ЗАГЛУШКА//ЗАГЛУШКА
        button1.setBounds(70,190,50,50);//ЗАГЛУШКА//ЗАГЛУШКА
        add(button1);*///ЗАГЛУШКА//ЗАГЛУШКА//ЗАГЛУШКА//ЗАГЛУШКА
        //в конструкторе инициализируем кнопки:
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                //5 тогда сможем пройти по всем элементам массива кроме нулевого
                buttonNum[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + "");//
                buttonNum[x * 3 + y + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);//
                buttonNum[x * 3 + y + 1].setFont(font);//задаем шрифт цифрам
                add(buttonNum[x * 3 + y + 1]);// в панель Panel добавили
            }
        }
        outPut.setBounds(10, 10, 230, 50);
        outPut.setEditable(false);//false - теперь нельзя изменять написпнное самим
        outPut.setFont(font);//9 задаем шрифт цифрам
        add(outPut);// в панель Panel добавили outPut=new JTextField();
        // 8 делаем Листнер на кнопки (создаем листнер, перебераем кнопки , навешиваем и инитим)
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b= (JButton) e.getSource();
                outPut.setText(outPut.getText()+b.getText());//последовательное
                // отображение нажимаемых кнопок в поле outPut.
            }
        };
        /*ActionListener listener=(ActionEvent e)->{
            JButton b=(JButton) e.getSource();//он принимает кнопку- JButton b что вызвала
            // его .метод getSource возращает объект который вызвал этот метод,
            // кастуем его к(JButton)и теперь привызове этого
            // метода getSource - будет появялться обна из кнопок массива
        };*/
        for (JButton b : buttonNum) {
            b.addActionListener(listener);
        }

        /**
         * добавим аольтернативный метод ввода KeyListener он позволяет
         * обрабатывать нажатие кнопки с клавиатуры
        */
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol=e.getKeyChar();//getKeyChar возвращает букву
                // (символ) нажмем цифру будет цифра, буквву то буква,
                // если таб - то (\t)/// условие буквы(или цыфры ниже)
                if (!Character.isDigit(symbol))//10 ЕСЛИ НАЖАтый символ не число то
                    // выходим из этой функции (ничего не нажимается)
                    return;
                outPut.setText(outPut.getText()+symbol);//иначе печатаем ЧТОТО(только цифры
                // согласно условию)
            }
        });
     /*   addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char symbol=e.getKeyChar();//getKeyChar возвращает букву
                // (символ) нажмем цифру будет цифра, буквву то буква, если таб - то (\t)
                if (Character.isDigit(symbol))//10 ЕСЛИ НАЖАтый символ не число то
                    // выходим из этой функции
                    return;
                outPut.setText(outPut.getText()+symbol);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });*/
    }
}
