class Twitter {
private HashMap<Integer,List<int[]>> tweetMap;
private HashMap<Integer,HashSet<Integer>> followerMap;
private int time;
    public Twitter() {
        tweetMap=new HashMap<>();
        followerMap=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        //long syntax
        time++;
        //check if user id exists in tweetmap..
if(tweetMap.containsKey(userId))
        //if it exists, add the tweetid for that user..
{
List<int[]> tweets=tweetMap.get(userId);
tweets.add(new int[]{time,tweetId});
tweetMap.put(userId,tweets);
}
        //otherwise create a new user with tweetid map
    else{
List<int[]> newTweetList=new ArrayList<>();
newTweetList.add(new int[]{time,tweetId});
tweetMap.put(userId,newTweetList);

    }

//short syntax
// time++;
// tweetMap.putIfAbsent(userId,new ArrayList<>());
// tweetMap.get(userId).add(new int[]{time,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {  //nlogn tc
PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);

List<int[]> tweets=tweetMap.getOrDefault(userId,new ArrayList<>());
tweets.forEach(minHeap::offer);
        // while(minHeap.size()>Math.min(10,tweets.size())){
        //             minHeap.poll();
        //         }
            for(int followingUser:followerMap.getOrDefault(userId, new HashSet<>())){
tweets=tweetMap.getOrDefault(followingUser,new ArrayList<>());
tweets.forEach(minHeap::offer);


// feed.addAll(tweetMap.getOrDefault(followingUser,new ArrayList<>()));
            }
                            while(minHeap.size()>10){
                    minHeap.poll();
                }
// feed.sort((a,b)->b[0]-a[0]);
List<Integer> res=new ArrayList<>();
// for(int i=0;i<minHeap.size();i++){
// res.add(minHeap.poll()[1]);
// }
while(!minHeap.isEmpty()){
  res.add(minHeap.poll()[1]);
  
}
Collections.reverse(res);
return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId!=followeeId){
        followerMap.putIfAbsent(followerId,new HashSet<Integer>());
        followerMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
                followerMap.getOrDefault(followerId,new HashSet<>()).remove(followeeId);

    }
}
