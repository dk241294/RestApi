package endToEnd;

public  class UpdatePayLoad {
    static public String update() {
       // AddPlace ad = new AddPlace();
        String placeId = AddPlace.placeId;
        return "{   \"place_id\": \""+placeId+"\",\n" +
                "\"address\":\"70 Summer walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n" +
                "\n";
    }
}
