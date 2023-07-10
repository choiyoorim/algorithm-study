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
  

  

