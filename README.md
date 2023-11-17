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
