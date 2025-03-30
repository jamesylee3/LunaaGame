package main;

import enemy.Snake;
import object.Door;
import object.Fish;
import object.Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 7 * gp.tileSize;
        gp.obj[0].worldY = 27 * gp.tileSize;

        gp.obj[1] = new Key();
        gp.obj[1].worldX = 1 * gp.tileSize;
        gp.obj[1].worldY = 13 * gp.tileSize;

        gp.obj[2] = new Door();
        gp.obj[2].worldX = 4 * gp.tileSize;
        gp.obj[2].worldY = 5 * gp.tileSize;

        gp.obj[3] = new Fish();
        gp.obj[3].worldX = 4 * gp.tileSize;
        gp.obj[3].worldY = 3 * gp.tileSize;

    }

    public void setEnemy() {
        gp.enemy[0] = new Snake(gp);
        gp.enemy[0].worldX = 25 * gp.tileSize ;
        gp.enemy[0].worldY = 25 * gp.tileSize;
    }
}
