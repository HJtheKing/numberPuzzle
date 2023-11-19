# numberPuzzle
## v1
### 메서드 설명
- **simplePuzzle**() : 종합적인 단순 퍼즐 생성 메서드.
- int[] **inputCheck**(StringTokenizer st) : 입력값의 정상 여부 확인.<br/>매개변수 StringTokenizer가 정상적인 입력값이면 int[] 배열에 입력값 return, 그렇지 않으면 메세지 출력 후 null return.
- boolean **isOrdered**(List<Integer> lst) : 퍼즐(배열)이 정렬 되었는지 확인.([1,2,3,4,5,6,7,8])
- void **changeNums**(List<Integer> lst, int a, int b) : 퍼즐(배열)의 위치 교환.
- List<Integer> **createNums**() : 무작위 퍼즐(배열) 생성.

### 풀이
1. **createNums** 메서드로 퍼즐(배열) 생성. do-while문 통하여 혹여 이미 완성된 퍼즐이 사용자에게 전달되는 것을 방지.
2. 외부 while문으로 Turn과 퍼즐(배열)을 출력. 퍼즐이 정렬(**isOrdered**)되어 있으면 외부 while문 break.
3. 내부 while문에서 BufferedReader와 StringTokenizer를 통해 입력 받은 값을 **inputCheck** 메서드를 통하여 int[] arr 변수에 할당.<br/>할당 값이 int 배열이면 정상적인 입력값, null이면 비정상적인 입력값.
4. 입력 값이 정상적이라면(if(arr != null)), int 변수 a, b에 arr 배열값 할당 후 **changeNums** 메서드로 퍼즐의 두 수를 교환.
5. 퍼즐을 풀었으면 축하메세지 출력

### 실행결과
- 비정상적인 입력\*시 메세지 출력 후 다시 입력을 받음<br/>\*비정상적 입력 예시 + 입력이 두 개 초과/두번째 입력 값 뒤에 공백
- 정상적인 입력값을 받으면 두 수 교환하여 증가된 턴과 함께 배열 값 출력
- 퍼즐이 정렬을 마치면 축하 메세지 출력 및 프로그램 종료

## v2
### 메서드 설명
- boolean **isOrdered**(Object[] lst) : 퍼즐(배열)이 정렬 되었는지 확인.
- int **changeLocation**(Object[] lst, int num) : 위치를 변경하기 위해선 빈칸과 입력 숫자가<br/>1. 같은 행 + 둘의 열 차이가 1이거나<br/>2. 같은 열 + 둘의 행 차이가 1이어야 함<br/>해당 조건을 만족하면 위치를 변경하고 1을 반환, 그렇지 않다면 -1 반환
- int **findNum**(Object[] lst, int num) : Object 배열에서 num의 index 값을 반환.(**changeLocation** 메서드에 사용)
- int **findBlank**(Object[] lst) : Object 배열에서 빈 칸의 index 값을 반환.(**changeLocation** 메서드에 사용)
- void **printPuzzle**(Object[] lst) : 퍼즐(배열)을 출력.
- Object[] createPuzzle() : 퍼즐(배열) 생성. 1~15 무작위 값을 생성하여 Object 배열의 해당 index에 빈 칸(" ") 할당.

### 풀이
1. **createPuzzle** 메서드로 퍼즐(배열) 생성.
2. 외부 while문에서 현재 turn과 배열을 출력하게 하였으며, 퍼즐이 정렬(**isOrdered**)되어 있으면 break.
3. 내부 while문에서 값을 입력 받고, 숫자가 아님/옮길 수 없는 위치의 숫자인 경우 예외를 띄워 다시 입력하게 함. 정상적으로 입력했을 시 break.
4. 퍼즐을 풀었으면 축하메세지 출력

### 실행결과
- 무작위 퍼즐이 생성.
- 문자/범위를 벗어난 숫자/위치를 옮길 수 없는 숫자 입력시 오류 메세지와 함께 재입력.
- 올바른 값 입력시 증가된 turn과 변경된 퍼즐 표시 및 숫자 입력창 띄움.
- 퍼즐을 완성 시 완성된 퍼즐, turn과 함께 축하메세지.
