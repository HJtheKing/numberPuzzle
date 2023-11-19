import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class numberPuzzleV1 {
    public static void main(String[] args) throws Exception {
        simplePuzzle();
    }


    private static void simplePuzzle() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int turn = 0;
        List<Integer> lst;
        do {lst = createNums();
        } while (isOrdered(lst));
        System.out.println("간단 숫자 퍼즐");
        while (true){
            System.out.println("Turn " + ++turn);
            System.out.println(lst);
            if (isOrdered(lst)) break;
            while (true) {
                System.out.println("교환할 두 숫자를 입력>");
                StringTokenizer st = new StringTokenizer(br.readLine(), ",", true);
                System.out.println();
                int[] arr = inputCheck(st);
                if (arr != null) {
                    int a = arr[0];
                    int b = arr[1];
                    changeNums(lst, a, b);
                    break;}}}
        System.out.println("\n축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다!");}


    private static int[] inputCheck(StringTokenizer st) {
        boolean bln = true;
        int a = 0, b = 0;
        try {
            a = Integer.parseInt(st.nextToken());
            st.nextToken();
            b = Integer.parseInt(st.nextToken().stripLeading());
            if (st.hasMoreElements()) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                System.out.println();
                bln = false;}
            if (!(1 <= a && a <= 8) || !(1 <= b && b <= 8)) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                System.out.println();
                bln = false;}
        } catch (Exception e) {
            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
            System.out.println();
            bln = false;}
        return bln ? new int[]{a, b} : null;}


    private static boolean isOrdered(List<Integer> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) != i + 1) {
                return false;
            }
        }
        return true;
    }


    private static void changeNums(List<Integer> lst, int a, int b) {
        int idxA = lst.indexOf(a);
        int idxB = lst.indexOf(b);
        int tmp = lst.get(idxA);
        lst.set(idxA, lst.get(idxB));
        lst.set(idxB, tmp);
    }


    private static List<Integer> createNums() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        List<Integer> lst = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != 8) {
            int num = (int) (Math.random() * 8) + 1;
            if (!set.contains(num)) {
                lst.add(num);
                set.add(num);
                sb.append(num);
                if (set.size() != 8) sb.append(", ");
            }
        }
        sb.append("]");
        return lst;
    }
}
