package main;

import enemy.Snake;
import object.Door;
import object.Fish;
import object.Key;
import object.Potion;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new Fish();
        gp.obj[0].worldX = 5 * gp.tileSize;
        gp.obj[0].worldY = 4 * gp.tileSize;

        gp.obj[1] = new Door();
        gp.obj[1].worldX = 5 * gp.tileSize;
        gp.obj[1].worldY = 6 * gp.tileSize;

        gp.obj[2] = new Fish();
        gp.obj[2].worldX = 44 * gp.tileSize;
        gp.obj[2].worldY = 12 * gp.tileSize;

        gp.obj[3] = new Door();
        gp.obj[3].worldX = 44 * gp.tileSize;
        gp.obj[3].worldY = 10 * gp.tileSize;

        gp.obj[4] = new Fish();
        gp.obj[4].worldX = 43 * gp.tileSize;
        gp.obj[4].worldY = 26 * gp.tileSize;

        gp.obj[5] = new Door();
        gp.obj[5].worldX = 43 * gp.tileSize;
        gp.obj[5].worldY = 24 * gp.tileSize;

        gp.obj[6] = new Fish();
        gp.obj[6].worldX = 18 * gp.tileSize;
        gp.obj[6].worldY = 40 * gp.tileSize;

        gp.obj[7] = new Door();
        gp.obj[7].worldX = 18 * gp.tileSize;
        gp.obj[7].worldY = 38 * gp.tileSize;

        gp.obj[8] = new Fish();
        gp.obj[8].worldX = 44 * gp.tileSize;
        gp.obj[8].worldY = 45 * gp.tileSize;

        gp.obj[9] = new Door();
        gp.obj[9].worldX = 44 * gp.tileSize;
        gp.obj[9].worldY = 43 * gp.tileSize;

        gp.obj[10] = new Key();
        gp.obj[10].worldX = 4 * gp.tileSize;
        gp.obj[10].worldY = 24 * gp.tileSize;

        gp.obj[11] = new Key();
        gp.obj[11].worldX = 15 * gp.tileSize;
        gp.obj[11].worldY = 11 * gp.tileSize;

        gp.obj[12] = new Key();
        gp.obj[12].worldX = 40 * gp.tileSize;
        gp.obj[12].worldY = 4 * gp.tileSize;

        gp.obj[13] = new Key();
        gp.obj[13].worldX = 29 * gp.tileSize;
        gp.obj[13].worldY = 26 * gp.tileSize;

        gp.obj[14] = new Key();
        gp.obj[14].worldX = 3 * gp.tileSize;
        gp.obj[14].worldY = 42 * gp.tileSize;

        gp.obj[15] = new Potion();
        gp.obj[15].worldX = 2 * gp.tileSize;
        gp.obj[15].worldY = 33 * gp.tileSize;

        gp.obj[16] = new Potion();
        gp.obj[16].worldX = 44 * gp.tileSize;
        gp.obj[16].worldY = 34 * gp.tileSize;

        gp.obj[17] = new Potion();
        gp.obj[17].worldX = 46 * gp.tileSize;
        gp.obj[17].worldY = 9 * gp.tileSize;
    }

    public void setEnemy() {
        gp.enemy[0] = new Snake(gp);
        gp.enemy[0].worldX = 5 * gp.tileSize ;
        gp.enemy[0].worldY = 25 * gp.tileSize;

        gp.enemy[1] = new Snake(gp);
        gp.enemy[1].worldX = 15 * gp.tileSize ;
        gp.enemy[1].worldY = 12 * gp.tileSize;

        gp.enemy[2] = new Snake(gp);
        gp.enemy[2].worldX = 23 * gp.tileSize ;
        gp.enemy[2].worldY = 12 * gp.tileSize;

        gp.enemy[3] = new Snake(gp);
        gp.enemy[3].worldX = 39 * gp.tileSize ;
        gp.enemy[3].worldY = 6 * gp.tileSize;

        gp.enemy[4] = new Snake(gp);
        gp.enemy[4].worldX = 40 * gp.tileSize ;
        gp.enemy[4].worldY = 17 * gp.tileSize;

        gp.enemy[5] = new Snake(gp);
        gp.enemy[5].worldX = 40 * gp.tileSize ;
        gp.enemy[5].worldY = 12 * gp.tileSize;

        gp.enemy[6] = new Snake(gp);
        gp.enemy[6].worldX = 5 * gp.tileSize ;
        gp.enemy[6].worldY = 8 * gp.tileSize;

        gp.enemy[7] = new Snake(gp);
        gp.enemy[7].worldX = 11 * gp.tileSize ;
        gp.enemy[7].worldY = 25 * gp.tileSize;

        gp.enemy[8] = new Snake(gp);
        gp.enemy[8].worldX = 6 * gp.tileSize ;
        gp.enemy[8].worldY = 43 * gp.tileSize;

        gp.enemy[9] = new Snake(gp);
        gp.enemy[9].worldX = 14 * gp.tileSize ;
        gp.enemy[9].worldY = 45 * gp.tileSize;

        gp.enemy[10] = new Snake(gp);
        gp.enemy[10].worldX = 30 * gp.tileSize ;
        gp.enemy[10].worldY = 43 * gp.tileSize;

        gp.enemy[11] = new Snake(gp);
        gp.enemy[11].worldX = 35 * gp.tileSize ;
        gp.enemy[11].worldY = 36 * gp.tileSize;

        gp.enemy[12] = new Snake(gp);
        gp.enemy[12].worldX = 19 * gp.tileSize ;
        gp.enemy[12].worldY = 32 * gp.tileSize;

        gp.enemy[13] = new Snake(gp);
        gp.enemy[13].worldX = 30 * gp.tileSize ;
        gp.enemy[13].worldY = 28 * gp.tileSize;

        gp.enemy[14] = new Snake(gp);
        gp.enemy[14].worldX = 37 * gp.tileSize ;
        gp.enemy[14].worldY = 21 * gp.tileSize;

        gp.enemy[15] = new Snake(gp);
        gp.enemy[15].worldX = 14 * gp.tileSize ;
        gp.enemy[15].worldY = 45 * gp.tileSize;
    }
}
