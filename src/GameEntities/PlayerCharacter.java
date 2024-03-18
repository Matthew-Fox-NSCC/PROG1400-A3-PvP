package GameEntities;

public class PlayerCharacter extends GameCharacter {
    public String classType;
    private Equipment weapon;
    private Equipment armor;

    public PlayerCharacter() {
        super();
    }

    public void equipWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

    public void equipArmor(Equipment armor) {
        this.armor = armor;
    }
}
