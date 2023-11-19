import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class numberPuzzleV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberPuzzleV2 v2 = new numberPuzzleV2();
        System.out.println("재미있는 15 퍼즐!");
        Object[] lst = v2.createPuzzle();
        int turn = 0;
        while (true) {
            System.out.println("\nTurn " + ++turn);
            v2.printPuzzle(lst);
            if (v2.isOrdered(lst)) break;
            int num;
            while (true) {
                System.out.print("숫자 입력> ");
                try {
                    num = Integer.parseInt(br.readLine());
                    if (v2.changeLocation(lst, num) == -1) throw new Exception();
                    break;
                } catch (Exception e) {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                    continue;}}}
        System.out.println("\n축하합니다! " + turn + "턴만에 퍼즐을 완성했습니다!");}


    private boolean isOrdered(Object[] lst) {
        for (int i = 0; i < lst.length - 1; i++) {
            try {
                if (i + 1 != (int) lst[i]) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }


    private int changeLocation(Object[] lst, int num) {
        int blankIdx = findBlank(lst);
        int numIdx = findNum(lst, num);
        if (blankIdx % 4 == numIdx % 4 && Math.abs(blankIdx / 4 - numIdx / 4) == 1) {
            lst[blankIdx] = lst[numIdx];
            lst[numIdx] = " ";
            return 1;
        } else if (blankIdx / 4 == numIdx / 4 && Math.abs(blankIdx % 4 - numIdx % 4) == 1) {
            lst[blankIdx] = lst[numIdx];
            lst[numIdx] = " ";
            return 1;
        } else {
            return -1;
        }
    }


    private int findNum(Object[] lst, int num) {
        for (int i = 0; i < lst.length; i++) {
            try {
                if ((int)lst[i] == num) return i;
            } catch (Exception e) {}
        }
        return -1;
    }


    private int findBlank(Object[] lst) {
        for (int i = 0; i < lst.length; i++) {
            if (lst[i] == " ") return i;
        }
        return -1;
    }


    private void printPuzzle(Object[] lst) {
        for (int i = 0; i < lst.length; i++) {
            try {
                if ((int) lst[i] >= 10) {
                    System.out.print("[" + lst[i] + "]");
                } else {
                    System.out.print("[ " + lst[i] + "]");
                }
            } catch (Exception e) {
                System.out.print("[ " + lst[i] + "]");
            }
            if (i % 4 == 3) {
                System.out.println();
            }
        }
    }


    private Object[] createPuzzle() {
        Object[] lst = new Object[16];
        int blankIdx = (int) (Math.random() * 15) + 1;
        lst[blankIdx] = " ";
        int lstIdx = 0;
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != 15) {
            int num = (int) (Math.random() * 15) + 1;
            if (set.contains(num)) {
                continue;
            } else {
                set.add(num);
                if (blankIdx == lstIdx) {lst[++lstIdx] = num;}
                else {lst[lstIdx] = num;}
                lstIdx++;
            }}
        return lst;}


}

