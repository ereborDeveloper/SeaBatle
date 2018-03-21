import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<String> position = new ArrayList<>();
    private boolean alive = true;
    private int deck;

    public Ship(int n, List<String> lst) {
        deck = n;
        position = lst;
        String c = null;
        switch (deck) {
            case (1):
                c = "����";
                break;
            case (2):
                c = "����";
                break;
            case (3):
                c = "����";
                break;
            case (4):
                c = "�������";
                break;
        }

        //System.out.println(c+"�������� ������� ���������� � ������ "+position.get(0)+ " �� "+position.get(position.size()-1));
    }

    public List<String> getPosition() {
        return (this.position);
    }

    public int delete(String x) {
        if (position.contains(x)) {
            position.remove(x);
            if (position.isEmpty()) return 1;
            return 2;
        } else return 0;
    }
}
