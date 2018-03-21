import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SeaBattle {
    public static void main(String args[]) throws IOException {
        Game you = new Game();
        Game computer = new Game();
        AI PC = new AI();
        System.out.println("�������������...");
        Singleton.getInstance().setGrid();
        System.out.println("������������! ���� ����� " + PC.getName(1) + ". ������� ������������ � ��������� ���������.");
        System.out.println("���� ��������");
        you.start();
        computer.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        int checkResult = 0;
        int humanCheck = 0;
        int a = 0;
        while (true) {
            try {
                do {
                    in = br.readLine();
                    in = in.toUpperCase();
                    if (!you.isexist(in)) {
                        throw new Exception();
                    }
                    humanCheck = you.check(in);
                    if (humanCheck == -1) System.out.println("�� ��� �������� ����");
                    if (humanCheck == 1) System.out.println("���.. ����� ��������");
                    if (humanCheck == 2) System.out.println("��� ���!");
                } while (humanCheck == -1 || humanCheck == 1 || humanCheck == 2);
                if (you.check(in) == 3) {
                    you.result();
                    System.out.println("�� ��������! �� ������� �������� ����������");
                    break;
                }

                do {
                    System.out.println(PC.getName(1) + " ������...");
                    Thread.sleep(1000);
                    in = PC.computerChecker(checkResult);
                    System.out.println(in);
                    if (!computer.isexist(in)) {
                        throw new Exception();
                    }
                    checkResult = computer.check(in);
                    if (checkResult == 1) System.out.println(PC.getName(1) + ": ������ � ������� ���� �������!");
                    if (checkResult == 2) System.out.println("��-��-��");
                }
                while (checkResult == -1 || checkResult == 1 || checkResult == 2);
                a++;
                System.out.println(checkResult);
                if (checkResult == 3) {
                    computer.result();
                    System.out.println(PC.getName(1) + " �������! ����� ��� ��������: " + a);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("�������� ����");
            }
        }
    }
}