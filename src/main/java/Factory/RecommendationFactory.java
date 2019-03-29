package Factory;

public class RecommendationFactory {
    public Recommendations makeRecommendations(String recommendationType){
        if(recommendationType==null){
            return null;
        }
        if(recommendationType.equalsIgnoreCase("trends")){
            return new Trends();
        }

        if(recommendationType.equalsIgnoreCase("genres")){
            return new Genres();
        }
        return null;
    }

//    public static void main(String[] args) {
//        RecommendationFactory rf = new RecommendationFactory();
//        Recommendations obj1 = rf.makeRecommendations("trends");
//        Recommendations obj2 = rf.makeRecommendations("genres");
//        System.out.println(obj1.getRecommendtation());
//        System.out.println(obj2.getRecommendtation());
//    }
}
