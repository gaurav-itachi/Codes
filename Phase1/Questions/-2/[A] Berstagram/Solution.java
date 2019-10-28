import java.util.*;
import java.util.stream.*;
public class Solution {
    public static void main(String args[]	){
        Scanner scanner = new Scanner(System.in);
        Integer n,m;
        n=scanner.nextInt();
        Berstagram bs = new Berstagram(n);
        m=scanner.nextInt();
        IntStream.range(0,m).forEach(i->{
            Integer x = scanner.nextInt();
            bs.likePost(x);
        });
        bs.print();

    }

    static class Berstagram{
        private int n;
        private Map<Integer,Integer> curPos,minPos,maxPos,posToPost;
        public Berstagram(Integer n ){
            this.n = n;
            curPos = new HashMap<>(n);
            minPos = new HashMap<>(n);
            maxPos = new HashMap <>(n);
            posToPost = new HashMap<>(n);
            IntStream.range(1,n+1).forEach(i->{
                curPos.put(i,i);
                minPos.put(i, i);
                maxPos.put(i ,i);
                posToPost.put(i,i);
            });

        }
        public void likePost(Integer post){
            if(post <= 0 || post>this.n){
                return;
            }
            if(curPos.get(post) == 1 ){
                return ;
            }
            Integer otherPost = posToPost.get(curPos.get(post)-1);
            curPos.put(post,curPos.get(post)-1);
            curPos.put(otherPost,curPos.get(otherPost)+1);
            minPos.put(post,Math.min(curPos.get(post), minPos.get(post) ) );
            maxPos.put(otherPost,Math.max(curPos.get(otherPost), maxPos.get(otherPost) ) );
            posToPost.put( curPos.get(post) ,post );
            posToPost.put( curPos.get(otherPost),otherPost);
        }

        public void print(){
            IntStream.range(1,n+1).forEach(i->{
                System.out.println(minPos.get(i)+" "+maxPos.get(i));
            });
        }

    }

}

