import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main
{
    // 에라토스 테네스의 체 배열 (소수 판별용)
    private static final boolean[] IS_NOT_PRIME = eratosthenes();
    
    // 왼쪽 배열 (이분매칭의 기준)
    private static int[] left;
    
    // 오른쪽 배열
    private static int[] right;
    
    // 노드 연결 여부
    private static boolean[][] hasNode;
    
    // 방문 여부
    private static boolean[] isVisit;
    
    // 매칭된 수
    private static int[] matched;
    
    // 현재 선택 중인 수
    private static int selected;
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력값 갯수
        int N = Integer.parseInt(reader.readLine());
        
        // 입력값 배열
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 첫 번째 수가 홀수일 경우
        if (numbers[0] % 2 != 0)
        {
            // 왼쪽 배열에 홀수를 할당
            left = Arrays.stream(numbers).filter(value -> value % 2 != 0).toArray();
            right = Arrays.stream(numbers).filter(value -> value % 2 == 0).toArray();
        }
        
        // 첫 번째 수가 짝수일 경우
        else
        {
            // 왼쪽 배열에 짝수를 할당
            left = Arrays.stream(numbers).filter(value -> value % 2 == 0).toArray();
            right = Arrays.stream(numbers).filter(value -> value % 2 != 0).toArray();
        }
        
        // 홀수 배열과 짝수 배열의 수가 동일할 경우 (이분매칭 가능)
        if (left.length == right.length)
        {
            hasNode = new boolean[left.length][right.length];
            
            // left의 첫 번째 행은 기준 매칭이므로 이분 매칭에서 제외한다.
            for (int i = 1; i < left.length; i++)
            {
                for (int j = 0; j < right.length; j++)
                {
                    int ref = left[i] + right[j];
                    
                    // left[i] + right[j]의 값이 소수일 경우
                    if (!IS_NOT_PRIME[ref])
                    {
                        // 노드를 연결한다.
                        hasNode[i][j] = true;
                    }
                }
            }
            
            LinkedList<Integer> list = new LinkedList<>();
            
            // 첫 번째 수와 상대 그룹의 요소를 하나씩 매칭해본다.
            for (int i = 0; i < N / 2; i++)
            {
                // left[0]와 right[i]의 합이 소수일 경우
                if (!IS_NOT_PRIME[left[0] + right[i]])
                {
                    selected = i;
                    
                    int size = bipartite();
                    
                    // 모든 요소가 매칭될 경우
                    if (size == N / 2)
                    {
                        list.add(right[selected]);
                    }
                }
            }
            
            // 하나도 매칭되지 않은 경우
            if (list.size() == 0)
            {
                writer.write("-1");
            }
            
            // 매칭이 하나 이상 있을 경우
            else
            {
                // 오름차순으로 정렬
                list.sort(Integer::compareTo);
                
                StringBuilder builder = new StringBuilder();
                
                for (int item : list)
                {
                    builder.append(item).append(" ");
                }
                
                writer.write(builder.toString().trim());
            }
        }
        
        // 홀수 배열과 짝수 배열의 수가 동일하지 않을 경우 (이분매칭 불가능)
        else
        {
            writer.write("-1");
        }
        
        writer.newLine();
        writer.close();
        reader.close();
    }

    private static int bipartite()
    {
        // 이미 left[0]과 right 요소 하나가 선택됨
        int size = 1;
        
        matched = new int[left.length];
        
        Arrays.fill(matched, -1);
        
        for (int i = 1; i < left.length; i++)
        {
            isVisit = new boolean[left.length];
            
            // 매칭 가능할 경우
            if (dfs(i))
            {
                size++;
            }
        }
        
        return size;
    }
    
    private static boolean dfs(int num)
    {
        // 첫 방문일 경우
        if (!isVisit[num])
        {
            isVisit[num] = true;
            
            for (int i = 0; i < right.length; i++)
            {
                // 연결된 노드가 있으며, 첫 번째 숫자와 매칭된 숫자가 아니며, 소수일 경우
                if (hasNode[num][i] && i != selected && !IS_NOT_PRIME[left[num] + right[i]])
                {
                    // 매칭이 아직 되지 않았거나, 매칭된 숫자가 다른 숫자와 매칭될 수 있을 경우
                    if (matched[i] == -1 || dfs(matched[i]))
                    {
                        matched[i] = num;
                        
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private static boolean[] eratosthenes()
    {
        boolean[] isNotPrime = new boolean[2000];
        
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        
        int maxPrime = (int) Math.ceil(Math.sqrt(2000));
        
        for (int i = 2; i < maxPrime; i++)
        {
            // 소수일 경우
            if (!isNotPrime[i])
            {
                for (int j = i + i; j < isNotPrime.length; j += i)
                {
                    // 아직 소수가 아님을 표시하지 않았을 경우
                    if (!isNotPrime[j])
                    {
                        // 소수의 배수는 소수가 아니므로 제외함
                        isNotPrime[j] = true;
                    }
                }
            }
        }
        
        return isNotPrime;
    }
}
