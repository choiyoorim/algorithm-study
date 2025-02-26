# algorithm-study
## 📓 알고리즘을 자바로 공부합니다
- 공부한 내용은 readme 파일에 정리합니다.

- 문제를 푼 날짜, 문제 출처, 문제 번호와 함께 커밋합니다.

- 이후에 수정한 문제는 Fix를 붙여 표시합니다.


## 📕 Java 배열 
### Arrays.sort()
    String과 int 배열을 쉽게 정렬 가능
    
    기본적으로 Comparable 구현에 의해 정렬된 것
    
    ** Comparable은 정렬 기준이 되는 메소드를 정의하는 인터페이스로 해당 인터페이스에서 compareTo() 메소드를 오버라이딩하여 구현함
   
    => Arrays.sort()를 실행하면 Comparable 인터페이스 내부의 compartTo 메소드를 실행하여 정렬하는 것과 같다

  ⭐️ 오름차순 정렬
  
    default 값이기 때문에 Arrays.sort()로 사용함

  ⭐️ 내림차순 정렬
    
    내림차순으로 정렬하려면 sort()의 인자에 추가로 Collections.reverseOrder()를 전달해야함.
  
    ex) Arrays.sort(array, Collections.reverseOrder());

    이는 인터페이스 내부의 compareTo 메소드를 오버라이딩하는 것과 같다

## 📕  ArrayList
배열과 같은 기능을 수행하며 0부터 인덱스를 시작하지만, 배열과 달리 가변적이므로 활용도가 높음

| 기능 | 함수명 |
| --- | --- |
| 값 추가 | .add() |
| 값 제거  | .remove() |
| 값 존재 확인 | .contains() |
| 길이 | .size() |

⇒ 2차원 arraylist를 생성하려면 각각의 배열[index]를 ArrayList로 선언해주면 됨

ex) ArrayList<Node>[] arr = new ArrayList<>[N];

## 📕  유니온 파인드 알고리즘
여러 노드가 있을 때 특정 2개의 노드를 연결해 1개의 집합으로 묶는 union 연산과 두 노드가 같은 집합에 속해 있는지를 확인하는 find 연산으로 구성되어 있는 알고리즘

⇒ 핵심 이론은 union, find 연산!

union 연산 : 각 노드가 속한 집합을 1개로 합치는 연산, 노드 a,b가 각각 A, B 집합에 속해 있을 때 union(a,b)는 A와 B의 합집합을 말함

find 연산 : 특정 노드 a에 관해 a가 속한 집합의 대표 노드를 반환하는 연산, 노드 a가 A의 집합일 때, find(a)는 A집합의 대표 노드를 반환함

⇒ 구현 방법

- 1차원 배열 이용, 노드가 연결되어 있지 않으므로 각 노드가 대표 노드가 됨 
각 노드가 모두 대표 노드이므로 배열은 자신의 인덱스 값으로 초기화
- 2개의 노드를 선택해 각각의 대표 노드를 찾아 연결하는 union 연산을 수행, (1,4),(5,6)을 연결해보자
⇒ 1은 대표노드, 4는 자식노드가 됨 배열 인덱스 4의 값을 대표노드인 1로 수정
⇒ 5가 대표노드, 6은 자식 노드가 되면 배열[6]의 값을 5로 수정
⇒ (4,6)을 union 연산해보면 어떻게 될까?
⇒ 각자 대표 노드가 아니므로 각 노드의 대표 노드를 찾아 올라간 다음 그 대표 노드를 연결함
- find 연산은 자신이 속한 집합의 대표 노드를 찾는 연산, 단순히 대표 노드를 찾는 역할만 하는 것이 아니라 그래프를 정돈하고 시간 복잡도를 향상시킴
⇒ 대상 노드 배열에 index 값과 value 값이 동일한지 확인
⇒ 동일하지 않으면 value 값이 가리키는 index 위치로 이동
⇒ 이동 위치의 index값과 value 값이 같을 때까지 앞의 과정을 반복(재귀함수로 구현)
⇒ 대표 노드에 도달하면 재귀함수를 빠져나오면서 거치는 모든 노드 값을 루트 노드값으로 변경
- 연산을 할 때 거치는 노드들이 대표 노드와 바로 연결되는 형태로 변경됨, 추후 노드와 관련된 find 연산 속도가 o(1)로 변경됨 ⇒ 경로 압축의 효과
arr[1].add(new Node());

⭐️ 정렬
    배열과 달리 Collections.sort()를 사용하면 됨

## 📕  위상정렬
정렬 알고리즘의 일종으로, 사이클이 없는 방향 그래프에서 노드 순서를 찾는 알고리즘

순서가 정해져 있는 일련의 작업을 차례대로 수행해야 할 때 사용할 수 있는 알고리즘

⇒ 사이클이 없는 방향그래프에서 모든 노드를 방향성에 거스르지 않도록 순서대로 나열하는 것

사이클이 존재하면 노드 간의 순서를 명확하게 정의 불가, 위상 정렬은 여러가지 결과를 가질 수 있음

<진입차수>

특정한 노드로 들어오는 간선의 개수

<진출차수>

특정한 노드에서 나가는 간선의 개수

위상 정렬 알고리즘의 순서

> 진입차수가 0인 노드를 큐에 넣는다.
> 

> 큐가 빌 때까지 다음의 과정을 반복한다. 
① 큐에서 원소를 꺼내 해당 노드에서 나가는 간선을 그래프에서 제거, 진입 차수 배열에서 해당 간선이 가리키고 있던 노드들의 진입 차수를 1씩 뺌
② 새롭게 진입차수가 0이 된 노드를 큐에 삽입
>
> 


## 📕  다익스트라 알고리즘
그래프에서 최단 거리를 구하는 알고리즘, 에지는 모두 양수라는 특징을 가짐

특정 노드에서 다른 노드들의 최단 거리를 구하는 문제

1. 인접 리스트로 그래프 구현하기
인접 리스트에 연결한 배열의 자료형은 (노드, 가중치)와 같은 형태로 선언하여 연결
2. 최단 거리 배열 초기화하기
최단 거리 배열을 만들고 출발 노드는 0, 이외의 노드는 무한으로 초기화, 무한은 적당히 큰 값을 사용하면 됨
3. 값이 가장 작은 노드 고르기
최단 거리 배열에서 현재 값이 가장 작은 노드를 고름, 여기서는 값이 0인 출발 노드에서 시작하면 됨
4. 최단 거리 배열 업데이트하기
선택된 노드에 연결된 에지의 값을 바탕으로 다른 노드의 값을 업데이트
1단계에서 저장해 놓은 연결 리스트를 이용해 현재 선택된 노드의 에지들을 탐색하고 업데이트하면 됨
연결 노드의 최단 거리는 다음과 같이 두 값 중 더 작은 값으로 업데이트
⇒ 최단 거리 업데이트 방법 : Min(선택 노드의 최단 거리 배열의 값 + 에지 가중치, 연결 노드의 최단 거리 배열의 값)
5. 과정 3, 4를 반복해 최단 거리 배열 완성하기
모든 노드가 처리될 때까지 과정 3~4 반복, 과정 4에서 선택 노드가 될 때마다 다시 선택되지 않도록 방문배열을 만들어 처리, 모든 노드가 선택될 때까지 반복하면 최단 거리 배열이 완성됨

⇒ 완성된 최단 거리 배열은 출발 노드와 이외의 모든 노드 간의 최단 거리를 표현함


## 📕  투포인터 
[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/164a2455f67fcea49bb46217752a6dfe9e9e8ba0/PRO178870T/PRO178870T.java)

[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/f16bfc7a7dd8389a078f469617901a1e68cf4bb8/PRO118667/PRO118667.java) : (큐 자료구조의 특성을 고려 + 슬라이딩 윈도우 방식 도입)

## 📕  HashMap
[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/164a2455f67fcea49bb46217752a6dfe9e9e8ba0/PRO258712T/PRO258712T.java) 

[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/a7142ad498da52bdc3921ab65ac555ad6801b2be/PRO138476/PRO138476.java) : HashMap Value 정렬 방식 참고

[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/f16bfc7a7dd8389a078f469617901a1e68cf4bb8/PRO131127/PRO131127.java) : HahsMap KeySet 활용

## 📕  LocalTime 활용법
[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/164a2455f67fcea49bb46217752a6dfe9e9e8ba0/PRO340213/PRO340213.java)

## 📕  Greedy 알고리즘
[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/164a2455f67fcea49bb46217752a6dfe9e9e8ba0/PRO181188/PRO181188.java)

## 📕  슬라이딩 윈도우
[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/a7142ad498da52bdc3921ab65ac555ad6801b2be/PRO131701/PRO131701.java) : +) HashSet 활용 

## 📕  Stack 활용 
[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/a7142ad498da52bdc3921ab65ac555ad6801b2be/PRO154539/PRO154539.java)

## 📕  DFS 활용
[관련 문제 보기](https://github.com/choiyoorim/algorithm-study/blob/f16bfc7a7dd8389a078f469617901a1e68cf4bb8/PRO87946/PRO87946.java)

