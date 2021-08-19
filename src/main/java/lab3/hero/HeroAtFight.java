package lab3.hero;

public interface HeroAtFight {
    public void kick(HeroAtFight c);

    public boolean isDead();

    public void getDamage(FightHeroDataChange incrementInData);

    public String getHeroName();
}
