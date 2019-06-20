package main.java.org.swingding;

import org.json.*;

import java.util.ArrayList;

public class Map {
    public ArrayList<Entity> layout = new ArrayList<Entity>();

    public Map(int map)
    {
        try
        {
            JSONObject jobj = new JSONObject(FileUtil.fileReader(getClass().getClassLoader().getResource("map_" + map + ".json").getPath()));

            JSONArray wallEntities = jobj.getJSONArray("walls");
            for (int i = 0; i < wallEntities.length(); i++) {
                layout.add(
                        new EntityWall(
                                wallEntities.getJSONObject(i).getJSONObject("position").getInt("x"),
                                wallEntities.getJSONObject(i).getJSONObject("position").getInt("y"),
                                new int[]{
                                        wallEntities.getJSONObject(i).getJSONObject("color").getInt("r"),
                                        wallEntities.getJSONObject(i).getJSONObject("color").getInt("g"),
                                        wallEntities.getJSONObject(i).getJSONObject("color").getInt("b")},
                                getShape(wallEntities.getJSONObject(i).getString("shape")),
                                wallEntities.getJSONObject(i).getInt("direction")
                        )
                );
            }

            JSONArray keyEntities = jobj.getJSONArray("keys");
            for (int i = 0; i < keyEntities.length(); i++) {
                layout.add(
                        new EntityKey(
                                keyEntities.getJSONObject(i).getJSONObject("position").getInt("x"),
                                keyEntities.getJSONObject(i).getJSONObject("position").getInt("y"),
                                new int[]{
                                        keyEntities.getJSONObject(i).getJSONObject("color").getInt("r"),
                                        keyEntities.getJSONObject(i).getJSONObject("color").getInt("g"),
                                        keyEntities.getJSONObject(i).getJSONObject("color").getInt("b")
                                },
                                null,
                                keyEntities.getJSONObject(i).getInt("value")
                        )
                );
            }

            JSONArray doorEntities = jobj.getJSONArray("doors");
            for (int i = 0; i < doorEntities.length(); i++) {
                layout.add(
                        new EntityDoor(
                                doorEntities.getJSONObject(i).getJSONObject("position").getInt("x"),
                                doorEntities.getJSONObject(i).getJSONObject("position").getInt("y"),
                                new int[]{
                                        doorEntities.getJSONObject(i).getJSONObject("color").getInt("r"),
                                        doorEntities.getJSONObject(i).getJSONObject("color").getInt("g"),
                                        doorEntities.getJSONObject(i).getJSONObject("color").getInt("b")
                                },
                                null,
                                doorEntities.getJSONObject(i).getInt("value")
                        )
                );
            }

            JSONObject portal = jobj.getJSONObject("portal");
            layout.add(
                    new EntityPortal(
                            portal.getJSONObject("position").getInt("x"),
                            portal.getJSONObject("position").getInt("y"),
                            new int[]{
                                    portal.getJSONObject("color").getInt("r"),
                                    portal.getJSONObject("color").getInt("g"),
                                    portal.getJSONObject("color").getInt("b")},
                            getShape(portal.getString("shape"))
                    )
            );
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public ArrayList<Entity> getLayout()
    {
        return layout;
    }

    private Shape getShape(String shapeString) {
        switch (shapeString) {
            case "triangle":
                return new ShapeTriangle();
            case "star":
                return new ShapeStar();
            default:
                return new ShapeSquare();
        }
    }
}
