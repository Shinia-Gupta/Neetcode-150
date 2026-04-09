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
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>()));
            for(int followingUser:followerMap.getOrDefault(userId, new HashSet<>())){
feed.addAll(tweetMap.getOrDefault(followingUser,new ArrayList<>()));
            }
feed.sort((a,b)->b[0]-a[0]);
List<Integer> res=new ArrayList<>();
for(int i=0;i<Math.min(10,feed.size());i++){
res.add(feed.get(i)[1]);
}
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
