package lab3.hero.at_fight;

public interface HeroAtFight {
    public void kick(HeroAtFight c);

    public boolean isDead();

    public void getDamage(FightHeroDataChange incrementInData);

    public String getHeroName();
}
