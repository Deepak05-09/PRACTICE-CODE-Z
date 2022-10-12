interface SpaceShip{
    boolean launch();
    boolean land();
    boolean canCarry(Item item,int weight);
    void carry(Item object);

}