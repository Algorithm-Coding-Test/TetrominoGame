
# Tetromino Game
## 테트로미노
BAEKJOON ONLINE JUDGE
14500번 문제


#### 문제
[https://www.acmicpc.net/problem/14500](https://www.acmicpc.net/problem/14500)

주어진 5가지 경우의 테트로미노에 회전과 대칭을 시키면 4개의 정사각형으로 만들 수 있는 모든 테트로미노에 대해 최대값을 구하는 문제와 동일하다.

#### 실패한 풀이
처음에 시도했던 풀이는 아래와 같다.
보드 안의 모든 좌표에 대하여, 각 좌표를 포함하는 4개의 정사각형으로 만들 수 있는 최대값 테트로미노를 BFS 알고리즘으로 탐색한다.

> 해당 풀이는 반복문 4개가 중첩되어 최악의 시간 복잡도를 가지며, 
> 동일한 테트로미노를 중복하여 찾는다는 단점이 있다.

#### 성공한 풀이

테트로미노 내 값들의 합을 구하는 문제는 *Image Filtering* 개념을 사용하여 문제를 해결했다.

> 테트로미노를 Filter로 사용하여 아래와 같이 수행한다.

 **![](https://lh5.googleusercontent.com/Eqz4eXtaTmq9-1SVAFXPf5YCx0CvLILk6YW_Ds62GLUBj3zwgHegzyMzYRZS7nE4E22tHzY10MWHcN5rqlg512GEiRFvnPdzO_Ef4NoVT9LMrt5W-Kg5qs4H0LfphFypCSe5GObs)**


 1. `board`에 다음과 같이 zero padding 처리를 수행한다.

![](https://lh4.googleusercontent.com/YrHzTRNOGf8XScASaEdca6vYiQ047hDIg30BEK7PzaV1dCFGd5W_pbwsJvFC0gnvenSq8RcrWeOLbh-M6HG-LoCM0lh-gw_AayBJNSaaozyOgHxMndz0Qr_XroRwcf_TeGWiANjO)

 *zero padding을 수행하면, 배열 인덱스 범위를 초과 여부를 조건문을 통해 검사할 필요가 없다.*

 2. `board` 내 각 좌표를 포함하는,  5가지 테트로미노로 만들 수 있는 모든 테트로미노에 대하여 `ArrayList<Integer> tempValue`에 삽입한다.
 3. `tempValue` 내에서 최대값을 확인하여 `int maxValue`를 갱신한다.
